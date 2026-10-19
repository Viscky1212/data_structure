package patternBase.treeSheet;

import java.util.*;

public class FindTarget {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return find(root, k, set);
    }

    private boolean find(TreeNode node, int k, Set<Integer> set) {
        if (node == null) {
            return false;
        }
        if (set.contains(k - node.val)) {
            return true;
        }
        set.add(node.val);
        return find(node.left, k, set) || find(node.right, k, set);
    }

    public static void main(String[] args) {
        FindTarget findTarget = new FindTarget();
        // Example usage
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        int k = 9;
        boolean result = findTarget.findTarget(root, k);
        System.out.println("Result for k = " + k + ": " + result); //
    }
}
