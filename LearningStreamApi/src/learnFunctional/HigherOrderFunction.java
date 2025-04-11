package learnFunctional;

import java.util.function.Function;

public class HigherOrderFunction {
    public static void main(String[] args) {
        Function<Double , Function<Double ,Double>> discountCalculator = percentage -> price -> price - (price * percentage / 100);
        Function<Double , Double> tenPercentDiscount = discountCalculator.apply(10.0);
        System.out.println(tenPercentDiscount.apply(550.0));
    }
}
