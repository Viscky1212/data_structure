package sorting.may20;

public class ArrayIsGood {

    public boolean isGood(int[] nums){
        int max = 0;
        for (int num : nums){
            max = Math.max(max,num);
        }

        if (nums.length != max + 1){
            return false;
        }

        int[] freq = new int[max + 1];

        for (int num : nums){
            if (num < 1 || num > max){
                return false;
            }
            freq[num]++;
        }

        for (int i = 1; i < max; i++) {
            if (freq[i] != 1){
                return false;
            }
        }

        return freq[max] == 2;
    }


    public static void main(String[] args) {
        ArrayIsGood sol = new ArrayIsGood();
        int[] nums1 = {2, 1, 3};
        System.out.println(sol.isGood(nums1));
        // Output: false

        int[] nums2 = {1, 3, 3, 2};
        System.out.println(sol.isGood(nums2));
        // Output: true

        int[] nums3 = {1, 1};
        System.out.println(sol.isGood(nums3));
        // Output: true

        int[] nums4 = {3, 4, 4, 1, 2, 1};
        System.out.println(sol.isGood(nums4));
        // Output: false
    }
}
