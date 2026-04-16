package two_pointer_problem;

import java.util.Arrays;

public class BagOfTokens {

    public int bagOfTokensScore(int[] tokens, int power) {

        Arrays.sort(tokens);

        int left = 0;
        int right = tokens.length - 1;

        int score = 0;
        int maxScore = 0;

        while (left <= right) {

            // Face-up: gain score
            if (power >= tokens[left]) {
                power -= tokens[left];
                score++;
                left++;

                maxScore = Math.max(maxScore, score);
            }
            // Face-down: regain power
            else if (score >= 1) {
                power += tokens[right];
                score--;
                right--;
            }
            // No move possible
            else {
                break;
            }
        }

        return maxScore;
    }







    public static void main(String[] args) {
        BagOfTokens sol = new BagOfTokens();

        int[] tokens1 = {100};
        int power1 = 50;

        int[] tokens2 = {200, 100};
        int power2 = 150;

        int[] tokens3 = {100, 200, 300, 400};
        int power3 = 200;

        System.out.println("Output 1: " + sol.bagOfTokensScore(tokens1, power1)); // 0
        System.out.println("Output 2: " + sol.bagOfTokensScore(tokens2, power2)); // 1
        System.out.println("Output 3: " + sol.bagOfTokensScore(tokens3, power3)); // 2


    }
}
