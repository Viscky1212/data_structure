package interview;
import java.util.*;

// Tree node definition
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    // Constructor
    TreeNode(int val) {
        this.val = val;
    }
}


public class ZigZakTraversal {
    // Zigzag traversal method
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        // Final result
        List<List<Integer>> result = new ArrayList<>();

        // Edge case
        if (root == null) {
            return result;
        }

        // Queue for BFS
        Queue<TreeNode> queue = new LinkedList<>();

        // Add root node
        queue.offer(root);
      //  System.out.println("Left val  => "+root.left.val);
      //  System.out.println("Right val  => "+root.right.val);
      //  System.out.println("Left val  => "+root.left.left.val);
      //  System.out.println("Right val  => "+root.right.right.val);


      //  System.out.println("Left val  => "+root.left.right.val);
      //  System.out.println("Right val  => "+root.right.left.val);


        // Direction flag
        boolean leftToRight = true;

        // BFS traversal
        while (!queue.isEmpty()) {

            // Current level size
            int size = queue.size();

            // Store current level nodes
            LinkedList<Integer> currentLevel = new LinkedList<>();

            // Traverse all nodes of current level
            for (int i = 0; i < size; i++) {

                // Remove node from queue
                TreeNode currentNode = queue.poll();

                // Insert based on direction
                if (leftToRight) {

                    currentLevel.addLast(currentNode.val);

                } else {

                    currentLevel.addFirst(currentNode.val);
                }

                // Add left child
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                // Add right child
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }



            // Add current level to final result
            result.add(currentLevel);

            // Change traversal direction
            leftToRight = !leftToRight;

        }

        return result;
    }

    // Main method
    public static void main(String[] args) {

        /*
                   1
                /     \
               2       3
             /  \     /  \
            5    6   7    8
        */

// Create nodes
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(6);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);

// Create object
        ZigZakTraversal solution = new ZigZakTraversal();

// Call method
        List<List<Integer>> result = solution.zigzagLevelOrder(root);

// Print output
        System.out.println(result);
    }
}
    


