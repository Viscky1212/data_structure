package slidingwindow.april06;

public class LongestSubstring {

    public int longestSubstring(String s , int k){
        return helperSubString(s,0,s.length(),k);
    }

    public int helperSubString(String s, int start, int end , int k){
        if (end - start < k) return 0;
        int[] freq = new int[26];

        for (int i = start; i < end; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int mid = start; mid < end; mid++) {
            if (freq[s.charAt(mid) - 'a'] < k){
                int midNext = mid + 1;

                while (midNext < end && freq[s.charAt(midNext) - 'a']< k){
                    midNext++;
                }

                return Math.max(
                        helperSubString(s,start,mid , k),
                        helperSubString(s,midNext,end,k)
                );
            }
        }

        return end - start;

    }

    public static void main(String[] args) {
        LongestSubstring sol = new LongestSubstring();
        String s1 = "aaabb";
        int k1 = 3;

        String s2 = "ababbc";
        int k2 = 2;

        System.out.println("Output 1: " + sol.longestSubstring(s1, k1)); // 3
        System.out.println("Output 2: " + sol.longestSubstring(s2, k2)); // 5
    }
}
