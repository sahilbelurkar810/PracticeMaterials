package Projects;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DiscountSystemSummary {
    public static void main(String[] args) {
        // List of products
        List<Product> products = Arrays.asList(
                new Product("Laptop", 60000, "VIP"),
                new Product("Phone", 30000, "Premium"),
                new Product("Headphones", 5000, "Regular"),
                new Product("Smartwatch", 8000, "Guest")
        );

        // Predicate for membership validation
        Predicate<String> isValidMembership = membership ->
                membership.equalsIgnoreCase("Regular") ||
                        membership.equalsIgnoreCase("Premium") ||
                        membership.equalsIgnoreCase("VIP");

        // BiFunction for discount calculation
        BiFunction<String, Double, Double> calculateDiscount = (membership, price) -> {
            double discountRate = switch (membership.toLowerCase()) {
                case "regular" -> 0.05;
                case "premium" -> 0.10;
                case "vip" -> 0.20;
                default -> 0.0;
            };
            return price - (price * discountRate);
        };

        // Stream Processing with Aggregation
        double totalOriginalPrice = products.stream()
                .mapToDouble(product -> product.price)
                .sum();

        double totalDiscountedPrice = products.stream()
                .filter(product -> isValidMembership.test(product.membership))  // Only valid members
                .mapToDouble(product -> calculateDiscount.apply(product.membership, product.price))
                .sum();

        System.out.println("Total Original Price: " + totalOriginalPrice);
        System.out.println("Total Discounted Price: " + totalDiscountedPrice);
    }
}
