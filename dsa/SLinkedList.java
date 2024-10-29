public class SLinkedList<Type> {
    Node<Type> head;
    int length;
    public SLinkedList(){
        this.head = null;
        this.length = 0;
    }
    public boolean isPresent(Type value){
        if(this.isEmpty())return false;
        Node<Type> tmp = this.head;
        while(tmp!=null){
            if(tmp.value == value)return true;
            tmp = tmp.next;
        }
        return false;
    }
    public void push(Node<Type> node){
        if(this.head==null)
            this.head = node;
        else{
            Node<Type> tmp = this.head;
            while(tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = node;
        }
        if(node!=null){
            length++;
        }
    }
    public boolean isEmpty(){
        return length == 0;
    }
    public Node<Type> fpop(){
        Node<Type> poppedNode = this.head;
        if(isEmpty()){
            System.out.println("UNDERFLOW");
        }else{
            this.head = this.head.next;
            --length;
        }
        return poppedNode;
    }
    public Node<Type> rpop(){
        Node<Type> poppedNode = null;
        if(isEmpty()){
            System.out.println("UNDERFLOW");
        }else{
            Node<Type> tmp = this.head;
            if(tmp.next == null){
                poppedNode = this.head;
                this.head = null;
            }else{
                while(tmp.next.next != null){
                    tmp = tmp.next;
                }
                poppedNode = tmp.next;
                tmp.next = null;
            }
            --length;
        }
        return poppedNode;
    }
    @Override
    public String toString(){
        Node<Type> tmp = this.head;
        String output = "";
        while(tmp!=null){
            output+=tmp.value + " -> " + " ";
            tmp = tmp.next;
        }
        return output;
    }

}
