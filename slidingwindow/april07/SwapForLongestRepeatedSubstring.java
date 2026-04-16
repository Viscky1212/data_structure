package slidingwindow.april07;

public class SwapForLongestRepeatedSubstring {

    public static int maxRepOpt1(String text){
        int n = text.length();

        //Step 1 : Frequency count
        int[] freq = new int[26];
        for (char c : text.toCharArray()) freq[c - 'a']++;

        int maxLen = 0;

        //Step 2 : Try for each character
        for (int ch = 0; ch < 26; ch++) {
            char target = (char) (ch + 'a');

            int left = 0;
            int count = 0;  //count of target in  window
            for (int right = 0; right < n; right++) {
                if (text.charAt(right) == target) count++;

                //window size = right - left + 1
                /// Allow only 1 mismatch
                while ((right - left + 1) - count > 1) {
                    if (text.charAt(left) == target) count--;
                    left++;
                }
                int windowSize = right - left + 1;
                //cannot exceed total frequency
                maxLen = Math.max(maxLen, Math.min(windowSize, freq[ch]));

            }

        }
        return maxLen;
    }

    public static void main(String[] args) {
        String text = "aaabaaa";

        int result = maxRepOpt1(text);

        System.out.println("Max repeated substring length: " + result);
    }
}
