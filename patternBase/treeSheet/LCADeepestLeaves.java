package patternBase.treeSheet;

public class LCADeepestLeaves {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return solve(root).node;
    }

    private Result solve(TreeNode root) {

        // Base case
        if (root == null) {
            return new Result(0, null);
        }

        // Find deepest leaf in left subtree
        Result left = solve(root.left);

        // Find deepest leaf in right subtree
        Result right = solve(root.right);

        // Left subtree is deeper
        if (left.depth > right.depth) {
            return new Result(
                    left.depth + 1,
                    left.node
            );
        }

        // Right subtree is deeper
        if (right.depth > left.depth) {
            return new Result(
                    right.depth + 1,
                    right.node
            );
        }

        // Both have same depth
        // Therefore current node is LCA
        return new Result(
                left.depth + 1,
                root
        );
    }

    static class Result {
        int depth;
        TreeNode node;

        Result(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }
    }

    public static void main(String[] args) {
        LCADeepestLeaves lcaDeepestLeaves = new LCADeepestLeaves();

        // Example tree:
        //         1
        //        / \
        //       2   3
        //      / \
        //     4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeNode lca = lcaDeepestLeaves.lcaDeepestLeaves(root);
        System.out.println("LCA of deepest leaves: " + (lca != null ? lca.val : "null"));
    }
}
