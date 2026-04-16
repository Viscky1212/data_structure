package slidingwindow.april03.april04;

public class MaxLength {

    public int maxLength(int[] nums) {

        int n = nums.length;
        int maxLen = 1;

        for (int i = 0; i < n; i++) {

            long prod = 1;
            int gcd = 0;
            long lcm = 1;

            for (int j = i; j < n; j++) {

                int val = nums[j];

                // Update product
                prod *= val;

                // Update gcd
                gcd = (gcd == 0) ? val : getGCD(gcd, val);

                // Update lcm
                lcm = (lcm * val) / getGCD((int) lcm, val);

                // Check condition
                if (prod == gcd * lcm) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }

                // Optimization: prevent overflow
                if (prod > 1e9) break;
            }
        }

        return maxLen;
    }

    private int getGCD(int a, int b) {
        return b == 0 ? a : getGCD(b, a % b);
    }



    public static void main(String[] args) {
        MaxLength sol = new MaxLength();
        int[] nums1 = {1,2,1,2,1,1,1};
        int[] nums2 = {2,3,4,5,6};
        int[] nums3 = {1,2,3,1,4,5,1};

        System.out.println(sol.maxLength(nums1)); // 5
        System.out.println(sol.maxLength(nums2)); // 3
        System.out.println(sol.maxLength(nums3)); // 5
    }
}
