package stringMatching;

public class MinimumTimeToInitialState {

    public int minimumTimeToInitialState(String word, int k){
        int n = word.length();

        for (int time = 1; time*k < n; time++) {
            int start = time*k;
            if (word.substring(start).equals(word.substring(0,n - start))) return time;
        }
        return (n + k - 1) / k;
    }

    public static void main(String[] args) {
        MinimumTimeToInitialState sol = new MinimumTimeToInitialState();
        System.out.println(sol.minimumTimeToInitialState("abacaba", 3)); // 2
        System.out.println(sol.minimumTimeToInitialState("abacaba", 4)); // 1
        System.out.println(sol.minimumTimeToInitialState("abcbabcd", 2)); // 4
    }
}
