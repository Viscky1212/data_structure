package stringMatching;

public class CountMatchingSubarrays {

    public int countMatchingSubarrays(int[] nums, int[] pattern){
        int n = nums.length;
        int m = pattern.length;
        int count = 0;

        for (int i = 0; i <= n - m - 1 ; i++) {
            boolean match = true;
            for (int j = 0; j < m; j++) {
                int compare = 0;

                if (nums[i + j + 1] > nums[i + j]){
                    compare = 1;
                } else if (nums[i + j + 1] < nums[i + j]) {
                    compare = -1;
                }

                if (compare != pattern[j]){
                    match = false;
                    break;
                }
            }
            if (match){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountMatchingSubarrays sol = new CountMatchingSubarrays();
        int[] nums1 = {1, 2, 3, 4, 5, 6};
        int[] pattern1 = {1, 1};
        System.out.println(sol.countMatchingSubarrays(nums1, pattern1)); // 4

        int[] nums2 = {1, 4, 4, 1, 3, 5, 5, 3};
        int[] pattern2 = {1, 0, -1};
        System.out.println(sol.countMatchingSubarrays(nums2, pattern2)); // 2
    }
}
