package slidingwindow.april06;

public class New21Game {

    public double new21Game(int n, int k, int maxPts){
        //edge case
        if (k == 0 || n >= k + maxPts) return 1.0;

        double[] dp = new double[n + 1];
        dp[0] = 1.0;

        double windowSum = 1.0; //sum of last maxPts  dp values
        double result = 0.0;

        for (int i = 1; i <= n ; i++) {
            dp[i] = windowSum / maxPts;
            //if still drawing
            if (i < k){
                windowSum += dp[i];
            } else {
                result += dp[i];  //final ans
            }

            //remove element out of window
            if(i - maxPts >= 0){
                windowSum -= dp[i - maxPts];
            }
        }
        return  result;
    }

    public static void main(String[] args) {

        New21Game sol = new New21Game();
        int n = 21;
        int k = 17;
        int maxPts = 10;

        double probability = sol.new21Game(n, k, maxPts);

        System.out.println("Probability: " + probability);
    }
}
