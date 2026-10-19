package patternBase.treeSheet;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class FlipEquiv {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        //base condition
        if(root1 == null && root2 == null){
            return true;
        }

        if(root1 == null || root2 == null){
            return false;
        }

        if(root1.val != root2.val){
            return false;
        }

        //check for both flipped and non-flipped cases
        boolean nonFlipped = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        boolean flipped = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);

        return nonFlipped || flipped;
    }

    public static void main(String[] args) {
        FlipEquiv flipEquiv = new FlipEquiv();

        // Create two example trees
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        root2.right.left = new TreeNode(5);
        root2.right.right = new TreeNode(4);
        root2.left.right = new TreeNode(6);

        boolean result = flipEquiv.flipEquiv(root1, root2);
        System.out.println("Are the two trees flip equivalent? " + result);
    }
}
