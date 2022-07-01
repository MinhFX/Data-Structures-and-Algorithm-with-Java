public class MyStack<Product> {
    protected Node head;

    public MyStack() {
        this.head = null;
    }

    // Hiển thị thông tin ra ngược với thứ tự đọc vào stack
    public void push(Product product) {
        this.head = new Node(product, head);
    }

    public void showList() {
        Node node = this.head;
        System.out.printf("%-5s%-4s%-8s%-4s%-11s%-4s%s", "ID", "|", "Title", "|", "Quantity", "|", "Price\n");
        System.out.println("=========================================");

        while (node != null) {
            System.out.println(node.info);
            node = node.nextNode;
        }
    }
}
