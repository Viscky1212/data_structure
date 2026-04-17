package recursion;

public class FindKthBit {

    public char findKthBit(int n, int k) {

        if (n == 1) return '0';
        int len = (1 << n) - 1;
        int mid = (len / 2) + 1;

        //for middle element
        if (k == mid) return '1';

        //left part
        if (k < mid) return findKthBit(n - 1, k);

        //right part
        int mirrorIndex = len - k + 1;
        char ch = findKthBit(n - 1, mirrorIndex);

        //invert
        return (ch == '0') ? '1' : '0';

    }

    public static void main(String[] args) {
        FindKthBit sol = new FindKthBit();
        System.out.println(sol.findKthBit(3, 1));  // 0
        System.out.println(sol.findKthBit(4, 11)); // 1
        System.out.println(sol.findKthBit(4, 8));  // 1

    }
}
