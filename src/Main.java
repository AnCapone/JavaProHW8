import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
    String productType = "Book";
    double limitPrice = 250;
    double discount = 0.9;
    List<Product> products = List.of(
        new Product("Book", 200),
            new Product("Book", 300, LocalDate.of(2023, 2, 1)),
            new Product("Book", 400, true, LocalDate.of(2021, 3, 1)),
            new Product("Vegetable", 250, LocalDate.of(2022, 4, 1)),
            new Product("Book", 600, true, LocalDate.of(2021, 5, 1)),
            new Product("Toy", 0.9, false, LocalDate.of(2021, 6, 1)),
            new Product("Vegetable", 800, true, LocalDate.of(2021, 7, 1)),
            new Product("Book", 900, false, LocalDate.of(2021, 8, 1)),
            new Product("Car", 1000, true, LocalDate.of(2021, 9, 1))

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

        Double totalPriceThisYearBooks = products.stream()
                .filter(product -> product.getType().equals(productType))
                .filter(product -> product.getDateAdded().getYear() == LocalDate.now().getYear())
                .filter(product -> product.getPrice() <= limitPrice)
                .mapToDouble(Product::getPrice)
                .sum();

        products.stream()
                .collect(Collectors.groupingBy(Product::getType))
                .forEach((key, value) -> System.out.println(key + " : " + value));


    }


}