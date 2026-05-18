package hashtable.may18;

import java.util.*;
// Sol : 2
public class BinaryTreeBuild {

    private Map<Integer,Integer> inorderIndexMap;
    private int[] postorder;
    private int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder){
        this.postorder = postorder;
        this.postIndex = postorder.length - 1;
        this.inorderIndexMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i],i);
        }
        return build(0,inorder.length - 1);
    }

    private TreeNode build(int inStart, int inEnd){
        if (inStart > inEnd){
            return null;
        }

        int rootValue = postorder[postIndex];
        postIndex--;

        TreeNode root = new TreeNode(rootValue);

        int rootIndex = inorderIndexMap.get(rootValue);
        root.right = build(rootIndex + 1,inEnd);
        root.left = build(inStart,rootIndex - 1);
        return root;
    }

    private static  void printLevelOrder(TreeNode root){
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
        BinaryTreeBuild sol = new BinaryTreeBuild();

        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        TreeNode root = sol.buildTree(inorder,postorder);
        printLevelOrder(root);
    }
}
