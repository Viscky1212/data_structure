package two_pointer_problem.march31;

public class MaxScore {

    public int maxSum(int[] nums1, int[] nums2){
        int MOD = 1_000_000_007;

        int i = 0, j = 0;
        long sum1 = 0, sum2 = 0;
        long result = 0;

        while (i < nums1.length && j < nums2.length){
            if (nums1[i] < nums2[j]){
                sum1 += nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                sum2 += nums2[j++];
            } else {
                //common element
                result += Math.max(sum1,sum2) + nums1[i];
                result %= MOD;

                sum1 = 0;
                sum2 = 0;

                i++;
                j++;
            }
        }

        //Add remaining element
        while (i < nums1.length){
            sum1 += nums1[i++];
        }

        while (j < nums2.length){
            sum2 += nums2[j++];
        }

        result += Math.max(sum1,sum2);
        result %= MOD;

        return (int) result;

    }


    public static void main(String[] args) {
        MaxScore sol = new MaxScore();
        int[] nums1 = {2,4,5,8,10};
        int[] nums2 = {4,6,8,9};

        int[] nums3 = {1,3,5,7,9};
        int[] nums4 = {3,5,100};

        System.out.println("Output 1: " + sol.maxSum(nums1, nums2)); // 30
        System.out.println("Output 2: " + sol.maxSum(nums3, nums4)); // 109
    }
}
