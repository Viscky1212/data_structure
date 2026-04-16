package BST;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data){
        this.val = data;
        left = null;
        right = null;
    }
}
public class IsValidBST {

    //entry method
    public boolean isValid(TreeNode root){
        return validate(root, Long.MIN_VALUE,Long.MAX_VALUE);
    }

    //Helper method using range validation
    private boolean validate(TreeNode node, long min, long max){
        //base case
        if (node == null) return  true;
        //check BST Condition
        if (node.val <= min || node.val >= max){
            return false;
        }
        //validate left and right subtree
        return validate(node.left,min, node.val) && validate(node.right, node.val,max);
    }

    public static void main(String[] args) {
        IsValidBST sol = new IsValidBST();

        //Exam 1 : Valid BST
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);

        System.out.println("Is valid BST (Example 1) : " + sol.isValid(root1));

        //Example 2 : Invalid BST
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        System.out.println("Is valid BST (Ex 2 ): " + sol.isValid(root2));
    }


}
