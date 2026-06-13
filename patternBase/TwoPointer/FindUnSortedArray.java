package patternBase.TwoPointer;

public class FindUnSortedArray {
    public static int findUnSortedArray(int[] nums){
        int n = nums.length;
        int left = 0;
        int right = -1;

        int maxSeen = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            maxSeen = Math.max(maxSeen,nums[i]);
            if(nums[i] < maxSeen){
                right = i;
            }
        }

        int minSeen = Integer.MAX_VALUE;

        for(int i = n - 1; i >= 0; i--){
            minSeen = Math.min(minSeen, nums[i]);

            if(nums[i] > minSeen){
                left = i;
            }
        }

        if(right == -1){
            return 0;
        }
        return right - left + 1;
    }


    public static void main(String[] args) {
        int[] nums = {2,6,4,8,10,9,15};

        System.out.println(findUnSortedArray(nums));
    }
}
