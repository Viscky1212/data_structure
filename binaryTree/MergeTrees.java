package binaryTree;

public class MergeTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2){
        //if first tree is null
        if (root1 == null) return root2;
        //If second tree is null
        if (root2 == null) return root1;

        //create new node with merge value
        TreeNode merged = new TreeNode(root1.val + root2.val);

        //merged left children
        merged.left = mergeTrees(root1.left , root2.left);

        //Merge right children
        merged.right = mergeTrees(root1.right,root2.right);
        return merged;
    }
    public static void printTree(TreeNode root){
        if (root == null) return;

        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        MergeTrees sol = new MergeTrees();

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        /*
            Tree 2
                2
               / \
              1   3
               \   \
                4   7
        */

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        // Merge trees
        TreeNode mergedTree = sol.mergeTrees(root1, root2);

        System.out.println("Merged Tree (Preorder Traversal):");

        printTree(mergedTree);

    }
}
