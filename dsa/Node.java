public class Node<Type> {
    Type value;
    Node<Type> next,prev;

    public Node(Type value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        return "" + this.value;
    }
}
