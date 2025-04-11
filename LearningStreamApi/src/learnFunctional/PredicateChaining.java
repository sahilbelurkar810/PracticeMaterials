package learnFunctional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateChaining {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10,20,30,45,60,75,100);

        Predicate<Integer> isEven = num -> num%2==0;
        Predicate<Integer> isGreaterThan20 = num -> num>20;

        List<Integer> filteredNumbers = numbers.stream().filter(isEven.and(isGreaterThan20)).toList();
        filteredNumbers.forEach(System.out::println);

    }
}
