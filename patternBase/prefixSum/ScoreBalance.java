package patternBase.prefixSum;

public class ScoreBalance {

    public boolean scoreBalance(String s){
        int totalScore = 0;

        for (int i = 0; i < s.length(); i++) {
            totalScore += s.charAt(i) - 'a' + 1; // Convert character to score (a=1, b=2, ..., z=26)
        }

        int leftScore = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            leftScore += s.charAt(i) - 'a' + 1; // Convert character to score (a=1, b=2, ..., z=26)
            if (leftScore == totalScore - leftScore) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ScoreBalance sol = new ScoreBalance();
        System.out.println(sol.scoreBalance("abccba")); // Output: true
        System.out.println(sol.scoreBalance("abcde"));  // Output: false
        System.out.println(sol.scoreBalance("aabb"));   // Output: true
        System.out.println(sol.scoreBalance("abc"));    // Output: false
    }
}
