package patternBase.treeSheet;

public class IsValidBST {
    private TreeNode previous = null;

    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }

        if (previous != null && root.val <= previous.val) {
            return false;
        }

        previous = root;

        return isValidBST(root.right);
    }

    public static void main(String[] args) {
        IsValidBST isValidBST = new IsValidBST();

        // Example usage
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        boolean result = isValidBST.isValidBST(root);
        System.out.println("Is the tree a valid BST? " + result); // Output: true
    }
}
