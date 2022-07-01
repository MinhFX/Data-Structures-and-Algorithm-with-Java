import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        MyPerson myPerson = new MyPerson();
        Graph graph = new Graph();

        // Có 11 chức năng, không hạn chế số lần lựa chọn
        while (true) {
            System.out.println("+-------------------Menu-------------------+");
            System.out.println("Choose one of these options:");
            System.out.println("1. Insert a new person");
            System.out.println("2. Inorder traversal");
            System.out.println("3. Preorder traversal");
            System.out.println("4. Postorder traversal");
            System.out.println("5. Breadth-first traversal");
            System.out.println("6. Search by person ID");
            System.out.println("7. Delete by person ID");
            System.out.println("8. Balancing Binary Search Tree");
            System.out.println("9. DFS Graph");
            System.out.println("10. BFS Graph");
            System.out.println("11. Dijkstra");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            switch (choice) {
                case 1 -> myPerson.insert();
                case 2 -> myPerson.inOrder();
                case 3 -> myPerson.postOrder();
                case 4 -> myPerson.preOrder();
                case 5 -> myPerson.breadth_first();
                case 6 -> myPerson.search();
                case 7 -> myPerson.delete();
                case 8 -> myPerson.balance();
                case 9 -> {
                    graph.setWeights("MATRIX.TXT");
                    graph.DFS(0);
                }
                case 10 -> {
                    graph.setWeights("MATRIX.TXT");
                    graph.BFS(0);
                }
                case 11 -> {
                    graph.setWeights("MATRIX.TXT");
                    graph.displayWeights();
                    graph.dijkstra(0, 4);
                }
                case 0 -> System.exit(0);
            }
        }
    }
}
