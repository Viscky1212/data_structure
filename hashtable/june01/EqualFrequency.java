package hashtable.june01;

public class EqualFrequency {

    private boolean canEqualFreq(String word) {
      int[] freq = new int[26];

      // Count the frequency of each character in the word
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        // Try removing one character and check if the remaining frequencies are all the same
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) {
                continue; // Skip characters that are not present
            }

            //Remove one occurrence of the character
            freq[i]--;

            if (allExopectyedFreq(freq)) {
                return true; // Found a valid configuration
            }
            freq[i]++; // Restore the frequency for the next iteration
        }
        return false; // Restore the frequency and continue checking

    }

    private boolean allExopectyedFreq(int[] freq) {
        int expectedFreq = 0;

        for (int f : freq) {

            if (f != 0) {
                if (expectedFreq == 0) {
                    expectedFreq = f;
                } else if (f != expectedFreq) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        EqualFrequency sol = new EqualFrequency();
//        int[] freq1 = {2, 2, 2};
//        System.out.println(sol.allExopectyedFreq(freq1));
//        // Output: true
//
//        int[] freq2 = {1, 1, 1, 0};
//        System.out.println(sol.allExopectyedFreq(freq2));
//        // Output: true
//
//        int[] freq3 = {3, 3, 3, 3};
//        System.out.println(sol.allExopectyedFreq(freq3));
//        // Output: true
//
//        int[] freq4 = {2, 2, 1};
//        System.out.println(sol.allExopectyedFreq(freq4));
//        // Output: false

        String word1 = "abcc";
        System.out.println(sol.canEqualFreq(word1));
        // Output: true

        String word2 = "aabbccd";
        System.out.println(sol.canEqualFreq(word2));
        // Output: true

        String word3 = "abc";
        System.out.println(sol.canEqualFreq(word3));
        // Output: false

        String word4 = "aabbccdd";
        System.out.println(sol.canEqualFreq(word4));
        // Output: false
    }
}
