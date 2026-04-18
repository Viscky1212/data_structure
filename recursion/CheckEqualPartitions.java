package recursion;

public class CheckEqualPartitions {

    public boolean checkEqualPartitions(int[] nums, long target){
        int n = nums.length;
        int totakMask = 1 << n;

        for (int mask = 1; mask < totakMask - 1; mask++) {
            long product1 = 1;
            boolean valid1 = true;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0){
                    if (nums[i] > target || product1 > target / nums[i]){
                        valid1 = false;
                        break;
                    }
                    product1 *= nums[i];
                }
            }
            if (!valid1 || product1 != target){
                continue;
            }

            long product2 = 1;
            boolean valid2 = true;

            for (int i = 0; i < n; i++) {
                if ((mask &(1 << i)) == 0){
                    if (nums[i] > target || product2 > target /nums[i]){
                        valid2 = false;
                        break;
                    }
                    product2 *= nums[i];
                }
            }
            if (valid2 && product2 == target){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
       CheckEqualPartitions sol = new CheckEqualPartitions();
        int[] nums1 = {3, 1, 6, 8, 4};
        long target1 = 24;
        System.out.println(sol.checkEqualPartitions(nums1, target1)); // true

        int[] nums2 = {2, 5, 3, 7};
        long target2 = 15;
        System.out.println(sol.checkEqualPartitions(nums2, target2)); // false
    }
}
