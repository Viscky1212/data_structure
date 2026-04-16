package binaryTree;
import java.util.*;
public class FindMaxSubtree {

    static int maxSum = Integer.MIN_VALUE;

    public static int findMaxSubtree(TreeNode root){
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private static int dfs(TreeNode node){
        if (node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);
        int sum = left + right + node.val;
        maxSum = Math.max(maxSum, sum);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(-6);
        root.right.right = new TreeNode(2);

        int result = findMaxSubtree(root);

        System.out.println("Maximum Subtree Sum: " + result);
    }
}
