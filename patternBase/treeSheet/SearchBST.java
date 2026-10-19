package patternBase.treeSheet;

public class SearchBST {

//    public TreeNode searchBST(TreeNode root, int val) {
//        //base condition
//        if(root == null || root.val == val){
//            return root;
//        }
//
//        if(val < root.val){
//            return searchBST(root.left, val);
//        } else {
//            return searchBST(root.right, val);
//        }
//    }

    public TreeNode searchBST(TreeNode root, int val) {

        // Base case:
        // Tree empty OR value not found
        if (root == null) {
            return null;
        }

        System.out.println("Visiting node with value: " + root.val);
        System.out.println("Current target value: " + val);

        // Value found
        if (root.val == val) {
            return root;
        }

        // Target is smaller
        if (val < root.val) {
            return searchBST(root.left, val);
        }

        // Target is greater
        return searchBST(root.right, val);
    }

    public static void main(String[] args) {
        SearchBST searchBST = new SearchBST();
        // Constructing the BST
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        TreeNode result = searchBST.searchBST(root, 2);
        System.out.println("Node found: " + (result != null ? result.val : "Not found"));
    }
}
