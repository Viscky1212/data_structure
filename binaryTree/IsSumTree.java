package binaryTree;

public class IsSumTree {

        static class Pair {
            boolean isSumTree;
            int sum;

            Pair(boolean isSumTree, int sum) {
                this.isSumTree = isSumTree;
                this.sum = sum;
            }
        }

        public static boolean isSumTree(TreeNode root) {
            return helper(root).isSumTree;
        }

        private static Pair helper(TreeNode node) {

            if (node == null)
                return new Pair(true, 0);

            // leaf node
            if (node.left == null && node.right == null)
                return new Pair(true, node.val);

            Pair left = helper(node.left);
            Pair right = helper(node.right);

            boolean condition =
                    left.isSumTree &&
                            right.isSumTree &&
                            node.val == left.sum + right.sum;

            int totalSum = node.val + left.sum + right.sum;

            return new Pair(condition, totalSum);
        }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        boolean result = isSumTree(root);

        System.out.println(result);
    }
}
