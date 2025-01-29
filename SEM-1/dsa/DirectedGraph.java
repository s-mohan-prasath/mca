
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DirectedGraph {
    private class GNode {
        String label;

        public GNode(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    Map<String, GNode> vertices = new HashMap<>();
    Map<GNode, ArrayList<GNode>> adjacencyList = new HashMap<>();

    public void addNode(String label) {
        GNode node = new GNode(label);
        // add to hash table
        vertices.putIfAbsent(label, node);
        // add empty adjacency list
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addNodeAll(String[] labels) {
        for (String label : labels) {
            GNode node = new GNode(label);
            // add to hash table
            vertices.putIfAbsent(label, node);
            // add empty adjacency list
            adjacencyList.putIfAbsent(node, new ArrayList<>());
        }
    }

    public void removeNode(String label) {
        GNode node = vertices.get(label);
        for (GNode key : adjacencyList.keySet()) {
            adjacencyList.get(key).remove(node);
        }
        vertices.remove(label);
        adjacencyList.remove(node);
    }

    public void addEdge(String from, String to) {
        GNode fromNode = vertices.get(from);
        GNode toNode = vertices.get(to);
        if (fromNode == null || toNode == null) {
            System.out.println("ERROR : Enter valid nodes");
        } else {
            adjacencyList.get(fromNode).add(toNode);
        }
    }

    public void addEdgeAll(String[][] edges) {
        for (String[] edge : edges) {
            String from = edge[0];
            String to = edge[1];

            GNode fromNode = vertices.get(from);
            GNode toNode = vertices.get(to);
            if (fromNode == null || toNode == null) {
                System.out.println("ERROR : Enter valid nodes");
            } else {
                adjacencyList.get(fromNode).add(toNode);
            }
        }
    }

    public void removeEdge(String from, String to) {
        GNode fromNode = vertices.get(from);
        GNode toNode = vertices.get(to);
        if (fromNode != null && toNode != null) {
            adjacencyList.get(fromNode).remove(toNode);
        }
    }

    // traversal
    public void dfs() {
        Map<String, Integer> visited = new HashMap<>();
        Stack<String> stack = new Stack<>();
        for (String vertex : vertices.keySet()) {
            visited.put(vertex, 0);
        }
        for (String key : vertices.keySet()) {
            if (visited.get(key) == 0) {
                System.out.println("Starting from " + key);
                stack.push(key);
                while (!stack.isEmpty()) {
                    String label = stack.pop().value;
                    System.out.println(label);
                    visited.put(label, 1);
                    for (GNode g : adjacencyList.get(vertices.get(label))) {
                        if (visited.get(g.label) == 0) {
                            stack.push(g.label);
                        }
                    }
                }
            }
        }
    }

    public void bfs() {
        Map<String, Integer> visited = new HashMap<>();
        Queue<String> queue = new Queue<>();
        for (String vertex : vertices.keySet()) {
            visited.put(vertex, 0);
        }
        for (String key : vertices.keySet()) {
            if (visited.get(key) == 0) {
                System.out.println("Starting from " + key);
                queue.push(key);
                while (!queue.isEmpty()) {
                    String label = queue.pop().value;
                    System.out.println(label);
                    visited.put(label, 1);
                    for (GNode g : adjacencyList.get(vertices.get(label))) {
                        if (visited.get(g.label) == 0) {
                            queue.push(g.label);
                        }
                    }
                }
            }
        }
    }

    public void print() {
        for (GNode key : adjacencyList.keySet()) {
            if (!adjacencyList.get(key).isEmpty())
                System.out.println(key + " is connected to " + adjacencyList.get(key));
        }
    }

}
