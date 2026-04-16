package two_pointer_problem;

public class IncremovableSubarrayApp {
    public int incremovableSubarrayCount(int[] nums){
        int n = nums.length;
        int count = 0;

        //try all subarrays
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isValid(nums, i , j )){
                    count++;
                }
            }
        }
        return count;
    }

    //check if array strictly increasing after removing{i, j}
    public boolean isValid(int[] nums, int start, int end){
        int prev = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i >= start && i <= end)continue;
            if (prev != -1 && nums[i] <= prev){
                return false;
            }
            prev = nums[i];
        }
        return true;

    }

    public static void main(String[] args) {
        IncremovableSubarrayApp solution = new IncremovableSubarrayApp();
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {6,5,7,8};
        int[] nums3 = {8,7,6,6};

        System.out.println(solution.incremovableSubarrayCount(nums1)); // 10
        System.out.println(solution.incremovableSubarrayCount(nums2)); // 7
        System.out.println(solution.incremovableSubarrayCount(nums3)); // 3
    }

}
