package binaryTree;


import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preoder(root,result);
        return result;
    }

    private static void preoder(TreeNode node, List<Integer> result){
        if (node == null){
            return;
        }
        result.add(node.val); // root
        preoder(node.left,result);  //left
        preoder(node.right,result);  //right
    }

    /*
     public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();

            result.add(node.val);

            if (node.right != null)
                stack.push(node.right);

            if (node.left != null)
                stack.push(node.left);
        }

        return result;
    }

     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        List<Integer> res = preorderTraversal(root);
        System.out.println(res);
    }

}
