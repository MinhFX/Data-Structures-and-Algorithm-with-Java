import java.util.LinkedList;

public class MyQueue {
    LinkedList<Object> ll;

    public MyQueue() {
        ll = new LinkedList<>();
    }

    public boolean isEmpty() {
        return ll.isEmpty();
    }

    public void enqueue(Object obj) {
        ll.add(obj);
    }

    public Object dequeue() {
        return ll.removeFirst();
    }
}
