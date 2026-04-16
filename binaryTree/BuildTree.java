package binaryTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildTree {
    static int preorderIndex = 0;
    static Map<Integer, Integer>  inorderMap = new HashMap<>();

    public static TreeNode buildTree(List<Integer> preorder, List<Integer> inorder){
        preorderIndex = 0;
        inorderMap.clear();

        //store inorder value -> index
        for (int i = 0; i < inorder.size(); i++) {
            inorderMap.put(inorder.get(i),i);
        }
        return build(preorder,0,inorder.size() - 1);
    }

    private static TreeNode build(List<Integer> preorder, int left, int right) {

        if (left > right) return null;

        //pick current root from preorder
        int rootVal = preorder.get(preorderIndex++);
        TreeNode root = new TreeNode(rootVal);

        //Find root position inorder
        int index = inorderMap.get(rootVal);

        //Build left subtree
        root.left = build(preorder, left,index - 1);

        //Build right subtree
        root.right = build(preorder,index + 1, right);
        return root;
    }

    //-----------------helper for testing ----------------------//
    public static void printPreorder(TreeNode root){
        if (root == null) return;
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    public static void main(String[] args) {

        List<Integer> preorder = Arrays.asList(3, 2, 5, 1, 4);
        List<Integer> inorder = Arrays.asList(2, 1, 5, 4, 3);

        TreeNode root = buildTree(preorder, inorder);

        System.out.println("Preorder of constructed tree:");

        printPreorder(root);
    }
    }
