package binaryTree;

import javax.swing.plaf.PanelUI;
import java.security.PublicKey;
import java.util.LinkedList;
import java.util.Queue;

public class LongestConsecutive {
    private int maxLength;

    public int longestConsecutive(TreeNode root) {
        if (root == null) return -1;

        maxLength = 0; // ✅ reset for each test case

        dfs(root, null, 0);

        return maxLength <= 1 ? -1 : maxLength;
    }

    private void dfs(TreeNode node, TreeNode parent, int length) {
        if (node == null) return;

        // ✅ Check consecutive
        if (parent != null && node.val == parent.val + 1) {
            length++;
        } else {
            length = 1;
        }

        maxLength = Math.max(maxLength, length);

        dfs(node.left, node, length);
        dfs(node.right, node, length);
    }

    // 🔧 Helper to build tree manually
    public static TreeNode buildExample1() {
        /*
                1
                 \
                  2
                 /
                3
               /
              4
        */
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.left.left = new TreeNode(4);
        return root;
    }

    public static TreeNode buildExample2() {
        /*
                1
               / \
              2   3
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        return root;
    }

    // 🚀 Main Method
    public static void main(String[] args) {

        LongestConsecutive sol = new LongestConsecutive();

        // Example 1
        TreeNode root1 = buildExample1();
        System.out.println("Longest Consecutive Path: "
                + sol.longestConsecutive(root1)); // Expected: 4

        // Example 2
        TreeNode root2 = buildExample2();
        System.out.println("Longest Consecutive Path: "
                + sol.longestConsecutive(root2)); // Expected: 2
    }
}
