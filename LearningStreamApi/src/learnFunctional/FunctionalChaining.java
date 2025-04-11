package learnFunctional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionalChaining {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("sahil","abhinash","Shreenithya");

        Function<String ,String> capitalize = str -> str.substring(0,1).toUpperCase()+ str.substring(1);
        Consumer<String> print = str -> System.out.println("Processed Name: "+str);

        names.stream()
                .map(capitalize)
                .forEach(print);

    }
}
