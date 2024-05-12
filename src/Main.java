import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String productType = "Book";
        Double limitPrice = 250.0;
        Double discount = 0.9;

        List<Product> products= List.of(
            new Product("Vegetables", 100),
            new Product("Book", 200, true),
            new Product("Book", 5.80),
            new Product("Toy", 0.50),
            new Product("Book", 275, true),
            new Product("Book", 251, true)
        );

        List<Product> books = products.stream()
                .filter(product -> product.getType().equals(productType) && product.getPrice() > limitPrice)
                .toList();

        List<Product> discountedBooks = products.stream()
                .filter(product -> product.getType().equals(productType) && product.isDiscounted())
                .peek(product -> product.setPrice(product.getPrice() * discount))
                .toList();

        Product chipedBook = products.stream()
                .filter(product -> product.getType().equals(productType))
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException("Продукт [категорія: " + productType + "] не знайдено"));


    }
}