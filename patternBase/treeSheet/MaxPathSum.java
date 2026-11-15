package patternBase.treeSheet;

public class MaxPathSum {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        dfs(root);

        return maxSum;
    }

    private int dfs(TreeNode root) {

        // Base case
        if (root == null) {
            return 0;
        }

        // Left subtree ka maximum gain
        // Negative hua toh ignore karenge
        int leftGain = Math.max(0, dfs(root.left));

        // Right subtree ka maximum gain
        // Negative hua toh ignore karenge
        int rightGain = Math.max(0, dfs(root.right));

        // Current node ke through complete path
        int currentPath =
                leftGain + root.val + rightGain;

        // Global maximum update
        maxSum = Math.max(maxSum, currentPath);

        // Parent ko sirf ek side return kar sakte hain
        return root.val + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {
        MaxPathSum maxPathSum = new MaxPathSum();

        // Example tree:
        //         -10
        //         /  \
        //        9   20
        //           /  \
        //          15   7

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int result = maxPathSum.maxPathSum(root);
        System.out.println("Maximum Path Sum: " + result); // Output: 42

    }
}
