package patternBase.treeSheet;

import java.util.*;

public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();

        dfs(root, targetSum, new ArrayList<>(), result);

        return result;
    }

    private void dfs(
            TreeNode root,
            int remainingSum,
            List<Integer> currentPath,
            List<List<Integer>> result) {

        // Base case
        if (root == null) {
            return;
        }

        // Choose
        currentPath.add(root.val);

        // Update remaining sum
        remainingSum -= root.val;

        // Leaf node
        if (root.left == null && root.right == null) {

            if (remainingSum == 0) {
                result.add(new ArrayList<>(currentPath));
            }

            // Undo
            currentPath.remove(currentPath.size() - 1);
            return;
        }

        // Explore left
        dfs(
                root.left,
                remainingSum,
                currentPath,
                result
        );

        // Explore right
        dfs(
                root.right,
                remainingSum,
                currentPath,
                result
        );

        // Undo / Backtrack
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        PathSum pathSum = new PathSum();

        // Example tree:
        //         5
        //        / \
        //       4   8
        //      /   / \
        //     11  13  4
        //    /  \    / \
        //   7    2  5   1

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;
        List<List<Integer>> result = pathSum.pathSum(root, targetSum);
        System.out.println("Paths with sum " + targetSum + ": " + result);
    }
}
