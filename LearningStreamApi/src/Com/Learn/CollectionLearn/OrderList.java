package Com.Learn.CollectionLearn;

import java.util.ArrayList;
import java.util.List;

public class OrderList {
    public static void main(String[] args) {
        List<String> orders = new ArrayList<>();

        orders.add("Laptop");
        orders.add("HeadPhones");
        orders.add("SmartPhones");
        orders.add("Laptop");

        System.out.println("orders = " + orders);

        orders.remove("HeadPhones");
        System.out.println("Updated orders = " + orders);
    }
}
