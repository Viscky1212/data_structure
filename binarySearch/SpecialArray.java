package binarySearch;

public class SpecialArray {

    public int specialArray(int[] nums){
        int n = nums.length;

        for (int i = 0; i <= n; i++) {
            int count = 0;
            for (int num : nums){
               if (num >= i){
                   count++;
               }
            }
            if (count == i) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        SpecialArray solution = new SpecialArray();
        int[] nums1 = {3, 5};
        System.out.println(solution.specialArray(nums1)); // 2

        int[] nums2 = {0, 0};
        System.out.println(solution.specialArray(nums2)); // -1

        int[] nums3 = {0, 4, 3, 0, 4};
        System.out.println(solution.specialArray(nums3)); // 3
    }
}
