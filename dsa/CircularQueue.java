public class CircularQueue<Type> {
    CircularLinkedList<Type> l;

    public CircularQueue() {
        l = new CircularLinkedList<>();
    }

    public Node<Type> front() {
        return l.head;
    }

    public void enQueue(Type value) {
        this.l.push(value);
    }

    public Node<Type> deQueue() {
        return this.l.fpop();
    }

    @Override
    public String toString() {
        return this.l.toString();
    }
}
