package Projects;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class DiscountVariance {
    public static void main(String[] args) {
        Predicate<String> isValidMembership = membership ->
                membership.equalsIgnoreCase("Regular") ||
                membership.equalsIgnoreCase("Premium") ||
                membership.equalsIgnoreCase("Vip") ;

        Map<String , BiFunction<Double,Double,Double>> discountFunctions = new HashMap<>();
        discountFunctions.put("Regular",(price,discountrate)-> price - (price*discountrate));

        BiFunction<String,Double,Double> calculateDiscount = (membership, price) -> {
            double discountRate = switch (membership.toLowerCase()) {
                case "regular" -> 0.05;
                case "premium" -> 0.10;
                case "vip" -> 0.20;
                default -> 0.0;
            };
            return price - (price * discountRate);
        };
        String[] memberships = {"Regular" ,"Premium","Vip","Guest"};
        for(String membership : memberships){
            if(isValidMembership.test(membership)){
                System.out.println( membership +" price : "+ calculateDiscount.apply(membership,1000.0));
            }else {
                System.out.println(membership + " is not a valid membership. No discount applied.");
            }
        }
    }
}
