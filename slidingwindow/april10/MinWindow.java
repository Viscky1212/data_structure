package slidingwindow.april10;

public class MinWindow {

    public String minWindow(String s, String t){
        if (s.length() == 0 || t.length() == 0) return "";

        int[] need  = new int[128];
        int[] window = new int[128];

        //Step 1 : Fill need map
        for (char c : t.toCharArray()){
            need[c]++;
        }

        int left  = 0, right = 0;
        int count = 0; // mathced character
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()){
            char c = s.charAt(right);
            window[c]++;

            //if this char is useful
            if (need[c] > 0 && window[c] <= need[c]){
                count++;
            }

            //when all chars matched
            while (count == t.length()){
                //update minimum window
                if (right - left + 1 < minLen){
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                window[leftChar]--;
                if (need[leftChar] > 0 && window[leftChar] < need[leftChar]){
                    count--;
                }
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start,start + minLen);

    }

    public static void main(String[] args) {
        MinWindow sol = new MinWindow();

        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println("Output 1: " + sol.minWindow(s1, t1)); // BANC

        String s2 = "a";
        String t2 = "a";
        System.out.println("Output 2: " + sol.minWindow(s2, t2)); // a

        String s3 = "a";
        String t3 = "aa";
        System.out.println("Output 3: " + sol.minWindow(s3, t3)); // ""
    }
}
