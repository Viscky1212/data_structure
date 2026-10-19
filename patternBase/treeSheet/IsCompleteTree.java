package patternBase.treeSheet;

import java.util.*;

public class IsCompleteTree {

    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        boolean nullFound = false;

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            // Once null is found,
            // no non-null node should appear afterwards
            if (current == null) {
                nullFound = true;
                continue;
            }

            // Non-null node after null means
            // tree is not complete
            if (nullFound) {
                return false;
            }

            // Add children, including null
            queue.offer(current.left);
            queue.offer(current.right);
        }

        return true;
    }

    public static void main(String[] args) {
        IsCompleteTree isCompleteTree = new IsCompleteTree();

        // Example tree:
        //         1
        //        / \
        //       2   3
        //      / \ /
        //     4  5 6
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        boolean result = isCompleteTree.isCompleteTree(root);
        System.out.println("Is the tree complete? " + result); // Output: true
    }
}
