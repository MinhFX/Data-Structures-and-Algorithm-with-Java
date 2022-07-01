import java.util.LinkedList;

public class MyStack<T> {
    LinkedList<T> ll;

    public MyStack() {
        ll = new LinkedList<>();
    }

    public boolean isEmpty() {
        return ll.isEmpty();
    }

    public void push(T x) {
        ll.push(x);
    }

    public T pop() {
        return ll.pop();
    }
}
