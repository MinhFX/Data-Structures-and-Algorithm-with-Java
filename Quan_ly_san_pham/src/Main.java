import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        MyList<Product> myList = new MyList<>();
        MyStack<Product> myStack = new MyStack<>();
        MyQueue<Product> myQueue = new MyQueue<>();

        // Có 10 chức năng, không hạn chế số lần lựa chọn
        while (true) {
            System.out.println("+-------------------Menu-------------------+");
            System.out.println("Choose one of these options:");
            System.out.println("1. Load data from file and display");
            System.out.println("2. Input & add to the end");
            System.out.println("3. Display data");
            System.out.println("4. Save product list to file");
            System.out.println("5. Search by ID");
            System.out.println("6. Delete by ID");
            System.out.println("7. Sort by ID");
            System.out.println("8. Convert to binary");
            System.out.println("9. Load to stack and display");
            System.out.println("10. Load to queue and display");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            switch (choice) {
                case 1 -> {
                    myList.clear();
                    OperationToProduct.getAllItemsFromFile("DATA.TXT", myList);
                    System.out.println("Display from file");
                    myList.showList();
                }
                case 2 -> {
                    myList.insertAtTail(OperationToProduct.createProduct());
                    System.out.println("Product has been added!");
                }
                case 3 -> OperationToProduct.displayAll(myList);
                case 4 -> {
                    OperationToProduct.writeAllItemsToFile("DATA.TXT", myList);
                    System.out.println("Saved!");
                }
                case 5 -> OperationToProduct.searchById(myList);
                case 6 -> OperationToProduct.deleteById(myList);
                case 7 -> {
                    OperationToProduct.sortById(myList, myList.head);
                    System.out.println("Successfully!");
                    myList.showList();
                }
                case 8 -> {
                    System.out.printf("Quantity = %d -> ", myList.head.info.quantity);
                    System.out.println(OperationToProduct.convertToBinary(myList.head.info.quantity));
                }
                case 9 -> {
                    System.out.println("Display from stack");
                    OperationToProduct.getAllItemsFromStack("DATA.TXT", myStack);
                    myStack.showList();
                }
                case 10 -> {
                    System.out.println("Display from queue");
                    OperationToProduct.getAllItemsFromQueue("DATA.TXT", myQueue);
                    myQueue.showList();
                }
                case 0 -> System.exit(0);
            }
        }
    }
}
