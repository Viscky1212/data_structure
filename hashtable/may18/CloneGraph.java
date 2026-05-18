package hashtable.may18;

import java.util.*;
//Sol : 4
public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node(){
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val){
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors){
            val = _val;
            neighbors = _neighbors;
        }
    }

    //<------------------------------------------>
    private Map<Node,Node> visited = new HashMap<>();
    public Node cloneGraph(Node node){
        if (node == null){
            return null;
        }

        //if already cloned then return clone
        if (visited.containsKey(node)){
            return visited.get(node);
        }

        //create cloned node
        Node cloneNode = new Node(node.val);

        //Store before visiting neighbors to avoid cycle issue
        visited.put(node,cloneNode);

        //clone all neighbors
        for (Node neighbors : node.neighbors){
            cloneNode.neighbors.add(cloneGraph(neighbors));
        }
        return cloneNode;
    }

    private static void printGraph(Node node){
        if (node == null){
            System.out.println("[]");
            return;
        }

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);
        visited.add(node);

        while (!queue.isEmpty()){
            Node current = queue.poll();

            System.out.println(current.val + " -->");
            List<Integer> neighborValue = new ArrayList<>();

            for(Node neighbor : current.neighbors){
                neighborValue.add(neighbor.val);

                if (!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
            System.out.println(neighborValue);
        }
    }


    public static void main(String[] args) {

        /*
            Create graph:

            1 -- 2
            |    |
            4 -- 3

            adjacency list:
            [[2,4],[1,3],[2,4],[1,3]]
        */

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

        CloneGraph sol = new CloneGraph();

        Node clonedGraph = sol.cloneGraph(node1);

        System.out.println("Original Graph:");
        printGraph(node1);

        System.out.println("Cloned Graph:");
        printGraph(clonedGraph);

        System.out.println("Is deep copy? " + (node1 != clonedGraph));
    }
}
