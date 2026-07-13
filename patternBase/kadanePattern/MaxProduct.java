package patternBase.kadanePattern;

public class MaxProduct {

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                // Swap max and min when encountering a negative number
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);

            result = Math.max(result, maxProduct);
        }

        return result;
    }


    public int maxProduct2(int[] nums) {
        // maxSoFar = maximum product subarray ending at current index
        int maxSoFar = nums[0];

        // minSoFar = minimum product subarray ending at current index
        // needed because negative * negative can become maximum
        int minSoFar = nums[0];

        // final answer
        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            // if current number is negative,
            // max and min roles get reversed
            if (current < 0) {
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            // choose either:
            // 1. start new subarray from current
            // 2. extend previous product
            maxSoFar = Math.max(current, maxSoFar * current);
            minSoFar = Math.min(current, minSoFar * current);

            // update answer
            answer = Math.max(answer, maxSoFar);
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        int result = maxProduct(nums);
        System.out.println("Maximum product subarray: " + result); // Output: 6
    }
}
