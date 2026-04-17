package recursion;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class AllPossibleFBT {

    private Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n){
        if (n % 2 == 0) return new ArrayList<>();

        if (memo.containsKey(n)) return memo.get(n);

        List<TreeNode> res = new ArrayList<>();

        //Base case
        if (n == 1){
            res.add(new TreeNode(0));
            memo.put(n, res);
            return res;
        }

        //Try all possible
        for (int leftNodes = 1; leftNodes < n; leftNodes += 2) {
            int rightNode = n - 1 - leftNodes;

            List<TreeNode> leftTrees = allPossibleFBT(leftNodes);
            List<TreeNode> rightTrees = allPossibleFBT(rightNode);

            for (TreeNode left : leftTrees){
                for (TreeNode right : rightTrees){
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;

                    res.add(root);
                }
            }
        }
        memo.put(n, res);
        return res;
    }

    public static void printTree(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<String> res = new ArrayList<>();

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node == null){
                res.add("null");
                continue;
            }
            res.add(String.valueOf(node.val));
            queue.offer(node.left);
            queue.offer(node.right);
        }
        System.out.println(res);
    }



    public static void main(String[] args) {

        AllPossibleFBT sol = new AllPossibleFBT();

        int n = 7;

        List<TreeNode> trees = sol.allPossibleFBT(n);

        System.out.println("Total Trees: " + trees.size());

        int count = 1;
        for (TreeNode root : trees) {
            System.out.print("Tree " + count++ + ": ");
            printTree(root);
        }
    }

}
