package Com.Learn.CollectionLearn;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {
    public static void main(String[] args) {
        Collection nums = new ArrayList();
        nums.add(12);
        nums.add("sahil");
//        System.out.println("nums = " + nums);
        nums.stream().forEach(System.out::println);
    }
}
