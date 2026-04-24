package stringMatching;

public class SumScores {

    public long sumScores(String s){
        int n = s.length();
        int[] z = new int[n];
        int left = 0;
        int right = 0;
        long total_score = n;

        for (int i = 1; i < n; i++) {
            if (i <= right){
                z[i] = Math.min(right - i + 1,z[i - left]);
            }

            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])){
                z[i]++;
            }

            if (i + z[i] - 1 > right){
                left = i;
                right = i + z[i] - 1;
            }
            total_score += z[i];
        }
        return total_score;
    }
    public static void main(String[] args) {
        SumScores sol = new SumScores();
        String s1 = "babab";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + sol.sumScores(s1)); // 9

        String s2 = "azbazbzaz";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + sol.sumScores(s2)); // 14
    }
}
