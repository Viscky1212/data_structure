package patternBase.stack;

public class BstFromPreorder {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }


        int index = 0;

        public TreeNode bstFromPreorder(int[] preorder) {
            return build(preorder, Integer.MAX_VALUE);
        }

        private TreeNode build(int[] preorder, int bound) {

            // सारे elements use हो गए
            if (index == preorder.length) {
                return null;
            }

            // Current value इस subtree में नहीं आ सकती
            if (preorder[index] > bound) {
                return null;
            }

            // Root बनाओ
            TreeNode root = new TreeNode(preorder[index++]);

            // Left Subtree
            root.left = build(preorder, root.val);

            // Right Subtree
            root.right = build(preorder, bound);

            return root;
        }

        // Inorder Traversal
        public void printInorder(TreeNode root) {

            if (root == null) {
                return;
            }

            printInorder(root.left);
            System.out.print(root.val + " ");
            printInorder(root.right);
        }

        // Preorder Traversal
        public void printPreorder(TreeNode root) {

            if (root == null) {
                return;
            }

            System.out.print(root.val + " ");
            printPreorder(root.left);
            printPreorder(root.right);
        }

        public static void main(String[] args) {

            BstFromPreorder bst = new BstFromPreorder();

            int[] preorder = {8, 5, 1, 7, 10, 12};

            TreeNode root = bst.bstFromPreorder(preorder);

            System.out.println("Inorder Traversal:");
            bst.printInorder(root);

            System.out.println();

            System.out.println("Preorder Traversal:");
            bst.printPreorder(root);
        }

//    static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode(int val) {
//            this.val = val;
//        }
//    }
//
//    public static TreeNode bstFromPreorder(int[] preorder) {
//        if (preorder == null || preorder.length == 0) {
//            return null;
//        }
//        return buildTree(preorder, 0, preorder.length - 1);
//    }
//
//    private static TreeNode buildTree(int[] preorder, int start, int end) {
//        if (start > end) {
//            return null;
//        }
//        TreeNode root = new TreeNode(preorder[start]);
//        int i;
//        for (i = start + 1; i <= end; i++) {
//            if (preorder[i] > preorder[start]) {
//                break;
//            }
//        }
//        root.left = buildTree(preorder, start + 1, i - 1);
//        root.right = buildTree(preorder, i, end);
//        return root;
//    }
//
//    public static void printInorder(TreeNode root) {
//        if (root != null) {
//            printInorder(root.left);
//            System.out.print(root.val + " ");
//            printInorder(root.right);
//        }
//    }

//    public static void main(String[] args) {
//
//        int[] preorder = {8, 5, 1, 7, 10, 12};
//        TreeNode root = bstFromPreorder(preorder);
//        printInorder(root);
//    }
}
