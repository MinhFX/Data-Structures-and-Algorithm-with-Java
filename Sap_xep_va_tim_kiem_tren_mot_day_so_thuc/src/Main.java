import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Algorithm algorithm = new Algorithm();

        // Có 7 chức năng, không hạn chế số lần lựa chọn
        while (true) {
            System.out.println("+-------------------Menu-------------------+");
            System.out.println("1. Input");
            System.out.println("2. Output");
            System.out.println("3. Bubble Sort");
            System.out.println("4. Selection Sort");
            System.out.println("5. Insertion Sort");
            System.out.println("6. Search > Value");
            System.out.println("7. Search = Value");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            // Gọi tới các phương thức ở lớp Algorithm để thực hiện các chức năng theo yêu cầu
            switch (choice) {
                case 1 -> algorithm.writeFile();
                case 2 -> algorithm.readFile();
                case 3 -> algorithm.bubbleSort();
                case 4 -> algorithm.selectionSort();
                case 5 -> algorithm.insertionSort();
                case 6 -> algorithm.linearSearch();
                case 7 -> algorithm.binarySearch();
                case 0 -> System.exit(0);
            }
        }
    }
}
