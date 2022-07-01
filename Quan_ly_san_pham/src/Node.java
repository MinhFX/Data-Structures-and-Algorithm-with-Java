public class Node<Product> {
    Product info;
    Node nextNode;

    public Node(Product info, Node nextNode) {
        this.info = info;
        this.nextNode = nextNode;
    }

    public Node(Product info) {
        this(info, null);
    }

    @Override
    public String toString() {
        return "\n" + info;
    }
}
