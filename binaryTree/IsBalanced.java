package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class IsBalanced {

    public static boolean isBalanced(TreeNode root){
        return checkHeight(root) != -1;
    }

    private static int checkHeight(TreeNode node){
        if (node == null){
            return 0;
        }

        int leftHeight= checkHeight(node.left);

        if (leftHeight == -1) return -1;

        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight,rightHeight) + 1;
    }
    public static TreeNode buildTree(Integer[] arr){
        if (arr.length == 0 || arr[0] == null){
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length){
            TreeNode current = queue.poll();
            //left child
            if (i < arr.length && arr[i] != null){
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }

            //right child
            if (i < arr.length && arr[i] != null){
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,null,null,6,7};

        TreeNode root = buildTree(arr);
        boolean result = isBalanced(root);
        System.out.println("Is balanced Tree : " + result);
    }
}
