package binaryTree;

public class SufficientSubset {


    public TreeNode sufficientSubset(TreeNode root, int limit) {

        if (root == null)
            return null;

        limit -= root.val;

        if (root.left == null && root.right == null) {
            if (limit > 0)
                return null;
            else
                return root;
        }

        root.left = sufficientSubset(root.left, limit);
        root.right = sufficientSubset(root.right, limit);

        if (root.left == null && root.right == null)
            return null;

        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-100);
        root.left = new TreeNode(93);
        root.right = new TreeNode(77);

        root.left.left = new TreeNode(80);
        root.left.right = new TreeNode(-2);

        root.right.right = new TreeNode(55);

        SufficientSubset sol = new SufficientSubset();

        TreeNode result = sol.sufficientSubset(root, 71);

        System.out.println("Tree pruned successfully.");
    }
}