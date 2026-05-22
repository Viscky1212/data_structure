package sorting.may20;

public class FindNonMinOrMax {

    public int findNonMinOrMax(int[] nums){

        if (nums.length < 3){
            return -1;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums){
            min = Math.min(min,num);
            max = Math.max(max,num);
        }

        for (int num : nums){
            if (num != min && num != max){
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindNonMinOrMax sol = new FindNonMinOrMax();
        int[] nums1 = {3, 2, 1, 4};
        System.out.println(sol.findNonMinOrMax(nums1));
        // Output: 3 or 2

        int[] nums2 = {1, 2};
        System.out.println(sol.findNonMinOrMax(nums2));
        // Output: -1

        int[] nums3 = {2, 1, 3};
        System.out.println(sol.findNonMinOrMax(nums3));
        // Output: 2
    }
}
