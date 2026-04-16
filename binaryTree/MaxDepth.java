package binaryTree;

public class MaxDepth {

    public static int maxDepth(TreeNode root) {
    //Base case
        if (root == null){
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth,rightDepth);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.right.right = new TreeNode(8);

        int depth = maxDepth(root);

        System.out.println("Maximum Depth of Tree: " + depth);

    }
    }
