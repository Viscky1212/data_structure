package binaryTree;

import java.util.HashMap;
import java.util.*;

public class BuildTree2 {

    static int postIndex;
    static Map<Integer,Integer> inoderMap = new HashMap<>();
    public static TreeNode buildTree(List<Integer> inorder, List<Integer> postorder) {
        postIndex = postorder.size() - 1;
        inoderMap.clear();

        //store inorder value -> index for fast lookup
        for (int i = 0; i < inorder.size(); i++) {
            inoderMap.put(inorder.get(i),i);
        }
        return build(inorder,postorder,0,inorder.size() - 1);
    }
    private static TreeNode build(List<Integer> inorder, List<Integer> postorder,
                                  int left, int right) {
        if (left > right) return null;
        //root value from postorder
        int rootVal = postorder.get(postIndex--);

        TreeNode root = new TreeNode(rootVal);
        int index = inoderMap.get(rootVal);

        //build right subtree first
        root.right = build(inorder,postorder,index + 1,right);

        //build left subtree
        root.left = build(inorder,postorder,left,index - 1);
        return root;
    }
    public static void printPreorder(TreeNode root) {

        if (root == null) return;
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

        public static void main(String[] args) {

            List<Integer> inorder = Arrays.asList(2, 1, 5, 4, 3);
            List<Integer> postorder = Arrays.asList(1, 4, 5, 2, 3);

            TreeNode root = buildTree(inorder, postorder);

            System.out.println("Preorder traversal of constructed tree:");

            printPreorder(root);
    }
}
