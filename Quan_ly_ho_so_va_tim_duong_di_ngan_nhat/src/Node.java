public class Node {
    Person info;
    Node left;
    Node right;

    public Node(Person info) {
        this.info = info;
        left = right = null;
    }

    public void setInfo(Person info) {
        this.info = info;
    }

    public Person getInfo() {
        return info;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getLeft() {
        return left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getRight() {
        return right;
    }
}
