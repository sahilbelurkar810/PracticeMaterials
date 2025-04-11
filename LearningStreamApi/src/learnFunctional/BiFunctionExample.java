package learnFunctional;

import java.util.function.BiFunction;

public class BiFunctionExample {
    public static void main(String[] args) {
        BiFunction<Double,Double,Double> calculateSalary = (baseSalary, bonus) -> baseSalary+bonus;
        System.out.println("Total Salary "+ calculateSalary.apply(50000.0,500000.0));
    }
}
