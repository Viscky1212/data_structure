package binaryTree;

import java.util.*;


public class VerticalTraversal {


        public List<List<Integer>> verticalTraversal(TreeNode root) {

            TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

            Queue<Object[]> queue = new LinkedList<>();
            queue.offer(new Object[]{root, 0, 0}); // node, row, column

            while (!queue.isEmpty()) {

                Object[] arr = queue.poll();
                TreeNode node = (TreeNode) arr[0];
                int row = (int) arr[1];
                int col = (int) arr[2];

                map.putIfAbsent(col, new TreeMap<>());
                map.get(col).putIfAbsent(row, new PriorityQueue<>());
                map.get(col).get(row).offer(node.val);

                if (node.left != null)
                    queue.offer(new Object[]{node.left, row + 1, col - 1});

                if (node.right != null)
                    queue.offer(new Object[]{node.right, row + 1, col + 1});
            }

            List<List<Integer>> result = new ArrayList<>();

            for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {

                List<Integer> column = new ArrayList<>();

                for (PriorityQueue<Integer> pq : rows.values()) {
                    while (!pq.isEmpty())
                        column.add(pq.poll());
                }

                result.add(column);
            }

            return result;
        }

        // ----------- Main Method -----------
        public static void main(String[] args) {

        /*
                1
                 \
                  2
                 /
                3
               /
              4
               \
                5
               /
              6
        */

            TreeNode root = new TreeNode(1);
            root.right = new TreeNode(2);
            root.right.left = new TreeNode(3);
            root.right.left.left = new TreeNode(4);
            root.right.left.left.right = new TreeNode(5);
            root.right.left.left.right.left = new TreeNode(6);

            VerticalTraversal sol = new VerticalTraversal();

            List<List<Integer>> result = sol.verticalTraversal(root);

            System.out.println(result);
        }
    }
