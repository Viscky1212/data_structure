package hashtable.may18;

//Sol : 1

import java.util.*;

public class BuildTree {

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private Map<Integer,Integer> inorderIndexMap;
    private int[] preorder;

    public TreeNode builTree(int[] preorder, int[] inorder){
        this.preorder = preorder;
        this.inorderIndexMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i],i);
        }

        return build(0,preorder.length - 1,0, inorder.length - 1);
    }

    private TreeNode build(int preStart, int preEnd,  int inStart, int inEnd){
        if (preStart > preEnd || inStart > inEnd){
            return null;
        }

        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);

        int rootIndex = inorderIndexMap.get(rootValue);
        int leftSize = rootIndex - inStart;

        root.left = build(
                preStart + 1,
                preStart + leftSize,
                inStart,
                rootIndex - 1
        );

        root.right = build(
                preStart + leftSize + 1,
                preEnd,
                rootIndex + 1,
                inEnd
        );

        return root;
    }

    public static  void  printLevelOrder(TreeNode root){
        if (root == null){
            System.out.println("[]");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();

        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();

            if (node == null){
                result.add("null");
                continue;
            }

            result.add(String.valueOf(node.val));
            queue.offer(node.left);
            queue.offer(node.right);
        }

        while (!result.isEmpty() && result.get(result.size() - 1).equals("null")){
            result.remove(result.size() - 1);
        }
        System.out.println(result);
    }
    public static void main(String[] args) {
        BuildTree sol = new BuildTree();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode root = sol.builTree(preorder,inorder);
        printLevelOrder(root);

    }
}
