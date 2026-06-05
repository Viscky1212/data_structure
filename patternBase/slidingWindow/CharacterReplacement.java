package patternBase.slidingWindow;

public class CharacterReplacement {

    public int characterReplacement(String s, int k) {
        int[] charCount = new int[26];
        int maxCount = 0;
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            charCount[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, charCount[s.charAt(right) - 'A']);

//            maxCount = Math.max(
//                    maxCount,
//                    ++charCount[s.charAt(right) - 'A']
//            );

            while (right - left + 1 - maxCount > k) {
                charCount[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }


    public static void main(String[] args) {
        CharacterReplacement sol = new CharacterReplacement();
        String s1 = "ABAB";
        int k1 = 2;
        System.out.println(sol.characterReplacement(s1, k1));
        // Output: 4

        String s2 = "AABABBA";
        int k2 = 1;
        System.out.println(sol.characterReplacement(s2, k2));
        // Output: 4
    }
}
