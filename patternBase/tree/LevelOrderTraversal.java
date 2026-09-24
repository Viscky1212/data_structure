package patternBase.tree;

import java.util.*;

public class LevelOrderTraversal {

    /*


                     Dadaji
                   /      \
                Papa      Chacha
               /   \      /    \
          Child1  Child2 Child3 Child4

Level 1 → Dadaji

Level 2 → Papa Chacha

Level 3 → Child1 Child2 Child3 Child4

[
    [Dadaji],
    [Papa, Chacha],
    [Child1, Child2, Child3, Child4]
]



    public List<List<Integer>> levelOrder(Node root) {

    List<List<Integer>> result = new ArrayList<>();

    if (root == null) {
        return result;
    }

    Queue<Node> queue = new ArrayDeque<>();

    queue.offer(root);

    while (!queue.isEmpty()) {

        // Number of nodes in current level
        int levelSize = queue.size();

        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < levelSize; i++) {

            Node node = queue.poll();

            // Add current node
            temp.add(node.data);

            // Add children for next level
            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        result.add(temp);
    }

    return result;
}
     */

    public static void main(String[] args) {
        LevelOrderTraversal tree = new LevelOrderTraversal();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Level order traversal of binary tree is:");
        List<List<Integer>> result = tree.levelOrder(root);
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }

        public List<List<Integer>> levelOrder(Node root) {

            List<List<Integer>> result = new ArrayList<>();

            if (root == null) {
                return result;
            }

            Queue<Node> queue = new ArrayDeque<>();

            // Start BFS with root
            queue.offer(root);

            while (!queue.isEmpty()) {

                // Number of nodes present in current level
                int levelSize = queue.size();

                List<Integer> currentLevel = new ArrayList<>();

                // Process only current level nodes
                for (int i = 0; i < levelSize; i++) {

                    Node current = queue.poll();

                    currentLevel.add(current.data);

                    // Add left child
                    if (current.left != null) {
                        queue.offer(current.left);
                    }

                    // Add right child
                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                }

                result.add(currentLevel);
            }

            return result;
        }
    }
