package Projects;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

class  Product {
    String name;
    double price;
    String membership;

    public Product(String name, double price,String membership){
        this.name = name;
        this.price = price;
        this.membership = membership;
    }
}

public class DiscountSystemStreams {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop",60000,"VIP"),
                new Product("HeadPhone",5000,"Regular"),
                new Product("Phone",30000,"Premium"),
                new Product("Smartwatch",8000,"Guest")

        );

        Predicate<String> isValidMembership = membership ->
                membership.equalsIgnoreCase("Regular") ||
                membership.equalsIgnoreCase("Premium") ||
                membership.equalsIgnoreCase("VIP");
        BiFunction<String,Double,Double> calculateDiscount = (membership,price) -> {
            double discountRate = switch (membership.toLowerCase()){
                case "regular" -> 0.05;
                case "premium" -> 0.10;
                case "vip" -> 0.20;
                default -> 0.0;
            };
            return price - (price * discountRate);
        };

        List<Product> discountedProduct = products.stream()
                .filter(product -> isValidMembership.test(product.membership))
                .map(product -> new Product(
                        product.name,
                        calculateDiscount.apply(product.membership,product.price),
                        product.membership
                ))
                .toList();
        System.out.println("Discounted Products: ");
        discountedProduct.forEach(product -> System.out.println(product.name + "( Membership: "+product.membership+" ) - Final Price : " + product.price ));
    }
}
