package binaryTree;

public class MinDepth {

    public int minDepth(TreeNode root){
        if (root == null) return 0;
        if (root.left == null) return 1 + minDepth((root.right));
        if (root.right == null) return 1 + minDepth(root.left);

        return 1 + Math.min(minDepth(root.left),minDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MinDepth sol = new MinDepth();

        System.out.println(sol.minDepth(root));
    }
}
