package BST;

public class DeleteNode {

    public static  TreeNode deleteNode(TreeNode root, int value){
        if (root == null) return null;

        //step 1 : Search node
        if (value < root.val){
            root.left = deleteNode(root.left,value);
        } else if (value > root.val) {
            root.right = deleteNode(root.right,value);
        } else {
            //Not found apply case
            //case 1 : No child (leaf)
            if (root.left == null && root.right == null){
                return null;
            }
            //case 2 : One child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            //case 3 : Two children
            //Find inorder successor (smallest in right subtree)
            TreeNode successor = findMin(root.right);

            // Replace value
            root.val = successor.val;

            //delete successor
            root.right = deleteNode(root.right, successor.val);
        }
        return root;
    }
    public static TreeNode findMin(TreeNode node){
        while (node.left != null){
            node = node.left;
        }
        return node;
    }

    public static void inorder(TreeNode root){
        if (root == null) return;
        inorder(root.left);
        System.out.println(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(11);
        root.right.right.left.left = new TreeNode(4);
        root.right.right.left.right = new TreeNode(7);
        root.right.right.right.left = new TreeNode(9);
        root.right.right.right.right = new TreeNode(12);

        root = deleteNode(root, 8);

        inorder(root); // Output should be sorted
    }
}
