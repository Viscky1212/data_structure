package binarySearch;

import org.w3c.dom.Node;

class TreeNode {
    int val;
   TreeNode left;
   TreeNode right;

   TreeNode(){}

    TreeNode(int val){
       this.val = val;
    }

    TreeNode(int val,TreeNode left, TreeNode right){
       this.val = val;
       this.left = left;
       this.right = right;
    }
}

public class CountNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getLeftHeight(root.left);
        int rightHeight = getLeftHeight(root.right);

        if (leftHeight == rightHeight) {
            return (1 << leftHeight) + countNodes(root.right);
        } else {
            return (1 << rightHeight) + countNodes(root.left);
        }
    }

    private int getLeftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }


    public static void main(String[] args) {
        CountNodes sol = new CountNodes();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        System.out.println(sol.countNodes(root1)); // 6

        TreeNode root2 = null;
        System.out.println(sol.countNodes(root2)); // 0

        TreeNode root3 = new TreeNode(1);
        System.out.println(sol.countNodes(root3)); // 1
    }

}
