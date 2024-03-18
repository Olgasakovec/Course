import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Tomato", 1));
        products.add(new Product("Cucumber", 2));
        products.add(new Product("Potato", 3));
        products.add(new Product("Apple", 3));

        products.get(products.size() - 1).setName(products.get(0).getName());

        products.stream()
                .filter(product -> product.getProductId() !=0)
                .sorted((p1, p2) -> p2.getName().compareTo(p1.getName()))
                .distinct()
                .collect(Collectors.toList())
                .forEach(product -> {
                    System.out.println(new StringBuilder(String.valueOf(product)).reverse().toString());
                });
    }
}


