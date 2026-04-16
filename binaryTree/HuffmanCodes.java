package binaryTree;


import java.util.ArrayList;
import java.util.PriorityQueue;

class Node {
    int freq;
    char ch;
    Node left, right;

    Node(int f, char c) {
        freq = f;
        ch = c;
    }

    Node(int f, Node l, Node r) {
        freq = f;
        left = l;
        right = r;
    }
}
public class HuffmanCodes {
    public ArrayList<String> huffmanCodes(String S, int f[], int N) {
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a,b) -> a.freq - b.freq
        );

        for (int i = 0; i < N; i++) {
            pq.offer(new Node(f[i], S.charAt(i)));
        }

        while (pq.size() > 1){
            Node left = pq.poll();
            Node right = pq.poll();

            Node parent = new Node(left.freq + right.freq,left,right);
            pq.offer(parent);
        }

        Node root = pq.poll();
        ArrayList<String> result = new ArrayList<>();
        generateCodes(root, "", result);

        return result;

    }

    private void generateCodes(Node node, String code, ArrayList<String> res) {

        if (node == null) return;
        if (node.left == null && node.right == null){
            res.add(code);
            return;
        }
        generateCodes(node.left,code +"0" , res);
        generateCodes(node.right,code +"1" , res);
    }

        public static void main(String[] args) {
        HuffmanCodes sol = new HuffmanCodes();
            String S = "abcdef";
            int f[] = {5,9,12,13,16,45};

            ArrayList<String> codes = sol.huffmanCodes(S, f, 6);

            System.out.println(codes);
    }

}
