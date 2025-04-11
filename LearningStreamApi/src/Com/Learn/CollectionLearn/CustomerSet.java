package Com.Learn.CollectionLearn;

import java.util.HashSet;
import java.util.Set;

public class CustomerSet {
    public static void main(String[] args) {
        Set<Integer> customerIds = new HashSet<>();
        customerIds.add(101);
        customerIds.add(102);
        customerIds.add(103);
        customerIds.add(104);
        System.out.println("customerIds = " + customerIds);
        customerIds.forEach(System.out::println);
    }
}
