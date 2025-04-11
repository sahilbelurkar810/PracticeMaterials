terraform {
  required_providers {
    azurerm = {
      source  = "hashicorp/azurerm"
      version = "=2.91.0"
    }
  }
}

provider "azurerm" {
  features {}
}

resource "azurerm_resource_group" "web-rg" {
  name     = "Website-rg"
  location = "East Us"

  tags = {
    environment = "dev"
  }
}

resource "azurerm_virtual_network" "web-vnet" {
  name                = "website-vnet"
  location            = azurerm_resource_group.web-rg.location
  resource_group_name = azurerm_resource_group.web-rg.name
  address_space       = ["10.12.0.0/16"]

  tags = {
    environment = "dev"
  }

}

resource "azurerm_subnet" "web-subnet" {
  name                 = "website-subnet"
  virtual_network_name = azurerm_virtual_network.web-vnet.name
  resource_group_name  = azurerm_resource_group.web-rg.name
  address_prefixes     = ["10.12.1.0/24"]
}

resource "azurerm_public_ip" "web-pip" {
  name                = "website-pip"
  location            = azurerm_resource_group.web-rg.location
  resource_group_name = azurerm_resource_group.web-rg.name
  allocation_method   = "Dynamic"

}

resource "azurerm_network_interface" "web-nic" {
  name                = "webiste-nic"
  resource_group_name = azurerm_resource_group.web-rg.name
  location            = azurerm_resource_group.web-rg.location

  ip_configuration {
    name                          = "webIPConfig"
    subnet_id                     = azurerm_subnet.web-subnet.id
    private_ip_address_allocation = "Dynamic"
    public_ip_address_id          = azurerm_public_ip.web-pip.id
  }
}

resource "azurerm_network_security_group" "web-nsg" {
  name                = "website-nsg"
  location            = azurerm_resource_group.web-rg.location
  resource_group_name = azurerm_resource_group.web-rg.name

  security_rule {
    name                       = "AllowSSH"
    priority                   = 100
    direction                  = "Inbound"
    access                     = "Allow"
    protocol                   = "Tcp"
    source_port_range          = "*"
    destination_port_range     = "22"
    source_address_prefix      = "*"
    destination_address_prefix = "*"
  }

  security_rule {
    name                       = "AllowHTTP"
    priority                   = 200
    direction                  = "Inbound"
    access                     = "Allow"
    protocol                   = "Tcp"
    source_port_range          = "*"
    destination_port_range     = "80"
    source_address_prefix      = "*"
    destination_address_prefix = "*"
  }

  security_rule {
    name                       = "AllowHTTPS"
    priority                   = 300
    direction                  = "Inbound"
    access                     = "Allow"
    protocol                   = "Tcp"
    source_port_range          = "*"
    destination_port_range     = "443"
    source_address_prefix      = "*"
    destination_address_prefix = "*"
  }

  security_rule {
    name                       = "AllowDockerUI"
    priority                   = 400
    direction                  = "Inbound"
    access                     = "Allow"
    protocol                   = "Tcp"
    source_port_range          = "*"
    destination_port_range     = "8080"
    source_address_prefix      = "*"
    destination_address_prefix = "*"
  }
}

resource "azurerm_network_interface_security_group_association" "web-nsg-association" {
  network_interface_id      = azurerm_network_interface.web-nic.id
  network_security_group_id = azurerm_network_security_group.web-nsg.id
}


resource "azurerm_linux_virtual_machine" "web-server" {
  name                = "webserver"
  resource_group_name = azurerm_resource_group.web-rg.name
  location            = azurerm_resource_group.web-rg.location
  size                = "Standard_B1s"
  admin_username      = "adminuser"

  network_interface_ids = [azurerm_network_interface.web-nic.id]
  custom_data           = filebase64("install_docker.tpl")
  admin_ssh_key {
    username   = "adminuser"
    public_key = file("~/.ssh/mtcazurekey.pub")
  }

  os_disk {
    caching              = "ReadWrite"
    storage_account_type = "Standard_LRS"
  }
  source_image_reference {
    publisher = "Canonical"
    offer     = "0001-com-ubuntu-server-jammy"
    sku       = "22_04-lts"
    version   = "latest"
  }

  provisioner "local-exec" {
    interpreter = ["PowerShell", "-Command"]
    command = templatefile("${var.host_os}-ssh-script.tpl", {
      hostname     = self.public_ip_address
      user         = "adminuser"
      identityfile = "~/.ssh/mtcazurekey"
    })
  }
  tags = {
    environment = "dev"
  }
}

output "public_ip" {
  value = azurerm_public_ip.web-pip.ip_address
}
