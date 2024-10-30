public class Node<Type> {
    Type value;
    Node<Type> next;

    public Node(Type value) {
        this.value = value;
        this.next = null;
    }

    @Override
    public String toString() {
        return "" + this.value;
    }
}
