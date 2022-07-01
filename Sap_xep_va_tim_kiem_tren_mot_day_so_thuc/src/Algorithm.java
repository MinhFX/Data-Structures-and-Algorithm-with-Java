import java.io.*;
import java.util.Scanner;

public class Algorithm {
    int number = 0;
    float[] a;

    public Algorithm() {}

    // Chức năng 1: Nhập dữ liệu từ bàn phím
    public void writeFile() throws IOException {
        // Nhập giá trị của các số thực
        Scanner input = new Scanner(System.in);
        System.out.print("Input number of elements: ");
        number = Integer.parseInt(input.nextLine());
        float[] arr = new float[number];

        for (int i = 0; i < number; i++) {
            System.out.print("Input element of array[" + i + "] is: ");
            arr[i] = input.nextFloat();
        }

        // Lưu vào tệp INPUT.TXT
        FileOutputStream fos = new FileOutputStream("INPUT.TXT");
        DataOutputStream dos = new DataOutputStream(fos);

        for (int i = 0; i < number; i++) {
            dos.writeFloat(arr[i]);
        }

        dos.close();
    }

    // Chức năng 2: Đọc dữ liệu từ tệp lưu vào mảng a và hiển thị dữ liệu ra màn hình
    public void readFile() throws IOException {
        System.out.println("Read from file");
        System.out.print("Array a:");
        FileInputStream fis = new FileInputStream("INPUT.TXT");
        DataInputStream dis = new DataInputStream(fis);
        a = new float[number];

        for (int i = 0; i < number; i++) {
            a[i] = dis.readFloat();
        }

        displayData(a, number);
    }

    // Hiển thị dữ liệu của mảng a ra màn hình, mỗi phần tử cách nhau 1 khoảng trống
    public void displayData(float[] a, int number) {
        for (int i = 0; i < number; i++) {
            System.out.print(" " + a[i]);
        }

        System.out.println();
    }

    // Chức năng 3: Sắp xếp theo thuật toán Bubble Sort
    public void bubbleSort() throws IOException {
        // Lưu dữ liệu của mảng a sang một mảng b
        int n = a.length;
        float[] b = new float[n];
        System.arraycopy(a, 0, b, 0, n);
        // Thực hiện thuật toán Bubble Sort trên mảng b
        System.out.println("Bubble Sort");
        float x;
        long start = System.currentTimeMillis();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (b[j] > b[j + 1]) {
                    x = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = x;
                }
            }

            displayData(b, n);
        }

        // Tính thời gian chạy của thuật toán Bubble Sort
        long end = System.currentTimeMillis();
        System.out.println("\nRunning time of Bubble Sort: " + (end - start));
        // Lưu vào tệp OUTPUT1.TXT
        FileOutputStream fos = new FileOutputStream("OUTPUT1.TXT");
        DataOutputStream dos = new DataOutputStream(fos);

        for (int i = 0; i < number; i++) {
            dos.writeFloat(b[i]);
        }

        dos.close();
    }

    // Chức năng 4: Sắp xếp theo thuật toán Selection Sort
    public void selectionSort() throws IOException {
        // Lưu dữ liệu của mảng a sang một mảng b
        int n = a.length;
        float[] b = new float[n];
        System.arraycopy(a, 0, b, 0, n);
        // Thực hiện thuật toán Selection Sort trên mảng b
        System.out.println("Selection Sort");
        float x;
        long start = System.currentTimeMillis();

        for (int i = 0; i < n - 1; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (b[min] > b[j]) {
                    min = j;
                }
            }

            x = b[i];
            b[i] = b[min];
            b[min] = x;
            displayData(b, n);
        }

        // Tính thời gian chạy của thuật toán Selection Sort
        long end = System.currentTimeMillis();
        System.out.println("\nRunning time of Selection Sort: " + (end - start));
        // Lưu vào tệp OUTPUT2.TXT
        FileOutputStream fos = new FileOutputStream("OUTPUT2.TXT");
        DataOutputStream dos = new DataOutputStream(fos);

        for (int i = 0; i < number; i++) {
            dos.writeFloat(b[i]);
        }

        dos.close();
    }

    // Chức năng 5: Sắp xếp theo thuật toán Insertion Sort
    public void insertionSort() throws IOException {
        // Lưu dữ liệu của mảng a sang một mảng b
        int n = a.length;
        float[] b = new float[n];
        System.arraycopy(a, 0, b, 0, n);
        // Thực hiện thuật toán Insertion Sort trên mảng b
        System.out.println("Insertion Sort");
        float x;
        int j;
        long start = System.currentTimeMillis();

        for (int i = 1; i < n; i++) {
            x = b[i];
            j = i - 1;

            while (j >= 0 && x < b[j]) {
                b[j + 1] = b[j];
                j = j - 1;
            }

            b[j + 1] = x;
            displayData(b, n);
        }

        // Tính thời gian chạy của thuật toán Insertion Sort
        long end = System.currentTimeMillis();
        System.out.println("\nRunning time of Insertion Sort: " + (end - start));
        // Lưu vào tệp OUTPUT3.TXT
        FileOutputStream fos = new FileOutputStream("OUTPUT3.TXT");
        DataOutputStream dos = new DataOutputStream(fos);

        for (int i = 0; i < number; i++) {
            dos.writeFloat(b[i]);
        }

        dos.close();
    }

    // Chức năng 6: Tìm kiếm theo thuật toán tuần tự
    public void linearSearch() throws IOException {
        int n = a.length;
        float[] b = new float[n];
        System.arraycopy(a, 0, b, 0, n);
        System.out.println("Linear Search");
        // Nhập một số thực lưu vào biến value
        Scanner input = new Scanner(System.in);
        System.out.print("Input value: ");
        float value = input.nextFloat();
        // Tìm chỉ số của các phần tử có giá trị lớn hơn biến value được nhập vào
        System.out.print("Index of elements:");
        // Lưu vào tệp OUTPUT4.TXT
        FileOutputStream fos = new FileOutputStream("OUTPUT4.TXT");
        DataOutputStream dos = new DataOutputStream(fos);

        for (int i = 0; i < n; i++) {
            if (b[i] > value) {
                System.out.print(" " + i);
                dos.writeInt(i);
            }
        }

        dos.close();
        System.out.println();
    }

    // Chức năng 7: Tìm kiếm theo thuật toán nhị phân
    public void binarySearch() throws IOException {
        int n = a.length;
        float[] b = new float[n];
        System.arraycopy(a, 0, b, 0, n);
        // Sắp xếp mảng b bằng thuật toán Insertion Sort được cài đặt ở bước 5
        System.out.println("Insertion Sort");
        float x;
        int j;

        for (int i = 1; i < n; i++) {
            x = b[i];
            j = i - 1;

            while (j >= 0 && x < b[j]) {
                b[j + 1] = b[j];
                j = j - 1;
            }

            b[j + 1] = x;
        }

        // Nhập một số thực lưu vào biến value
        Scanner input = new Scanner(System.in);
        System.out.print("Input value: ");
        float value = input.nextFloat();
        // Tìm chỉ số của phần tử đầu tiên có giá trị bằng value trên mảng được sắp xếp
        int low = 0;
        int high = b.length - 1;

        while (high >= low) {
            int mid = low + (high - low) / 2;

            if (value > b[mid]) {
                low = mid + 1;
            } else if (value < b[mid]) {
                high = mid - 1;
            } else { // Kết quả tìm được hiển thị ra màn hình, lưu vào tệp OUTPUT5.TXT
                System.out.println("Index of first element: " + mid);
                FileOutputStream fos = new FileOutputStream("OUTPUT5.TXT");
                DataOutputStream dos = new DataOutputStream(fos);
                dos.writeFloat(b[mid]);
                dos.close();
                break;
            }
        }
    }
}
