package patternBase.slidingWindow;

public class LongestRepeatingCharacter {

    public static int longestRepeatingCharacter(String s, int k) {
        int left = 0;
        int maxLength = 0;
        int[] charCount = new int[256];
        int maxCount = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            charCount[rightChar]++;
            maxCount = Math.max(maxCount, charCount[rightChar]);

            while (right - left + 1 - maxCount > k) {
                char leftChar = s.charAt(left);
                charCount[leftChar]--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s1 = "ABAB";
        int k1 = 2;
        System.out.println(longestRepeatingCharacter(s1, k1)); // Output: 4

        String s2 = "AABABBA";
        int k2 = 1;
        System.out.println(longestRepeatingCharacter(s2, k2)); // Output: 4
    }
}
