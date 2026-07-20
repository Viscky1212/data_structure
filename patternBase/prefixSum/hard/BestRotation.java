package patternBase.prefixSum.hard;

public class BestRotation {

    public static int bestRotation(int[] nums) {
        int n = nums.length;
        int[] change = new int[n + 1];

        for (int i = 0; i < n; i++) {
            int low = (i - nums[i] + 1 + n) % n;
            int high = (i + 1) % n;

            change[low]++;
            change[high]--;
            if (low > high) {
                change[0]++;
            }
        }

        int maxScore = 0, bestK = 0, score = 0;
        for (int k = 0; k < n; k++) {
            score += change[k];
            if (score > maxScore) {
                maxScore = score;
                bestK = k;
            }
        }

        return bestK;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 4, 0};
        int bestRotation = bestRotation(nums);
        System.out.println("Best rotation index: " + bestRotation);
    }
}
