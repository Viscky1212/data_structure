package binaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class Boundary {

    public static ArrayList<Integer> boundary(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        //root
        res.add(root.val);

        //left boundary(excluding leaf
        addLeftBoundary(root.left,res);

        //leaf node
        addLeaves(root,res);

        //right boundary (reverse)
        addRightBoundry(root.right,res);

        return res;

    }

    //Add left boundary (excluding leaf nodes )
    public static void addLeftBoundary(TreeNode node,ArrayList<Integer> res){
        while(node != null){
            if (!isLeaf(node)){
                res.add(node.val);
            }
            if (node.left != null){
                node= node.left;
            } else{
                node = node.right;
            }
        }
    }

    //Add leaf nodes
    public static void addLeaves(TreeNode node , ArrayList<Integer> res){
        if (node == null) return;
        if (isLeaf(node)){
            res.add(node.val);
            return;
        }
        addLeaves(node.left,res);
        addLeaves(node.right,res);
    }
    public static void addRightBoundry(TreeNode node , ArrayList<Integer> res){
        Stack<Integer> stack = new Stack<>();

        while (node != null){
            if (!isLeaf(node)){
                stack.push(node.val);
            }

            if (node.right != null){
                node = node.right;
            } else {
                node = node.left;
            }
        }

        //Add in reverse
        while (!stack.isEmpty()){
            res.add(stack.pop());
        }
    }

    //check if leaf node
    private static boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }

    // 🔥 Main method for testing
    public static void main(String[] args) {

        /*
                1
               / \
              2   3
             / \ / \
            4  5 6  7
              / \
             8   9
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        ArrayList<Integer> result = boundary(root);

        System.out.println("Boundary Traversal: " + result);
        // Expected: [1, 2, 4, 8, 9, 6, 7, 3]
    }
}
