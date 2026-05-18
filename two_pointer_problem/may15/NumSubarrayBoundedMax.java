package two_pointer_problem.may15;

public class NumSubarrayBoundedMax {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int count = 0;

        int lastInvalid  = -1;
        int lastValid = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right){
                lastInvalid = i;
            }

            if (nums[i] >= left && nums[i] <= right){
                lastValid = i;
            }

            count += Math.max(0, lastValid - lastInvalid);
        }

     return count;
    }

    public static void main(String[] args) {
        NumSubarrayBoundedMax sol = new NumSubarrayBoundedMax();
        int[] nums1 = {2,1,4,3};
        int left = 2;
        int right = 3;
        System.out.println(sol.numSubarrayBoundedMax(nums1,left,right));
    }
}
