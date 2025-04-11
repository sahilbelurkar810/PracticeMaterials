package learnFunctional;

import java.util.function.BiPredicate;

public class BiPredicateExample {
    public static void main(String[] args) {
        BiPredicate<Integer,Double> isEligibleForLoan = (age,income) -> age >= 18 && income > 30000;
        System.out.println(isEligibleForLoan.test(20,300000.0));
        System.out.println(isEligibleForLoan.test(10,3300000.0));
    }
}
