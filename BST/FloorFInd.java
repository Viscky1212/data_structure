package BST;

public class FloorFInd {
    public static int floor(TreeNode root, int x){
        int floor = -1; //default if no valid floor exist

        while (root != null){
            //exact match -> best posible answer
            if (root.val == x){
                return root.val;
            }
            //if current node is smaller than x
            if (root.val < x){
                floor = root.val;  //candidate
                root = root.right; //try to find closer value

            } else {
                //current value > x -> go left
                root = root.left;
            }
        }
        return floor;
    }

    public static void main(String[] args) {
        //constructing sample BST
        TreeNode root = new TreeNode(2);
        root.right =new TreeNode(81);
        root.right.left = new TreeNode(42);
        root.right.right = new TreeNode(87);
        root.right.left.right = new TreeNode(66);
        root.right.left.right.left = new TreeNode(45);
        root.right.right.right = new TreeNode(90);

        System.out.println(floor(root, 87));
        System.out.println(floor(root, 50));
        System.out.println(floor(root, 1));
    }
}
