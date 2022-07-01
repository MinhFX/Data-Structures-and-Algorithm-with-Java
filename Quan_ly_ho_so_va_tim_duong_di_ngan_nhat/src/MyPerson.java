import java.util.Scanner;

public class MyPerson {
    MyBSTree myBSTree;

    public MyPerson() {
        myBSTree = new MyBSTree();
    }

    // Chức năng 1: Thêm hồ sơ nhân viên mới vào cây BST
    public void insert() {
        Scanner input = new Scanner(System.in);
        System.out.print("Input ID: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Input name: ");
        String name = input.nextLine();
        System.out.print("Input birthplace: ");
        String birthplace = input.nextLine();
        System.out.print("Input date of birth: ");
        String dob = input.nextLine();
        myBSTree.insert(new Person(id, name, birthplace, dob));
    }

    public void inOrder() {
        System.out.println("Inorder traversal");
        myBSTree.inOrder(myBSTree.root);
    }

    public void postOrder() {
        System.out.println("Postorder traversal");
        myBSTree.postOrder(myBSTree.root);
    }

    public void preOrder() {
        System.out.println("Preorder traversal");
        myBSTree.preOrder(myBSTree.root);
    }

    public void breadth_first() {
        System.out.println("Breadth-first traversal");
        myBSTree.breadth_first();
    }

    // Chức năng 6: Tìm kiếm thông tin của nhân viên trong cây BST
    public void search() {
        Scanner input = new Scanner(System.in);
        System.out.print("Search by ID: ");
        int key = input.nextInt();
        Node node = myBSTree.search(myBSTree.root, key);

        if (node != null) {
            System.out.println(node.getInfo());
        } else {
            System.out.println("Not found!");
        }
    }

    // Chức năng 7: Xóa đi một hồ sơ nhân viên trong cây BST
    public void delete() {
        Scanner input = new Scanner(System.in);
        System.out.print("Delete by ID: ");
        int key = input.nextInt();
        myBSTree.delete(key);
        System.out.println("Deleted!");
    }

    public void balance() {
        myBSTree.balance();
    }
}
