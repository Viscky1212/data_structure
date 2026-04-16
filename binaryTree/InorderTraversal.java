package binaryTree;


import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        val = data;
        left = null;
        right = null;
    }
}
public class InorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    TreeNode curr = root;

    while (curr != null){
        if (curr.left == null){
            result.add(curr.val);
            curr = curr.right;
        } else {
            TreeNode prev = curr.left;

            while (prev.right != null && prev.right != curr){
                prev = prev.right;
            }

            if (prev.right == null){
                prev.right = curr;
                curr = curr.left;
            } else {
                prev.right = null;
                result.add(curr.val);
                curr = curr.right;
            }
        }
    }
    return result;

    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);

        List<Integer> res = inorderTraversal(root);

        System.out.println(res);
    }

}
