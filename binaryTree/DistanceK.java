package binaryTree;

import java.util.*;

public class DistanceK {
    public static List<Integer> distanceK(TreeNode root, int target, int k) {

        Map<TreeNode, TreeNode> parent = new HashMap<>();
        TreeNode targetNode = buildParent(root, null, target, parent);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(targetNode);
        visited.add(targetNode);

        int dist = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            if (dist == k)
                break;

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                if (node.left != null && !visited.contains(node.left)) {
                    queue.offer(node.left);
                    visited.add(node.left);
                }

                if (node.right != null && !visited.contains(node.right)) {
                    queue.offer(node.right);
                    visited.add(node.right);
                }

                TreeNode par = parent.get(node);
                if (par != null && !visited.contains(par)) {
                    queue.offer(par);
                    visited.add(par);
                }
            }

            dist++;
        }

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty())
            result.add(queue.poll().val);

        Collections.sort(result);

        return result;
    }

    private static TreeNode buildParent(TreeNode node, TreeNode par,
                                        int target, Map<TreeNode, TreeNode> parent) {

        if (node == null)
            return null;

        parent.put(node, par);

        if (node.val == target)
            return node;

        TreeNode left = buildParent(node.left, node, target, parent);
        if (left != null)
            return left;

        return buildParent(node.right, node, target, parent);
    }
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        List<Integer> result = distanceK(root, 2, 1);

        System.out.println(result);
    }
    }
