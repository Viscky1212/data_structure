package hashtable.may03;

public class FindJudge {

    public int findJudge(int n, int[][] trust){
        int[] score = new int[n + 1];

        //step 1 : process trust relationships

        for (int[] t : trust){
            int a = t[0];
            int b = t[1];

            score[a]--;
            score[b]++;
        }

        //step 2 : find judge
        for (int i = 1; i <= n; i++) {
            if (score[i] == n - 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        FindJudge sol = new FindJudge();

        int[][] trust1 = {{1,2}};
        System.out.println(sol.findJudge(2, trust1)); // 2

        int[][] trust2 = {{1,3},{2,3}};
        System.out.println(sol.findJudge(3, trust2)); // 3

        int[][] trust3 = {{1,3},{2,3},{3,1}};
        System.out.println(sol.findJudge(3, trust3)); // -1
    }
}
