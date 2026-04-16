package slidingwindow.april06;

public class CharacterReplacement {

    public int characterReplacement(String s, int k){
        int[] freq = new int[26];
        int left = 0, maxFreq = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            freq[ch - 'A']++;

            maxFreq = Math.max(maxFreq,freq[ch - 'A']);

            //if invalid window -> shrink
            while ((right - left + 1) - maxFreq > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;

    }

    public static void main(String[] args) {
        CharacterReplacement sol = new CharacterReplacement();
        String s1 = "ABAB";
        int k1 = 2;

        String s2 = "AABABBA";
        int k2 = 1;

        System.out.println("Output 1: " + sol.characterReplacement(s1, k1)); // 4
        System.out.println("Output 2: " + sol.characterReplacement(s2, k2)); // 4
    }
}
