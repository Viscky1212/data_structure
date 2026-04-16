package BST;

public class IncreasingBST {

    public TreeNode increasingBST(TreeNode root) {

        // ✅ Reset state for each test case
        prev = null;
        newRoot = null;

        inorder(root);
        return newRoot;
    }

    private TreeNode prev;
    private TreeNode newRoot;

    private void inorder(TreeNode node) {

        if (node == null) return;

        inorder(node.left);

        // First node becomes new root
        if (prev == null) {
            newRoot = node;
        } else {
            prev.right = node;
        }

        node.left = null; // ❗ important

        prev = node;

        inorder(node.right);
    }

    public static void main(String[] args) {
        IncreasingBST sol = new IncreasingBST();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);

        TreeNode newRoot = sol.increasingBST(root);

        // Print result
        TreeNode curr = newRoot;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.right;
        }
    }
}
