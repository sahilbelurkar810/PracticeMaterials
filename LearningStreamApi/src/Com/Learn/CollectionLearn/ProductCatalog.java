package Com.Learn.CollectionLearn;

import java.util.HashMap;
import java.util.Map;


public class ProductCatalog {
    public static void main(String[] args) {
        Map<String , Double> productprices = new HashMap<>();
        productprices.put("Laptop",60000.0);
        productprices.put("SmartPhones",30000.0);
        productprices.put("HeadPhones",8000.0);

        System.out.println("productprices of Laptop = " + productprices.get("Laptop"));
        productprices.forEach((key,value)-> System.out.println(key + " "+ value));
    }

}
