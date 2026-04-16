package binaryTree;

import java.util.*;

class Pair {
    TreeNode node;
    int row;
    int col;

    Pair(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
public class VrticalTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map =
                new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root , 0, 0));

        while (!queue.isEmpty()){
            Pair p = queue.poll();

            TreeNode node = p.node;
           int row = p.row;
           int col = p.col;

           map.putIfAbsent(col,new TreeMap<>());
           map.get(col).putIfAbsent(row, new PriorityQueue<>());
           map.get(col).get(row).offer(node.val);

           if (node.left != null)queue.offer(new Pair(node.left, row + 1,col - 1));
           if (node.right != null) queue.offer(new Pair(node.right,row + 1, col + 1));

        }

        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer,PriorityQueue<Integer>> rows : map.values()){
            List<Integer> column = new ArrayList<>();

            for (PriorityQueue<Integer> pq : rows.values()){
                while (!pq.isEmpty()) column.add(pq.poll());
            }
            result.add(column);
        }
        return result;

    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        VrticalTraversal sol = new VrticalTraversal();

        List<List<Integer>> res = sol.verticalTraversal(root);

        System.out.println(res);
    }
}
