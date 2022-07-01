import java.util.ArrayList;

public class MyBSTree {
    Node root;
    ArrayList<Person> list;
    boolean check = false;

    public MyBSTree() {
        root = null;
        list = new ArrayList<>();
    }

    public boolean isEmpty() {
        return root == null;
    }

    // Cho phép thêm một node vào trong cây
    public void insert(Person person) {
        Node node = new Node(person);

        if (isEmpty()) {
            root = node;
            return;
        }

        Node n, r;
        n = null;
        r = root;

        while (r != null) {
            // Nếu có ID trùng với ID cũ thì không cho thêm
            if (r.getInfo().getId() == person.getId()) {
                System.out.println("Cannot insert ID, already exists!");
                return;
            }

            n = r;

            if (r.getInfo().getId() > person.getId()) {
                r = r.getLeft();
            } else {
                r = r.getRight();
            }
        }

        assert n != null;

        if (n.getInfo().getId() > person.getId()) {
            n.setLeft(node);
        } else {
            n.setRight(node);
        }
    }

    // Chức năng 2: Duyệt cây BST theo thứ tự Inorder
    public void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.getLeft());
        System.out.println(node.getInfo());
        inOrder(node.getRight());
    }

    // Chức năng 3: Duyệt cây BST theo thứ tự Postorder
    public void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.println(node.getInfo());
    }

    // Chức năng 4: Duyệt cây BST theo thứ tự Preorder
    public void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.getInfo());
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    // Chức năng 5: Duyệt cây BST theo chiều rộng
    public void breadth_first() {
        if (root == null) {
            return;
        }

        // Sử dụng cấu trúc lưu trữ Queue và các thao tác trên Queue để duyệt theo chiều rộng
        MyQueue myQueue = new MyQueue();
        myQueue.enqueue(root);
        Node node;

        while (!myQueue.isEmpty()) {
            node = (Node) myQueue.dequeue();
            System.out.println(node.getInfo());

            if (node.getLeft() != null) {
                myQueue.enqueue(node.getLeft());
            }

            if (node.getRight() != null) {
                myQueue.enqueue(node.getRight());
            }
        }
    }

    // Tìm kiếm thông tin của nhân viên theo ID
    public Node search(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (node.getInfo().getId() == key) {
            return node;
        }

        if (node.getInfo().getId() > key) {
            return search(node.getLeft(), key);
        } else {
            return search(node.getRight(), key);
        }
    }

    // Xóa đi một hồ sơ nhân viên theo ID
    public void delete(int key) {
        root = deleteById(root, key);
    }

    public Node deleteById(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (node.getInfo().getId() > key) {
            node.setLeft(deleteById(node.getLeft(), key));
        } else if (key > node.getInfo().getId()) {
            node.setRight(deleteById(node.getRight(), key));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            node.setInfo(minIndex(node.getRight()));
            node.setRight(deleteById(node.getRight(), node.getInfo().getId()));
        }

        return node;
    }

    public Person minIndex(Node node) {
        Person person = node.getInfo();

        while (node.getLeft() != null) {
            person = node.getLeft().getInfo();
            node = node.getLeft();
        }

        return person;
    }

    // Chức năng 8: Cân bằng cây BST
    public void balance() {
        if (check) {
            System.out.println("Tree has been balanced!");
            return;
        }

        copyTree(root);
        balance(list, 0, list.size() - 1);
        System.out.println("Done!");
        check = true;
    }

    public void copyTree(Node node) {
        if (node != null) {
            copyTree(node.getLeft());
            list.add(node.getInfo());
            copyTree(node.getRight());
        }

        deleteTree();
    }

    public void deleteTree() {
        root = null;
    }

    public void balance(ArrayList<Person> data, int first, int last) {
        if (first <= last) {
            int middle = (first + last) / 2;
            insert(data.get(middle));
            balance(data, first, middle - 1);
            balance(data, middle + 1, last);
        }
    }
}
