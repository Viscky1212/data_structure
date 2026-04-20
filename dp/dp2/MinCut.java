package dp.dp2;

public class MinCut {

    public int minCut(String str){
        int n = str.length();
        int dp[] = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = i;
        }

        for (int center = 0; center < n; center++) {
            expandAndUpdate(str,center,center,dp);
            expandAndUpdate(str,center,center + 1,dp);
        }
        return dp[n - 1];
    }

    private void expandAndUpdate(String s, int left, int right,int[] dp){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            if (left == 0){
                dp[right] = 0;
            } else {
                dp[right] = Math.min(dp[right],dp[left - 1] + 1);
            }
            left--;
            right++;
        }
    }

    public static void main(String[] args) {
        String s = "aab"; // hardcoded input

        MinCut sol = new MinCut();
        int result = sol.minCut(s);

        System.out.println("Input: " + s);
        System.out.println("Minimum cuts needed: " + result);
    }
}
