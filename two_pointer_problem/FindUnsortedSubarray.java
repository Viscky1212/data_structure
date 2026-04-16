package two_pointer_problem;

public class FindUnsortedSubarray {

    public static int findUnsortedSubarray(int[] nums){
        int n = nums.length;
        int left = -1, right = -1;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        //left -> right
        for (int i = 0; i < n; i++) {
            if (nums[i] < max){
                right = i;
            } else {
                max = nums[i];
            }
        }

        //Right -> left
        for (int i = n - 1; i >= 0 ; i--) {
            if (nums[i] > min) {
                left = i;
            } else {
                min = nums[i];
            }
        }

        if (right == -1 ){
            return 0;
        }

        return right - left + 1;
    }

    public static void main(String[] args) {
        int[] nums = {2,6,4,8,10,9,15};

        int result = findUnsortedSubarray(nums);

        System.out.println("Shortest Unsorted Subarray Length: " + result);
    }
}
