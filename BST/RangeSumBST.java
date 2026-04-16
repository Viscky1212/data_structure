package BST;

public class RangeSumBST {
    //optimized BST Range Sum
    public static int rangeSumBST(TreeNode root, int low, int high){
        if (root == null) return 0;

        //If value is smaller than range -> ignore left subtree
        if (root.val < low){
            return rangeSumBST(root.right, low, high);
        }

        //if value is greater than range - > ignore right subtree
        if (root.val > high){
            return rangeSumBST(root.left, low,high);
        }
        //value is within range -> include it
        return root.val + rangeSumBST(root.left,low,high) + rangeSumBST(root.right,low,high);
    }

    //helper method to insert into BST
    public static TreeNode insert(TreeNode root, int val){
        if (root == null) return new TreeNode(val);
        if (val < root.val){
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right,val);
        }
        return root;
    }

    public static void inorder(TreeNode root){
        if (root == null) return;
        inorder(root.left);
        System.out.println(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
         /*
            Example 1:
                    81
                   /  \
                 71    97
                   \
                    75
                   /
                 91
        */

        int[] values1 = {81, 71, 97, 75, 91};
        TreeNode root1 = null;

        for (int val : values1) {
            root1 = insert(root1, val);
        }

        System.out.print("BST (Inorder): ");
        inorder(root1);
        System.out.println();

        int low1 = 43, high1 = 55;
        System.out.println("Range Sum [" + low1 + "," + high1 + "] = "
                + rangeSumBST(root1, low1, high1)); // Output: 0


        /*
            Example 2:
                    3
                     \
                      60
                     /  \
                    53   61
                   /
                  9
        */

        int[] values2 = {3, 60, 53, 61, 9};
        TreeNode root2 = null;

        for (int val : values2) {
            root2 = insert(root2, val);
        }

        System.out.print("\nBST (Inorder): ");
        inorder(root2);
        System.out.println();

        int low2 = 33, high2 = 65;
        System.out.println("Range Sum [" + low2 + "," + high2 + "] = "
                + rangeSumBST(root2, low2, high2)); // Output: 174

    }
}

