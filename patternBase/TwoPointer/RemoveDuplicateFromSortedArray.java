package patternBase.TwoPointer;

public class RemoveDuplicateFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        int k = removeDuplicates(nums);

        System.out.println("Unique Count = " + k);

        System.out.print("Unique Elements = ");

        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private static int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int slow = 0;

        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        return slow + 1; // Return the count of unique elements
    }
}
