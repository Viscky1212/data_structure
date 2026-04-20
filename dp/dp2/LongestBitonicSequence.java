package dp.dp2;

public class LongestBitonicSequence {
    public int longestBitonicSequence(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        int[] lds = new int[n];

        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            lds[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, lis[i] + lds[i] - 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestBitonicSequence sol = new LongestBitonicSequence();
        int[] nums = {1, 11, 2, 10, 4, 5, 2, 1};

        int result = sol.longestBitonicSequence(nums);

        System.out.println("Maximum length of Bitonic Sequence: " + result);
    }
}
