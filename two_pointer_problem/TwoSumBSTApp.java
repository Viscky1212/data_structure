package two_pointer_problem;

import java.util.HashSet;
import java.util.Set;

// Tree Node Definition
    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }
public class TwoSumBSTApp {
        public boolean findTarget(TreeNode root, int k){
            Set<Integer> set = new HashSet<>();
            return dfs(root, k, set);
        }

        private boolean dfs(TreeNode node, int k, Set<Integer>set){
            if (node == null) return false;

            //check if complement exists

            if (set.contains(k - node.val)){
                return true;
            }

            //add current value
            set.add(node.val);

            //Traverse left or right
            return dfs(node.left , k , set) || dfs(node.right, k, set);
        }

    public static void main(String[] args) {

        /*
              5
             / \
            3   6
           / \   \
          2   4   7
        */

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        TwoSumBSTApp solution = new TwoSumBSTApp();

        int k1 = 9;
        int k2 = 28;

        System.out.println("Result for k = " + k1 + ": " + solution.findTarget(root, k1));
        System.out.println("Result for k = " + k2 + ": " + solution.findTarget(root, k2));
    }

}
