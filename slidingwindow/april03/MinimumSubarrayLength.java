package slidingwindow.april03;

public class MinimumSubarrayLength {

    public int minimumSubarrayLength(int[] nums, int k){

        int n = nums.length;
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int currentOr = 0;

            for (int j = i; j < n; j++) {
                currentOr |= nums[j];
                    //check condition
                if (currentOr >= k){
                    minLen = Math.min(minLen, j - i + 1);
                    break;  //No need to expand further
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
    public static void main(String[] args) {
        MinimumSubarrayLength sol = new MinimumSubarrayLength();
        int[] nums1 = {1,2,3};
        int k1 = 2;

        int[] nums2 = {2,1,8};
        int k2 = 10;

        int[] nums3 = {1,2};
        int k3 = 0;

        System.out.println(sol.minimumSubarrayLength(nums1, k1)); // 1
        System.out.println(sol.minimumSubarrayLength(nums2, k2)); // 3
        System.out.println(sol.minimumSubarrayLength(nums3, k3)); // 1
    }
}
