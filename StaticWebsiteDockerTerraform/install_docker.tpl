#!/bin/bash

# Update package lists
sudo apt-get update -y

# Install necessary dependencies
sudo apt-get install -y docker.io docker-compose

# Add user to Docker group
sudo usermod -aG docker $(whoami)

# Create required directories
mkdir -p /home/azureuser/docker-compose/html

# Set up Docker Compose files
cat <<EOF > /home/azureuser/docker-compose/docker-compose.yml
version: '3.8'
services:
  nginx:
    image: nginx:latest
    container_name: my-nginx
    ports:
      - "80:80"
    volumes:
      - ./html:/usr/share/nginx/html:ro
    restart: always
EOF

# Start the Docker container
cd /home/azureuser/docker-compose
sudo docker-compose up -d
