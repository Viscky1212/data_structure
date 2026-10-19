package patternBase.treeSheet;

public class LowestCommonAncestorBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        // If both p and q are smaller than root, then LCA lies in left subtree
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // If both p and q are greater than root, then LCA lies in right subtree
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // If we reach here, then root is the LCA of p and q
        return root;
    }

    public static void main(String[] args) {
        LowestCommonAncestorBST lcaFinder = new LowestCommonAncestorBST();

        // Constructing a sample BST
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        // Finding LCA of nodes 2 and 8
        TreeNode p = root.left; // Node with value 2
        TreeNode q = root.right; // Node with value 8
        TreeNode lca = lcaFinder.lowestCommonAncestor(root, p, q);
        System.out.println("LCA of " + p.val + " and " + q.val + " is: " + lca.val);

        // Finding LCA of nodes 2 and 4
        p = root.left; // Node with value 2
        q = root.left.right; // Node with value 4
        lca = lcaFinder.lowestCommonAncestor(root, p, q);
        System.out.println("LCA of " + p.val + " and " + q.val + " is: " + lca.val);
    }
}
