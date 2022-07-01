public class Product {
    String id;
    String title;
    int quantity;
    double price;

    public Product(String id, String title, int quantity, double price) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%-5s%-4s%-8s%-4s%-11d%-4s%.1f", id, "|", title, "|", quantity, "|", price);
    }
}
