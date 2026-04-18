package stringMatching;


public class MaxRepeatString {

    public int maxRepeating(String s, String w){
        int count = 0;
        String repeated = w;

        while (s.contains(repeated)){
            count++;
            repeated += w;
        }
        return count;
    }

    public static void main(String[] args) {
        MaxRepeatString sol = new MaxRepeatString();
        String sequence1 = "ababc";
        String word1 = "ab";
        int response1 = sol.maxRepeating(sequence1, word1);
        System.out.println("Output: " + response1); // 2

        String sequence2 = "ababc";
        String word2 = "ba";
        int response2 = sol.maxRepeating(sequence2, word2);
        System.out.println("Output: " + response2); // 1

        String sequence3 = "ababc";
        String word3 = "ac";
        int response3 = sol.maxRepeating(sequence3, word3);
        System.out.println("Output: " + response3); // 0
    }
}
