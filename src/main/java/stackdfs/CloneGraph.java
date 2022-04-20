package stackdfs;

import java.util.*;

public class CloneGraph {

    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> visited = new HashMap<>();
        Node fromNode = new Node(node.val);
        nodeRecursion(visited, node, fromNode);
        return fromNode;
    }

    public static void nodeRecursion(Map<Integer, Node> visited, Node n, Node fromNode) {
        visited.put(fromNode.val, fromNode);
        for (Node node : n.neighbors) {

            if (!visited.containsKey(node.val)) {
                Node n1 = new Node(node.val);
                fromNode.neighbors.add(n1);
                nodeRecursion(visited, node, n1);
            } else {
                fromNode.neighbors.add(visited.get(node.val));
            }
        }
    }

    //[[2,4],[1,3],[2,4],[1,3]]
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node nodec = cloneGraph(node1);
        System.out.println(nodec);
    }
}
