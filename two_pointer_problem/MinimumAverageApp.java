package two_pointer_problem;


import java.util.Arrays;

public class MinimumAverageApp {

    public double minimumAverage(int[] nums){
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        double minAvg = Double.MAX_VALUE;

        while (left < right){
            double avg = (nums[left] + nums[right]) /2.0;
            minAvg = Math.min(minAvg, avg);
            left++;
            right--;
        }
        return minAvg;
    }

    public static void main(String[] args) {
        MinimumAverageApp solution = new MinimumAverageApp();
        int[] nums1 = {7,8,3,4,15,13,4,1};
        int[] nums2 = {1,9,8,3,10,5};
        int[] nums3 = {1,2,3,7,8,9};

        System.out.println(solution.minimumAverage(nums1)); // 5.5
        System.out.println(solution.minimumAverage(nums2)); // 5.5
        System.out.println(solution.minimumAverage(nums3)); // 5.0
    }
}
