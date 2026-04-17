package recursion;

public class KthGrammar {
    public int kthGrammar(int n, int k){
        //base case
        if (n == 1) return 0;

        int mid = 1 << (n - 2);

        if (k <= mid){
            return kthGrammar(n - 1, k);
        } else {
            return 1 - kthGrammar(n - 1, k - mid);
        }
    }

    public static void main(String[] args) {
        KthGrammar sol = new KthGrammar();
        System.out.println(sol.kthGrammar(1, 1)); // 0
        System.out.println(sol.kthGrammar(2, 1)); // 0
        System.out.println(sol.kthGrammar(2, 2)); // 1
        System.out.println(sol.kthGrammar(3, 3)); // 1
    }
}
