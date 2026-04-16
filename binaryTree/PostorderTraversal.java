package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
//    public static List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        postorder(root, result);
//        return result;
//
//    }
//
//    private static void postorder(TreeNode node, List<Integer> result){
//        if (node == null){
//            return;
//        }
//
//        postorder(node.left, result);
//        postorder(node.right,result);
//        result.add(node.val);
//    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();

        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.addFirst(node.val);
            if (node.left != null) stack.push(node.left);

            if (node.right != null) stack.push(node.right);
        }
        return result;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);

        List<Integer> res = postorderTraversal(root);
        System.out.println(res);
    }

}
