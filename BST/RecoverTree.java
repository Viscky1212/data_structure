package BST;

public class RecoverTree {


    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = null;

    public void recoverTree(TreeNode root) {

        // Reset (important for multiple test cases)
        first = null;
        second = null;
        prev = null;

        inorder(root);

        // Swap the two incorrect nodes
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        // 🔍 Detect violation
        if (prev != null && prev.val > node.val) {

            // First violation
            if (first == null) {
                first = prev;
            }

            // Second violation
            second = node;
        }

        prev = node;

        inorder(node.right);
    }

    // 🔧 Helper: inorder print
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    // 🚀 Main Method
    public static void main(String[] args) {
       RecoverTree sol = new RecoverTree();

        /*
            Example:
                70
               /
             94   (swapped)
             /
           28
          /
        14
        */

        TreeNode root = new TreeNode(70);
        root.left = new TreeNode(94);
        root.left.left = new TreeNode(28);
        root.left.left.left = new TreeNode(14);

        System.out.print("Before Fix (Inorder): ");
        printInorder(root);
        System.out.println();

        sol.recoverTree(root);

        System.out.print("After Fix (Inorder): ");
        printInorder(root);
        System.out.println();
    }
}
