package binaryTree;

import java.util.HashSet;
import java.util.Set;

public class HasDuplicateValues {

    public static boolean hasDuplicateValues(TreeNode root){
        Set<Integer> set = new HashSet<>();
        return dfs(root,set);
    }

    private static boolean dfs(TreeNode node, Set<Integer> set){
       if (node == null) return false;
       if (set.contains(node.val)) return true;

       set.add(node.val);
       return dfs(node.left,set) || dfs(node.right,set);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(18);
        root.right = new TreeNode(16);

        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(11);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        root.right.right.right = new TreeNode(2); // duplicate

        System.out.println(hasDuplicateValues(root));
    }
}
