package patternBase.prefixSum;

public class SubarraySum2 {

    public int subarraySum(int[] nums){
        int n = nums.length;

        int[] prefix= new int[n + 1];
        prefix[0] = nums[0];

        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int total = 0;
        for(int i = 0; i < n; i++){
            int start = Math.max(0, i - nums[i]);
            int sum = prefix[i] - (start > 0 ? prefix[start - 1] : 0);

            total += sum;
        }
        return total;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        SubarraySum2 solution = new SubarraySum2();
        int count = solution.subarraySum(nums);

        System.out.println("Total sum of all subarrays: " + count); // Output: 35
    }
}
