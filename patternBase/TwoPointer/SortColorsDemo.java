package patternBase.TwoPointer;

public class SortColorsDemo {

    private static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else { // nums[mid] == 2
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};

        System.out.println("Original Array = ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        sortColors(nums);

        System.out.print("Sorted Array = ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
