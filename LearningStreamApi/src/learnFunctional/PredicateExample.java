package learnFunctional;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> isEven = num -> num%2 == 0;

        System.out.println(isEven.test(10));
        System.out.println(isEven.test(129));

        //consumer
        Consumer<String> printUpperCase = str -> System.out.println(str.toUpperCase());

        printUpperCase.accept("sahil is learning collections");

    }
}
