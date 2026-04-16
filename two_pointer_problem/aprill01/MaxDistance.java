package two_pointer_problem.aprill01;

public class MaxDistance {

    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int maxDist = 0;

        while (i < nums1.length && j < nums2.length) {
            // If valid, calculate distance and try to expand by moving j
            if (nums1[i] <= nums2[j]) {
                // Math.max naturally ignores cases where j < i (resulting in negative distances)
                maxDist = Math.max(maxDist, j - i);
                j++;
            } else {
                // If invalid, we need a smaller number from nums1, so move i
                i++;
            }
        }

        return maxDist;
    }

//    public int maxDistance(int[] nums1, int[] nums2){
//
//        int i = 0;
//        int j = 0;
//        int mazDist = 0;
//
//        while (i < nums1.length && j < nums2.length){
//            //If valid distance and try to expand by moving j
//            if (nums1[i] <= nums2[j]){
//                //max naturally ignore case where i < j
//                mazDist = Math.max(mazDist, j - 1);
//                j++;
//            } else i++;   //if invalid then we need smaller number
//        }
//        return  mazDist;
//
//    }
//



    public static void main(String[] args) {
        MaxDistance sol = new MaxDistance();

        // Example 1
        int[] nums1_1 = {55, 30, 5, 4, 2};
        int[] nums2_1 = {100, 20, 10, 10, 5};
        System.out.println("Example 1 Output: " + sol.maxDistance(nums1_1, nums2_1));
        // Expected: 2 (Pair is (2, 4) -> 4 - 2 = 2)

        // Example 2
        int[] nums1_2 = {2, 2, 2};
        int[] nums2_2 = {10, 10, 1};
        System.out.println("Example 2 Output: " + sol.maxDistance(nums1_2, nums2_2));
        // Expected: 1 (Pair is (0, 1) -> 1 - 0 = 1)

        // Example 3
        int[] nums1_3 = {30, 29, 19, 5};
        int[] nums2_3 = {25, 25, 25, 25, 25};
        System.out.println("Example 3 Output: " + sol.maxDistance(nums1_3, nums2_3));
        // Expected: 2 (Pair is (2, 4) -> 4 - 2 = 2)
    }
}
