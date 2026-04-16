package binaryTree;

import java.util.*;


public class checkEqualTree {

    static Set<Integer> set = new HashSet<>();

    public static boolean checkEqualTree(TreeNode root) {

        // ⭐ FIX: clear previous subtree sums
        set.clear();

        if (root == null) return false;

        int totalSum = dfs(root);

        // remove full tree sum
        set.remove(totalSum);

        if (totalSum % 2 != 0)
            return false;

        return set.contains(totalSum / 2);
    }

    private static int dfs(TreeNode node) {

        if (node == null)
            return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        int sum = node.val + left + right;

        set.add(sum);

        return sum;
    }

public static void main(String[] args) {

        /*
                1
               / \
              2   3
             / \
            4   4
        */

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(4);

    boolean result = checkEqualTree(root);

    if (result)
        System.out.println(1);
    else
        System.out.println(0);
}

}
