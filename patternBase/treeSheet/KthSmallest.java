package patternBase.treeSheet;

import java.util.Stack;

public class KthSmallest {
//    public int kthSmallest(TreeNode root, int k) {
//        int[] count = new int[1]; // To keep track of the count of nodes visited
//        return kthSmallestHelper(root, k, count);
//    }
//
//    private int kthSmallestHelper(TreeNode node, int k, int[] count) {
//        if (node == null) {
//            return -1; // Return -1 if the node is null
//        }
//
//        // Search in the left subtree
//        int left = kthSmallestHelper(node.left, k, count);
//        if (left != -1) {
//            return left; // If found in the left subtree, return it
//        }
//
//        // Increment the count of nodes visited
//        count[0]++;
//        if (count[0] == k) {
//            return node.val; // If the current node is the kth smallest, return its value
//        }
//
//        // Search in the right subtree
//        return kthSmallestHelper(node.right, k, count);
//    }


//    public int kthSmallest(TreeNode root, int k) {
//
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode current = root;
//
//        while (current != null || !stack.isEmpty()) {
//
//            // Go left
//            while (current != null) {
//                stack.push(current);
//                current = current.left;
//            }
//
//            // Visit node
//            current = stack.pop();
//
//            k--;
//
//            if (k == 0) {
//                return current.val;
//            }
//
//            // Go right
//            current = current.right;
//        }
//
//        return -1;
//    }

    private int count;
    private int answer;

    public int kthSmallest(TreeNode root, int k) {

        count = k;

        inorder(root);

        return answer;
    }

    private void inorder(TreeNode root) {

        // Base case
        if (root == null) {
            return;
        }

        // 1. Left
        inorder(root.left);

        // 2. Root
        count--;

        if (count == 0) {
            answer = root.val;
            return;
        }

        // 3. Right
        inorder(root.right);
    }


    public static void main(String[] args) {
        KthSmallest kthSmallest = new KthSmallest();

        // Constructing a sample BST
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        int k = 3;
        int result = kthSmallest.kthSmallest(root, k);
        System.out.println("The " + k + "rd smallest element is: " + result);
    }
}
