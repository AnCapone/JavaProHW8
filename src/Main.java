import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Product> products= List.of(
            new Product("Vegetables", 100),
            new Product("Book", 200),
            new Product("Fruits", 0.80),
            new Product("Toy", 0.50),
            new Product("Book", 275),
            new Product("Book", 251)
        );

        List<Product> books = products.stream()
                .filter(product -> product.getType().equals("Book") && product.getPrice() > 250)
                .toList();

        System.out.println(books);
    }
}