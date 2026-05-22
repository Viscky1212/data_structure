package sorting.may21;

public class MaximizeExpressionOfThree {

    public int maximizeExpressionOfThree(int[] nums){
        int minValue = Integer.MAX_VALUE;

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : nums){
            minValue = Math.min(minValue, num);

            if (num > largest){
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest) {
                secondLargest = num;
            }
        }
        return largest + secondLargest - minValue;
    }

    public static void main(String[] args) {
        MaximizeExpressionOfThree sol = new MaximizeExpressionOfThree();
        int[] nums1 = {1, 4, 2, 5};
        System.out.println(sol.maximizeExpressionOfThree(nums1));
        // Output: 8

        int[] nums2 = {-2, 0, 5, -2, 4};
        System.out.println(sol.maximizeExpressionOfThree(nums2));
        // Output: 11

        int[] nums3 = {-5, -2, -1};
        System.out.println(sol.maximizeExpressionOfThree(nums3));
        // Output: 2

        int[] nums4 = {5, 5, 1};
        System.out.println(sol.maximizeExpressionOfThree(nums4));
        // Output: 9
    }
}
