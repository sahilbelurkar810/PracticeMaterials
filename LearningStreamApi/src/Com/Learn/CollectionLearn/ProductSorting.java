package Com.Learn.CollectionLearn;

import java.util.*;

class Product{
    String name;
    double price;

    public  Product(String name,Double price){
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString(){
        return name + " - ₹ "+price;
    }

}

//custom comparator for sorting by price
class PriceComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2){
        return Double.compare(p2.price,p1.price);
    }
}

public class ProductSorting {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 60000.0));
        products.add(new Product("Smartphone", 30000.0));
        products.add(new Product("Headphones", 5000.0));

        // Sorting using Comparator
        Collections.sort(products, new PriceComparator());

        System.out.println("Sorted Products by Price: " + products);

    }
}
