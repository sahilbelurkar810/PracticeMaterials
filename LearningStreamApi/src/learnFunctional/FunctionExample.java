package learnFunctional;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<Integer,String> convertToString = num -> "Number :" + num;
        System.out.println(convertToString.apply(10));
    }
}
