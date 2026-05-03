package hashtable.may01;

public class NumEquivDominoPairs {

    public int numEquivDominoPairs(int[][] dominoes){
        int[] freq = new int[100];

        int pairs = 0;
        for (int[] d : dominoes){
            int a = Math.min(d[0],d[1]);
            int b = Math.max(d[0],d[1]);

            int key = a * 10 + b;

            pairs += freq[key];

            freq[key]++;
        }
        return pairs;
    }

    public static void main(String[] args) {
        NumEquivDominoPairs sol = new NumEquivDominoPairs();

        int[][] d1 = {{1,2},{2,1},{3,4},{5,6}};
        System.out.println(sol.numEquivDominoPairs(d1)); // 1

        int[][] d2 = {{1,2},{1,2},{1,1},{1,2},{2,2}};
        System.out.println(sol.numEquivDominoPairs(d2)); // 3
    }
}
