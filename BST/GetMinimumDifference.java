package BST;

public class GetMinimumDifference {

    private  Integer prev;
    private  int minDiff;

    public int getMinimumDifference(TreeNode root){
        //Reset for every test case
        prev = null;
        minDiff = Integer.MAX_VALUE;

         inorder(root);
         return minDiff;
    }

    public  void inorder(TreeNode node){
        if (node == null) return;
        //left
        inorder(node.left);
        //Process current node
        if (prev != null ){
            minDiff = Math.min(minDiff, node.val - prev);
        }

        prev = node.val;

        //right
        inorder(node.right);

    }

    public static void main(String[] args) {
        GetMinimumDifference sol = new GetMinimumDifference();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println(sol.getMinimumDifference(root)); // Output: 1
    }

}
