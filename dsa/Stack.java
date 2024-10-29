public class Stack<Type>{
    SLinkedList<Type> ll;
    public Stack(){
        ll = new SLinkedList<>();
    }
    public Node<Type> peek(){
        Node<Type> tmp = ll.head;
        if(ll.isEmpty())return null;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        return tmp;
    }
    public boolean isEmpty(){
        return ll.isEmpty();
    }
    public void push(Node<Type> node){
        ll.push(node);
    }
    public void pop(){
        ll.rpop();
    }
    @Override
    public String toString(){
        return ll.toString();
    }
}