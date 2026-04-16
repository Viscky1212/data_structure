package two_pointer_problem.aprill01;

public class WaysToSplit {

    public int waysToSplit(int[] nums){
        int n = nums.length;
        int MOD = 1_000_000_007;

        //1 . Calculate prefix in sum
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }

        int ans = 0;
        int j = 1;  //left bound for mid array
        int k = 1; //right bound for mid array

        //2 . Iterate through the possible end indices of the 'left' array
        for (int i = 0; i < n - 2; i++) {
            if (3 * nums[i] > nums[n - 1]) break;

            j = Math.max(j, i + 1);
            while (j <= n - 2 && nums[j] < 2 * nums[i]) j++;

            k = Math.max(k , j);
            while (k <= n - 2 && 2 * nums[k] <= nums[n - 1] +  nums[i]) k++;

            if (k > j) ans = (ans + (k - j)) % MOD;
        }
        return ans;
    }

    public static void main(String[] args) {
        WaysToSplit sol = new WaysToSplit();
        // Example 1
        int[] nums1 = {1, 1, 1};
        System.out.println("Example 1 Output: " + sol.waysToSplit(nums1));
        // Expected: 1

        // Example 2
        int[] nums2 = {1, 2, 2, 2, 5, 0};
        System.out.println("Example 2 Output: " + sol.waysToSplit(nums2));
        // Expected: 3

        // Example 3
        int[] nums3 = {3, 2, 1};
        System.out.println("Example 3 Output: " + sol.waysToSplit(nums3));
        // Expected: 0
    }
}
