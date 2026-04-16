package slidingwindow.april09;

public class MinSizeSubarrayInfinite {

    public int minSizeSubarray(int[] nums , int target){
        int n = nums.length;

        //Step 1 : total sum
        long totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }

        //Step 2: full cycle
        int cycle = (int)(target/totalSum);
        int reminder = (int)(target % totalSum);

        //if exact multiple
        if (reminder == 0){
            return cycle * n;
        }

        //Step 3 : sliding window on 2*n array
        int minLen = Integer.MAX_VALUE;

        int left = 0;
        long currentSum = 0;

        //Simulate 2*n array
        for (int right = 0; right < 2*n; right++) {
            currentSum += nums[right % n];

            //shrink window
            while (currentSum > reminder){
                currentSum -= nums[left % n];
                left++;
            }

            //check match
            if (currentSum == reminder){
                minLen = Math.min(minLen, right -left + 1);
            }
        }
        if (minLen == Integer.MAX_VALUE){
            return -1;
        }
        return cycle * n + minLen;
    }

    public static void main(String[] args) {
        MinSizeSubarrayInfinite sol = new MinSizeSubarrayInfinite();

        int[] nums1 = {1,2,3};
        System.out.println(sol.minSizeSubarray(nums1, 5)); // 2

        int[] nums2 = {1,1,1,2,3};
        System.out.println(sol.minSizeSubarray(nums2, 4)); // 2

        int[] nums3 = {2,4,6,8};
        System.out.println(sol.minSizeSubarray(nums3, 3)); // -1
    }
}
