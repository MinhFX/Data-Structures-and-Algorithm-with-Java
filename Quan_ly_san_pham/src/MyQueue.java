public class MyQueue<Product> {
    protected Node head;
    protected Node tail;

    public MyQueue() {
        this.head = this.tail = null;
    }

    public boolean isEmpty() {
        return (this.head == null);
    }

    // Hiển thị ra theo đúng thứ tự đọc vào queue
    public void enqueue(Product product) {
        if (isEmpty()) {
            this.head = this.tail = new Node(product);
        } else {
            tail.nextNode = new Node(product);
            tail = tail.nextNode;
        }
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
