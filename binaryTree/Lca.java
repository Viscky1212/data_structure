package binaryTree;

public class Lca {

    public TreeNode lca(TreeNode root, int n1, int n2){
        if (root == null) return null;

        if (root.val == n1 || root.val == n2) return root;

        TreeNode left =  lca(root.left,n1,n2);

        TreeNode right =  lca(root.right,n1,n2);
        if (left != null && right != null) return root;

        return (left != null) ? left : right;
    }
    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        Lca  sol = new Lca();
        TreeNode result = sol.lca(root, 5, 1);

        System.out.println("LCA: " + result.val);
    }
}
