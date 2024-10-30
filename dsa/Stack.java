public class Stack<Type> {
    SLinkedList<Type> ll;

    public Stack() {
        ll = new SLinkedList<>();
    }

    public Node<Type> peek() {
        return ll.tail;
    }

    public boolean isEmpty() {
        return ll.isEmpty();
    }

    public void push(Type value) {
        ll.push(value);
    }

    public Node<Type> pop() {
        return ll.rpop();
    }

    @Override
    public String toString() {
        return "(BOTTOM) " + ll.toString() + "(TOP)";
    }
}