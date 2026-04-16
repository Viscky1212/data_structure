package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public static List<String> binaryTreePaths(TreeNode root){

        List<String> result = new ArrayList<>();
        if (root == null) return result;

        dfs(root, "", result);
        return result;
    }

    private static void dfs(TreeNode node, String path,List<String> result){

        if (node == null) return;
        if (path.length() == 0) path = "" + node.val;
        else path = path + "->" + node.val;
        //leaf node
        if (node.left == null && node.right == null){
            result.add(path);
            return;
        }
        dfs(node.left,path,result);
        dfs(node.right,path,result);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        List<String> paths = binaryTreePaths(root);

        System.out.println(paths);
    }
}
