package Com.Learn.CollectionLearn;

import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5,2,9,1,6));

        Collections.sort(numbers);
        System.out.println(numbers);
        System.out.println("Max: "+Collections.max(numbers));
        System.out.println("Min: "+Collections.min(numbers));

        Collections.reverse(numbers);
        System.out.println("reversed numbers = " + numbers);
    }
}
