package patternBase.prefixSum.medium;

public class FindPrefixScore {

    public long[] findPrefixScore(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];

        long score = 0;
        int maxSoFar = 0;

        for(int i = 0; i < n; i++){
            maxSoFar = Math.max(maxSoFar, nums[i]);
            score += (long) nums[i] + maxSoFar;
            ans[i] = score;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 5, 10};
        FindPrefixScore finder = new FindPrefixScore();
        long[] prefixScores = finder.findPrefixScore(nums);
        for (long score : prefixScores) {
            System.out.print(score + " ");
        }
    }
}
