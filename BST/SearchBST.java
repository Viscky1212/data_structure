package BST;

public class SearchBST {

    public static TreeNode searchBST(TreeNode root, int val){
        while (root != null){
            //Found node
            if (root.val == val){
                return root;
            }

            //Move left or right based on BST property
            if(val < root.val){
                root = root.left;
            }
             else {
                 root = root.right;
            }
        }

        //not found
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode result = searchBST(root, 2);

        if (result != null) {
            System.out.println("Found Node: " + result.val);
        } else {
            System.out.println("Node not found");
        }
    }
}
