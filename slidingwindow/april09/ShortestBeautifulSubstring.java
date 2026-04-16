package slidingwindow.april09;

public class ShortestBeautifulSubstring {

    public String shortestBeautifulSubstring(String s , int k){
        int left = 0;
        int ones = 0;

        int minLen = Integer.MAX_VALUE;
        String result = "";

        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '1'){
                ones++;
            }

            //shrink if more than k ones
            while (ones > k){
                if (s.charAt(left) == '1'){
                    ones--;
                }
                left++;
            }
            //when exactly k ones
            if (ones == k){
                //Try to shrink for minimum length
                while (left <= right && s.charAt(left) == '0'){
                    left++;
                }

                int len = right - left + 1;
                String condidate = s.substring(left, right + 1);
                if (len < minLen){
                    minLen = len;
                    result = condidate;
                } else if (len == minLen) {
                    if (result.equals("") || condidate.compareTo(result) < 0){
                        result = condidate;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        ShortestBeautifulSubstring sol = new ShortestBeautifulSubstring();

        System.out.println(sol.shortestBeautifulSubstring("100011001", 3)); // "11001"
        System.out.println(sol.shortestBeautifulSubstring("1011", 2)); // "11"
        System.out.println(sol.shortestBeautifulSubstring("000", 1)); // ""
    }
}
