package patternBase.slidingWindow;

public class LongestSubStrungWithoutRepeatingChar {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;

        int[] charCount = new int[256];

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            charCount[rightChar]++;

            while (charCount[rightChar] > 1) {
                char leftChar = s.charAt(left);
                charCount[leftChar]--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s1)); // Output: 3

        String s2 = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s2)); // Output: 1

        String s3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s3)); // Output: 3
    }
}
