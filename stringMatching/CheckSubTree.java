package stringMatching;
class  TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(){}
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class CheckSubTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot){
        if (root == null) return false;
        if ((isSameTree(root,subRoot))) return true;

        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    private boolean isSameTree(TreeNode a, TreeNode b){
        if (a == null && b == null) return true;

        if (a == null || b == null) return false;

        if (a.val != b.val) return  false;

        return isSameTree(a.left , b.left) && isSameTree(a.right, b.right);
    }

    public static void main(String[] args) {
        CheckSubTree sol = new CheckSubTree();

        // Example 1
        TreeNode root1 = new TreeNode(3,
                new TreeNode(4, new TreeNode(1), new TreeNode(2)),
                new TreeNode(5));

        TreeNode subRoot1 = new TreeNode(4,
                new TreeNode(1),
                new TreeNode(2));

        System.out.println("Example 1 Output: " + sol.isSubtree(root1, subRoot1)); // true

        // Example 2
        TreeNode root2 = new TreeNode(3,
                new TreeNode(4,
                        new TreeNode(1),
                        new TreeNode(2, new TreeNode(0), null)),
                new TreeNode(5));

        TreeNode subRoot2 = new TreeNode(4,
                new TreeNode(1),
                new TreeNode(2));

        System.out.println("Example 2 Output: " + sol.isSubtree(root2, subRoot2)); // false
    }
}
