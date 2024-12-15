
import java.util.ArrayList;

public class UndirectedGraph<Type> {
    ArrayList<SLinkedList<Type>> vertices;

    public UndirectedGraph() {

    }

    // add node
    public void addNode(Type data) {
        int len = vertices.size();
        for (int i = 0; i < len; i++) {
            if (vertices.get(i).head.value.equals(data)) {
                System.out.println("Node already exist");
                return;
            }
        }
        SLinkedList<Type> ll = new SLinkedList<>();
        ll.push(data);
        vertices.add(ll);
    }

    // remove node
    public void removeNode(Type data) {
        int len = vertices.size();
        for (int i = 0; i < len; i++) {
            if (vertices.get(i).head.value.equals(data)) {
                vertices.remove(i);
            }
        }
        len = vertices.size();
        for (int i = 0; i < len; i++) {
            vertices.get(i).remove(data);
        }
    }

    // add edge
    public void addEdge(Type from, Type to) {
        int len = vertices.size();
        for (int i = 0; i < len; i++) {
            if (vertices.get(i).head.value.equals(from)) {
                vertices.get(i).push(to);
                break;
            }
        }
    }

    // remove edge
    public void removeEdge(Type from, Type to) {
        int len = vertices.size();
        for (int i = 0; i < len; i++) {
            if (vertices.get(i).head.value.equals(from)) {
                vertices.get(i).remove(to);
                break;
            }
        }
    }
}