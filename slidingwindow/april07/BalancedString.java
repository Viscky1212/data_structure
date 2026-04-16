package slidingwindow.april07;

public class BalancedString {
    public static int balancedString(String s){
        int n = s.length();
        int target = n / 4;

        int freq[] = new int[128];

        //Step 1 : count frequency
        for (char c : s.toCharArray()) freq[c]++;

        //if already balanced
        if (freq['Q'] == target && freq['W'] == target && freq['E'] == target && freq['R'] == target){
            return 0;
        }
        int left = 0;
        int minLen = n;

        //Step 2 : Sliding window
        for (int right = 0; right < n; right++) {
            freq[s.charAt(right)]--;
          // Check if remaining is valid
            while (left < n &&
                    freq['Q'] <= target &&
                    freq['W'] <= target &&
                    freq['E'] <= target &&
                    freq['R'] <= target) {

                minLen = Math.min(minLen, right - left + 1);

                // shrink window
                freq[s.charAt(left)]++;
                left++;
            }
        }
        return minLen;

    }

    public static void main(String[] args) {

        String s = "QQQW";

        int result = balancedString(s);

        System.out.println("Minimum substring length to replace: " + result);
    }
}
