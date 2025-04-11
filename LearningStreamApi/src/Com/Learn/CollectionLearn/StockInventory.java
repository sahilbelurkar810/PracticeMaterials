package Com.Learn.CollectionLearn;

import java.util.concurrent.ConcurrentHashMap;

public class StockInventory {
    public static void main(String[] args) {
        ConcurrentHashMap<String , Integer> stock = new ConcurrentHashMap<>();

        // Adding initial stock
        stock.put("Laptop", 10);
        stock.put("Phone", 20);
        stock.put("Tablet", 15);

        //Simulate multiple users updating stock
        Runnable updateStock = () -> {
            stock.put("Laptop",stock.get("Laptop")-1);
            System.out.println(Thread.currentThread().getName()+ " updated stock: "+stock);

        };

        //Running multiple threads
        Thread user1 = new Thread(updateStock);
        Thread user2 = new Thread(updateStock);

        user1.start();
        user2.start();


    }
}
