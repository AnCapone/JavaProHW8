public class Product {
    private String type;
    private double price;
    private boolean isDiscounted = false;

    public Product(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public Product(String type, double price, boolean isDiscounted) {
        this.type = type;
        this.price = price;
        this.isDiscounted = isDiscounted;
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
}
