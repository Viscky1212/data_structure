package slidingwindow.april03;

public class MaximumLengthSubstring {

    public int maximumLengthSubstring(String s){
        int[] freq = new int[26];
        int left = 0, maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            freq[ch - 'a']++;

            //If frequently exceed 2, shrink window
            while (freq[ch - 'a'] > 2){
                char leftChar = s.charAt(left);
                freq[leftChar - 'a']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }


    public static void main(String[] args) {
        MaximumLengthSubstring sol = new MaximumLengthSubstring();

        String s1 = "bcbbbcba";
        String s2 = "aaaa";

        System.out.println(sol.maximumLengthSubstring(s1)); // 4
        System.out.println(sol.maximumLengthSubstring(s2)); // 2
    }
}
