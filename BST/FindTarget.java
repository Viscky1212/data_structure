package BST;

import java.util.HashSet;
import java.util.Set;

public class FindTarget {

    public static boolean findTarget(TreeNode root, int k){
        Set<Integer> set = new HashSet<>();
        return dfs(root, k , set);
    }
    private static  boolean dfs(TreeNode node, int k, Set<Integer> set){
        if (node == null) return  false;
        //check complement
        if (set.contains(k - node.val)){
            return true;
        }

        //add current value
        set.add(node.val);

        //Traverse left or right
        return dfs(node.left, k , set) || dfs(node.right, k , set);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        System.out.println(findTarget(root, 9));  // true
        System.out.println(findTarget(root, 28)); // false
    }
}
