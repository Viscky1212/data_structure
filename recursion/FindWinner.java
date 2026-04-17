package recursion;

public class FindWinner {

//    public int findTheWinner(int n, int k){
//        int winner = 0;
//        for (int i = 2; i <= n; i++) {
//            winner = (winner + k) % i;
//        }
//        return winner + 1;
//    }

    public int findTheWinner(int n, int k){
        return josefhus(n,k) + 1;
    }

    private int josefhus(int n, int k){
        if (n == 1) return 0;
        return (josefhus(n - 1,k) + k) % n;
    }



    public static void main(String[] args) {
        FindWinner sol = new FindWinner();
        System.out.println(sol.findTheWinner(5, 2)); // 3
        System.out.println(sol.findTheWinner(6, 5)); // 1
    }
}
