package patternBase.tree;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class TreeTraversal {
    void fun(Node node) {
        if (node == null) {
            return;
        }

        fun(node.left);       // left
        System.out.println(node.data); // root
        fun(node.right);      // right
    }

    public static void main(String[] args) {
        TreeTraversal tree = new TreeTraversal();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println("Inorder traversal of binary tree is:");
        tree.fun(root);
    }

}
