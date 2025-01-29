public class DoublyLinkedList<Type> {
    Node<Type> head, tail;
    int length;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return (length == 0);
    }

    public void push(Type value) {
        Node<Type> n = new Node<>(value);
        if (this.head == null) {
            this.head = n;
            this.tail = n;
        } else {
            n.prev = this.tail;
            this.tail.next = n;
            this.tail = n;
        }
        this.length++;
    }

    public Node<Type> pop() {
        Node<Type> poppedNode;
        if (this.head == null) {
            System.out.println("UNDERFLOW");
            poppedNode = null;
        } else if (this.head == this.tail) {
            poppedNode = this.head;
            this.head = this.tail = null;
            this.length--;
        } else {
            poppedNode = this.tail;
            this.tail.prev.next = null;
            this.tail = this.tail.prev;
            this.length--;
        }
        return poppedNode;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        if (this.head == null)
            return "null";
        else {
            Node<Type> tmp = this.head;
            while (tmp != null) {
                s.append(tmp.value);
                s.append("  <->  ");
                tmp = tmp.next;
            }
            s.append("null");
            return s.toString();
        }
    }
}
