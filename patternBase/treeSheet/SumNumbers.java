package patternBase.treeSheet;

public class SumNumbers {
    public int sumNumbers(TreeNode root) {

        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int currentNumber) {

        // Base case
        if (root == null) {
            return 0;
        }

        // Current number update
        currentNumber = currentNumber * 10 + root.val;

        // Leaf node
        if (root.left == null && root.right == null) {
            return currentNumber;
        }

        // Explore left and right
        return dfs(root.left, currentNumber)
                + dfs(root.right, currentNumber);
    }

    public static void main(String[] args) {
        SumNumbers sumNumbers = new SumNumbers();

        // Example tree:
        //         1
        //        / \
        //       2   3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        int result = sumNumbers.sumNumbers(root);
        System.out.println("Sum of numbers from root to leaf: " + result); // Output: 25 (12 + 13)
    }
}
