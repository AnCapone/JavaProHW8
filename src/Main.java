import java.time.LocalDate;
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
            new Product("Book", 200, true, LocalDate.of(2021, 1, 1)),
            new Product("Book", 5.80, LocalDate.of(2021, 3, 1)),
            new Product("Toy", 0.50, LocalDate.of(2023, 5, 20)),
            new Product("Book", 275, true, LocalDate.of(2022, 10, 5)),
            new Product("Book", 251, true, LocalDate.of(2023, 11, 30))
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

        List <Product> lastAddedProducts = products.stream()
                .sorted(Comparator.comparing(Product::getDateAdded).reversed())
                .limit(3)
                .toList();
    }
}