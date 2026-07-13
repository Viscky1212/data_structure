package patternBase.prefixSum;

public class CountPartitions {

    public int countPartitions(int[] nums){
        int totalSum = 0;

        for (int num : nums){
            totalSum += num;
        }
        if (totalSum % 2 != 0){
            return 0;
        }
        return nums.length - 1;
    }

    public static void main(String[] args) {
        CountPartitions cp = new CountPartitions();
        int[] nums = {10, 10, 3, 7, 6};
        int result = cp.countPartitions(nums);
        System.out.println("Count of partitions: " + result); // Output: 4
    }
}
