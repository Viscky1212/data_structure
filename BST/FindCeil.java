package BST;

public class FindCeil {

    public static int findCeil(TreeNode root , int key){
        int ceil = -1;//default if no ceil exist
        while (root != null){
            //exact match -> best answer
            if (root.val == key){
                return root.val;
            }
            //if current node is greater than key

            // If current node is greater than key
            if (root.val > key) {
                ceil = root.val;     // candidate
                root = root.left;    // try smaller valid value
            } else {
                // current value < key → go right
                root = root.right;
            }
        }
        return ceil;

    }
    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(11);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.left.right.right = new TreeNode(8);

        System.out.println(findCeil(root, 3)); // 4
        System.out.println(findCeil(root, 6)); // 7
        System.out.println(findCeil(root, 11)); // 11
        System.out.println(findCeil(root, 15)); // -1
    }
}
