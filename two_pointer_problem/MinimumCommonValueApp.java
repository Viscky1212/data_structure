package two_pointer_problem;

public class MinimumCommonValueApp {

    public int getCommon(int[] nums1, int[] nums2){
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length){
            if (nums1[i] == nums2[j]){
                return nums1[i]; // smallest common found
            } else if (nums1[i] < nums2[j]) {
                i++;  //move smaller pointer
            }
            else {
                j++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumCommonValueApp solution = new MinimumCommonValueApp();
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4};

        System.out.println(solution.getCommon(nums1, nums2)); // 2
    }
}
