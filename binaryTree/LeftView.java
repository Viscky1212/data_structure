package binaryTree;
import  java.util.*;

public class LeftView {

    public static List<Integer> leftView(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    if (root == null) return result;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()){
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            if (i == 0) result.add(node.val);
            if (node.left != null)queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }
    return result;
    }

        public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);

            List<Integer> view = leftView(root);

            System.out.println(view);
    }
}
