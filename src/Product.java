import java.time.LocalDate;
import java.util.Date;

public class Product {
    private String type;
    private double price;
    private boolean isDiscounted;
    LocalDate dateAdded = LocalDate.now();

    public Product(String type, double price) {
        this.type = type;
        this.price = price;

    }

    public Product(String type, double price, boolean isDiscounted) {
        this.type = type;
        this.price = price;
        this.isDiscounted = isDiscounted;

    }
    public Product(String type, double price, boolean isDiscounted, LocalDate dateAdded) {
         this.type = type;
         this.price = price;
         this.isDiscounted = isDiscounted;
         this.dateAdded = dateAdded;
    }
    public Product(String type, double price, LocalDate dateAdded) {
        this.type = type;
        this.price = price;
        this.dateAdded = dateAdded;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscounted(boolean discounted) {
        isDiscounted = discounted;
    }

    public boolean isDiscounted() {
        return isDiscounted;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }
}
