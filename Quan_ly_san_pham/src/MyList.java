public class MyList<Product> {
    Node<Product> head;
    Node<Product> tail;

    public MyList() {
        this.head = this.tail = null;
    }

    public boolean isEmpty() {
        return (this.head == null);
    }

    // Dữ liệu sẽ được thêm vào phía đuôi của danh sách móc nối
    public void insertAtTail(Product product) {
        Node node = new Node(product);

        if (isEmpty()) {
            this.head = this.tail = node;
        } else {
            this.tail.nextNode = node;
            this.tail = node;
        }
    }

    // Xóa sản phẩm khỏi danh sách móc nối
    public void deleteElement(Product product) throws Exception {
        if (isEmpty()) {
            System.out.println("List is empty!");
            throw new Exception();
        }

        Node<Product> element = this.head;

        if (this.head.info.equals(product)) {
            this.head = head.nextNode;
        } else {
            while (element.nextNode != null) {
                if (element.nextNode.info.equals(product)) {
                    Node<Product> node = element.nextNode;
                    element.nextNode = node.nextNode;
                } else {
                    element = element.nextNode;
                }
            }
        }
    }

    // Danh sách móc nối sẽ được sắp xếp theo thứ tự tăng dần của từ điển
    public void swap(Node<Product> firstNode, Node<Product> secondNode) {
        Product product;
        product = firstNode.info;
        firstNode.info = secondNode.info;
        secondNode.info = product;
    }

    // Xóa tất cả sản phẩm trong danh sách
    public void clear() {
        this.head = this.tail = null;
    }

    // Duyệt từng phần tử trong danh sách và hiển thị ra màn hình
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
