public class Queue<Type> {
    SLinkedList<Type> q;

    public Queue() {
        q = new SLinkedList<>();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public void push(Type value) {
        q.push(value);
    }

    public void pop() {
        q.fpop();
    }

    @Override
    public String toString() {
        return q.toString();
    }
}