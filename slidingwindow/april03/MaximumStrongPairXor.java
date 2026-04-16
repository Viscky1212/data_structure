package slidingwindow.april03;

public class MaximumStrongPairXor {

    private int maximumStrongPairXor(int[] nums){
        int n = nums.length;
        int maxXor = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int x = nums[i];
                int y = nums[j];

                //checking strong pair condition
                if (Math.abs(x - y) <= Math.min(x,y)){
                    int xor = x ^ y;
                    maxXor = Math.max(maxXor, xor);
                }
            }
        }

        return maxXor;

    }

    public static void main(String[] args) {
        MaximumStrongPairXor sol = new MaximumStrongPairXor();
        int[] nums1 = {1,2,3,4,5};
        int[] nums2 = {10,100};
        int[] nums3 = {5,6,25,30};

        System.out.println(sol.maximumStrongPairXor(nums1)); // 7
        System.out.println(sol.maximumStrongPairXor(nums2)); // 0
        System.out.println(sol.maximumStrongPairXor(nums3)); // 7
    }
}
