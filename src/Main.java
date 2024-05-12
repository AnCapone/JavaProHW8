import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Book", 100, true, LocalDate.of(2021, 1, 1)));



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