public class CircularLinkedList<Type> {
    Node<Type> head;
    Node<Type> tail;
    int length;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return (length == 0);
    }

    public Node<Type> fpop() {
        Node<Type> poppedNode = this.head;
        if (this.head == null) {
            System.out.println("UNDERFLOW");
        } else if (this.head == this.tail) {
            this.head = this.tail = null;
            length--;
        } else {
            this.head = this.tail.next = this.head.next;
            length--;
        }
        return poppedNode;
    }

    public Node<Type> pop() {
        Node<Type> poppedNode;
        if (this.head == null) {
            System.out.println("UNDERFLOW");
            poppedNode = null;
        } else if (this.head == this.tail) {
            poppedNode = this.head;
            this.head = null;
            this.tail = null;
            this.length--;
        } else {
            Node<Type> tmp = this.head;
            while (tmp.next != this.tail)
                tmp = tmp.next;
            poppedNode = tmp.next;
            tmp.next = tmp.next.next;
            this.length--;
        }
        return poppedNode;
    }

    public void push(Type value) {
        Node<Type> n = new Node<>(value);
        if (this.head == null) {
            this.head = this.tail = n;
            this.head.next = this.tail.next = this.head;
        } else {
            this.tail.next = n;
            this.tail = n;
            n.next = this.head;
        }
        this.length++;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        if (this.head == null)
            return "null";
        else {
            Node<Type> tmp = this.head;
            do {
                s.append(tmp.value);
                s.append("->");
                tmp = tmp.next;
            } while (tmp != this.head);
            s.append("null");
            return s.toString();
        }
    }
}
