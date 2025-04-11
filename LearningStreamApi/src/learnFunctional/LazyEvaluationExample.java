package learnFunctional;

import java.util.function.Supplier;

public class LazyEvaluationExample {
    public static void main(String[] args) {
        logMessage(() -> "Expensive computation Result: " + (1000 * Math.random()));
    }
    static  void  logMessage(Supplier<String> messageSupplier){
        if(Math.random() > 0.5){
            System.out.println((messageSupplier.get()));
        }
        else {
            System.out.println("Log Skipped");
        }
    }
}
