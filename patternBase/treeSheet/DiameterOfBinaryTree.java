package patternBase.treeSheet;

public class DiameterOfBinaryTree {

    private int diameter = 0;

    private int height(TreeNode root){
        //Base case
        if(root == null){
            return 0;
        }

        //1. Left subtree ki height
        int leftHeight = height(root.left);

        //2. Right subtree ki hight
        int rightHeight = height(root.right);

        //3.current Node se passing diameter
        diameter = Math.max(diameter, leftHeight + rightHeight);

        //4. Parent ko current subtree ki hright return karo
        return 1 + Math.max(leftHeight , rightHeight);
    }


    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();

        // Example tree:
        //         1
        //        / \
        //       2   3
        //      / \
        //     4   5

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int diameter = diameterOfBinaryTree.diameterOfBinaryTree(root);
        System.out.println("Diameter of the binary tree: " + diameter); // Output: 3
    }
}
