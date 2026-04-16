package slidingwindow.april06;

public class MaxSumTwoNonOverlappingSubarrays {

    // Main function
    public static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen){
        //Case 1 : firstLen before secondLen
        int case1 = helper(nums, firstLen,secondLen);

        //case 2 secondLen before firstLen
        int case2 = helper(nums, secondLen, firstLen);

        return Math.max(case1,case2);
    }

    //Helper function
    private static int helper(int[] nums, int L, int M) {
        int n = nums.length;

        //prefix sum array
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int maxLen = 0;
        int result = 0;

        //Iterates where M subArray starts

        for (int i = L + M; i <= n ; i++) {
            //Best subArray before current M
            int Lsum = prefix[i - M] - prefix[i - M - L];
            maxLen = Math.max(maxLen, Lsum);

            //current M subArrays
            int Msuk = prefix[i] - prefix[i - M];
            result = Math.max(result, maxLen + Msuk);
        }
        return result;
    }


    //brute force (for understanding )
    public static  int bruteForce(int[] nums, int firstLen, int secondLen){
        int n = nums.length;
        int max = 0;

        for (int i = 0; i <= n - firstLen; i++) {
            int sum1 = 0;
            for (int x = i; x < i + firstLen; x++) {
                sum1 += nums[x];
            }
            for (int j = 0; j <= n - secondLen; j++) {
                //check non- overlapping
                if (j + secondLen <= i || j >= i + firstLen) {
                    int sum2 = 0;
                    for (int y = j; y < j + secondLen; y++) {
                        sum2 += nums[y];
                        max = Math.max(max, sum1 + sum2);
                    }
                }
            }
        }

            return max;

    }

    public static void main(String[] args) {
            MaxSumTwoNonOverlappingSubarrays sol = new MaxSumTwoNonOverlappingSubarrays();
            int[] nums1 = {0,6,5,2,2,5,1,9,4};
            int firstLen1 = 1, secondLen1 = 2;

            System.out.println("Optimal Result: " + sol.maxSumTwoNoOverlap(nums1, firstLen1, secondLen1));
            System.out.println("Brute Force Result: " + sol.bruteForce(nums1, firstLen1, secondLen1));

            int[] nums2 = {3,8,1,3,2,1,8,9,0};
            System.out.println("Test Case 2: " + sol.maxSumTwoNoOverlap(nums2, 3, 2));

            int[] nums3 = {2,1,5,6,0,9,5,0,3,8};
            System.out.println("Test Case 3: " + sol.maxSumTwoNoOverlap(nums3, 4, 3));

    }
}
