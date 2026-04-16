package BST;

import java.util.Stack;

public class KthSmallest {

//    static int count = 0;
//    static int result = -1;
//
//    public static int kthSmallest(TreeNode root, int k) {
//        count = 0;
//        result = -1;
//        inorder(root, k);
//        return result;
//    }
//
//    private static void inorder(TreeNode node, int k) {
//        if (node == null) return;
//
//        inorder(node.left, k);
//
//        count++;
//        if (count == k) {
//            result = node.val;
//            return;
//        }
//
//        inorder(node.right, k);
//    }
    //<=====================================================================>

    public static int kthSmallest(TreeNode root, int k){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || stack.isEmpty()){
            //go left
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }

            //process node
            curr = stack.pop();
            k--;

            //if kth element found
            if (k == 0) return curr.val;

            //move right
            curr= curr.right;
        }
        return -1;   // if k number of node

    }

    //helper : insert into BST
    public static TreeNode insert(TreeNode root, int val){
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left,val);
        else root.right= insert(root.right, val);
        return root;
    }

    //Inorder (for debugging)
    public static void inorder(TreeNode root){
         if (root == null) return;
         inorder(root.left);
        System.out.println(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        // Example 1
        int[] values1 = {52, 46, 98, 16, 88};
        TreeNode root1 = null;

        for (int val : values1) {
            root1 = insert(root1, val);
        }

        System.out.print("BST Inorder: ");
        inorder(root1);
        System.out.println();

        int k1 = 5;
        System.out.println("Kth Smallest (" + k1 + ") = "
                + kthSmallest(root1, k1)); // Expected: 98


        // Example 2
        int[] values2 = {39, 22, 59, 19, 38, 49, 70};
        TreeNode root2 = null;

        for (int val : values2) {
            root2 = insert(root2, val);
        }

        System.out.print("\nBST Inorder: ");
        inorder(root2);
        System.out.println();

        int k2 = 2;
        System.out.println("Kth Smallest (" + k2 + ") = "
                + kthSmallest(root2, k2)); // Expected: 22

    }

}
