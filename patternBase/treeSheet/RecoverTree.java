package patternBase.treeSheet;

public class RecoverTree {

    private TreeNode first  = null;
    private TreeNode second = null;
    private TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        inorder(root);

        //swap incorrect values
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root){

        if(root == null){
            return;
        }

        //left
        inorder(root.left);

        //current node 
        if(prev != null && prev.val > root.val){

            //First violation
            if(first == null){
                first = prev;
            }

            // second violation
            second = root;
        }

        prev = root;

        //right
        inorder(root.right);
    }

    public static void main(String[] args) {
        RecoverTree recoverTree = new RecoverTree();

        // Example tree:
        //         3
        //        / \
        //       1   4
        //          /
        //         2
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        System.out.println("Before recovery:");
        printInorder(root);

        recoverTree.recoverTree(root);

        System.out.println("\nAfter recovery:");
        printInorder(root);
    }

    private static void printInorder(TreeNode root) {

    }
}
