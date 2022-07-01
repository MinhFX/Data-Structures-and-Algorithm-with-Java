import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperationToProduct {
    // Chức năng 1: Đọc dữ liệu có sẵn từ tệp DATA.TXT
    public static void getAllItemsFromFile(String fileName, MyList<Product> myList) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                String[] productInfo = line.split(",");
                Product product = new Product(productInfo[0], productInfo[1], Integer.parseInt(productInfo[2]), Float.parseFloat(productInfo[3]));
                myList.insertAtTail(product);
            }

            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Not found!");
        } catch (IOException e) {
            System.out.println("Error!");
        }
    }

    // Chức năng 2: Nhập và thêm một sản phẩm vào cuối danh sách móc nối
    public static Product createProduct() {
        Scanner input = new Scanner(System.in);
        System.out.print("Input product's ID: ");
        String id = input.next();
        System.out.print("Input product's title: ");
        String title = input.next();
        System.out.print("Input product's quantity: ");
        int quantity = input.nextInt();
        System.out.print("Input product's price: ");
        double price = input.nextDouble();
        return new Product(id, title, quantity, price);
    }

    // Chức năng 3: Hiển thị thông tin của các sản phẩm trong danh sách móc nối
    public static void displayAll(MyList<Product> myList) {
        System.out.println("Product list");
        myList.showList();
    }

    // Chức năng 4: Lưu danh sách móc nối vào tệp DATA.TXT
    public static void writeAllItemsToFile(String fileName, MyList<Product> myList) {
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            Node<Product> node = myList.head;
            Product product;

            while (node != null) {
                product = node.info;
                String productInfo = product.id + "," + product.title + "," + product.quantity + "," + product.price;
                bw.write(productInfo);
                bw.newLine();
                node = node.nextNode;
            }

            bw.close();
            fw.close();
        } catch (IOException e) {
            Logger.getLogger(OperationToProduct.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // Chức năng 5: Tìm kiếm thông tin của sản phẩm theo ID
    public static void searchById(MyList<Product> myList) {
        Scanner input = new Scanner(System.in);
        System.out.print("Search by ID: ");
        String key = input.next();
        Node<Product> node = myList.head;
        boolean isFound = false;

        // Thông tin tìm thấy sẽ hiển thị ra màn hình
        while (node != null) {
            if (key.equalsIgnoreCase(node.info.id)) {
                System.out.println(node.info);
                isFound = true;
                break;
            } else {
                node = node.nextNode;
            }
        }

        // Nếu không thấy hiển thị ra -1
        if (!isFound) {
            System.out.println("-1");
        }
    }

    // Chức năng 6: Xóa sản phẩm theo ID trong danh sách móc nối
    public static void deleteById(MyList<Product> myList) {
        Scanner input = new Scanner(System.in);
        System.out.print("Delete by ID: ");
        String key = input.next();
        Node<Product> node = myList.head;
        boolean isFound = false;

        while (node != null) {
            if (key.equalsIgnoreCase(node.info.id)) {
                try {
                    myList.deleteElement(node.info);
                    System.out.println("Deleted!");
                    isFound = true;
                } catch (Exception e) {
                    Logger.getLogger(OperationToProduct.class.getName()).log(Level.SEVERE, null, e);
                }

                break;
            } else {
                node = node.nextNode;
            }
        }

        if (!isFound) {
            System.out.println("Not found!");
        }
    }

    // Chức năng 7: Sắp xếp các sản phẩm trong danh sách móc nối theo ID
    public static void sortById(MyList<Product> myList, Node<Product> node) throws Exception {
        if (myList.isEmpty()) {
            throw new Exception();
        }

        if (node.nextNode == null) {
            return;
        }

        Node<Product> minIndex = node.nextNode;

        while (minIndex != null) {
            if (node.info.id.compareToIgnoreCase(minIndex.info.id) > 0) {
                myList.swap(node, minIndex);
            }

            minIndex = minIndex.nextNode;
        }

        sortById(myList, node.nextNode);
    }

    // Chức năng 8: Biểu diễn số lượng sản phẩm của phần tử đầu tiên ra hệ hếm nhị phân
    public static int convertToBinary(int i) {
        if (i == 0) {
            return 0;
        } else {
            return i % 2 + 10 * (convertToBinary(i / 2));
        }
    }

    // Chức năng 9: Đọc dữ liệu từ tệp lưu vào stack và hiển thị thông tin trong stack ra màn hình
    public static void getAllItemsFromStack(String fileName, MyStack<Product> myStack) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                String[] productInfo = line.split(",");
                Product product = new Product(productInfo[0], productInfo[1], Integer.parseInt(productInfo[2]), Float.parseFloat(productInfo[3]));
                myStack.push(product);
            }

            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Not found!");
        } catch (IOException e) {
            System.out.println("Error!");
        }
    }

    // Chức năng 10: Đọc dữ liệu từ tệp lưu vào queue và hiển thị thông tin trong queue ra màn hình
    public static void getAllItemsFromQueue(String fileName, MyQueue<Product> myQueue) {
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                String[] productInfo = line.split(",");
                Product product = new Product(productInfo[0], productInfo[1], Integer.parseInt(productInfo[2]), Float.parseFloat(productInfo[3]));
                myQueue.enqueue(product);
            }

            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Not found!");
        } catch (IOException e) {
            System.out.println("Error!");
        }
    }
}
