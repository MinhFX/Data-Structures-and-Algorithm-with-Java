import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Graph {
    int[][] a;
    int n;
    static int INF = 9999;
    String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Graph() {}

    // Đọc dữ liệu từ bảng ma trận lưu trong tệp MATRIX.TXT
    public void setWeights(String fileName) throws IOException {
        String line, str;
        StringTokenizer token;
        RandomAccessFile raf = new RandomAccessFile(fileName, "r");
        line = raf.readLine();
        n = Integer.parseInt(line.trim());
        a = new int[n][n];

        for (int i = 0; i < n; i++) {
            line = raf.readLine();
            token = new StringTokenizer(line, " ");

            for (int j = 0; j < a.length; j++) {
                str = token.nextToken();

                if (str.equals("INF")) {
                    a[i][j] = INF;
                } else {
                    a[i][j] = Integer.parseInt(str);
                }
            }
        }

        raf.close();
    }

    // Chức năng 9: Duyệt đồ thị theo chiều sâu
    public void DFS(int k) {
        boolean[] selected = new boolean[n];
        int selectedCount = 0;
        MyStack<Integer> myStack = new MyStack<>();
        myStack.push(k);
        System.out.print("DFS Graph: ");

        while (!myStack.isEmpty() && selectedCount < n) {
            Integer current = myStack.pop();

            if (!selected[current]) {
                selectedCount ++;
                String step = str.charAt(current) + ("");
                System.out.print(step);
            }

            selected[current] = true;
            ArrayList<Integer> vertex = getVertex(current);

            for (Integer i : vertex) {
                if (!selected[i]) {
                    myStack.push(i);
                }
            }
        }

        System.out.println();
    }

    public ArrayList<Integer> getVertex(int k) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            if (a[k][i] != INF && k != i) {
                list.add(i);
            }
        }

        return list;
    }

    // Chức năng 10: Duyệt đồ thị theo chiều rộng
    public void BFS(int k) {
        boolean[] selected = new boolean[n];
        int selectedCount = 0;
        MyQueue myQueue = new MyQueue();
        myQueue.enqueue(k);
        System.out.print("BFS Graph: ");

        while (!myQueue.isEmpty() && selectedCount < n) {
            Integer current = (Integer) myQueue.dequeue();

            if (!selected[current]) {
                selectedCount ++;
                String step = str.charAt(current) + ("");
                System.out.print(step);
            }

            selected[current] = true;
            ArrayList<Integer> vertex = getVertex(current);

            for (Integer i : vertex) {
                if (!selected[i]) {
                    myQueue.enqueue(i);
                }
            }
        }

        System.out.println();
    }

    // Hiển thị bảng ma trận ra màn hình
    public void displayWeights() {
        System.out.println("The weighted matrix of the graph:");
        System.out.println("=================================");

        for (int i = 0; i < 10; i++) {
            System.out.print(" ");
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("%-10s", str.charAt(i));
        }

        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.printf("%-10s", str.charAt(i));

            for (int j = 0; j < n; j++) {
                System.out.printf("%-10d", a[i][j]);
            }

            System.out.println();
        }
    }

    // Chức năng 11: Tìm đường đi ngắn nhất bằng thuật toán Dijsktra
    public void dijkstra(int p, int q) {
        boolean[] selected = new boolean[n];
        int[] distance = new int[n];
        int[] path = new int[n];
        System.out.println("\nDijkstra algorithm for shortest path from A to E:");
        System.out.println("=================================================");

        for (int i = 0; i < n; i++) {
            distance[i] = INF;
        }

        displayStep(selected, distance, path, p, q);
        System.out.println("\nThe length of shortest path from A to E is " + distance[q]);
        pathDijkstra(path, p, q);
    }

    // Liệt kê đường đi và trọng số
    public void displayStep(boolean[] selected, int[] distance, int[] path, int p, int q) {
        PriorityQueue<GraphEdge> pq = new PriorityQueue<>();
        pq.add(new GraphEdge(p, p, 0));
        distance[p] = 0;
        selected[p] = true;
        Arrays.fill(path, p);
        StringBuilder string = new StringBuilder();
        StringBuilder builder = new StringBuilder();

        while (!pq.isEmpty()) {
            GraphEdge current = pq.poll();
            string.append(this.str.charAt(current.end));
            selected[current.end] = true;
            ArrayList<Integer> vertex = getVertex(current.end);

            for (Integer i : vertex) {
                int x = getEdge(current.end, i);

                if (distance[i] > x) {
                    pq.add(new GraphEdge(current.end, i, x));
                    int newDistance = distance[current.end] + x;

                    if (newDistance < distance[i]) {
                        distance[i] = newDistance;
                        path[i] = current.end;
                    }
                }
            }

            System.out.printf("%-10s", string);

            for (int i = 1; i < path.length; i++) {
                if (!builder.toString().contains(this.str.charAt(i) + "")) {
                    System.out.printf("(%s,%s) ", distance[i] == INF ? "INF" : distance[i], this.str.charAt(path[i]));
                }
            }

            builder.append(this.str.charAt(current.end));
            System.out.println();

            if (current.end == q) {
                return;
            }
        }
    }

    public int getEdge(int i, int j) {
        return a[i][j];
    }

    public void pathDijkstra(int[] path, int p, int q) {
        MyStack<Integer> myStack = new MyStack<>();
        int preQ = q;

        while (preQ != p) {
            myStack.push(preQ);
            preQ = path[preQ];
        }

        myStack.push(p);
        System.out.print("Path: ");

        while (!myStack.isEmpty()) {
            int x = myStack.pop();
            char edge = this.str.charAt(x);

            if (x != q) {
                System.out.print(edge + " -> ");
            } else {
                System.out.print(edge);
            }
        }

        System.out.println();
    }
}
