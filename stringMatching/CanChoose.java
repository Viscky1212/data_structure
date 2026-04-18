package stringMatching;

public class CanChoose {

    public boolean canChoose(int[][] groups, int[] nums){
        int groupIndex = 0;
        int numIndex = 0;

        while (groupIndex < groups.length && numIndex < nums.length){
            if (match(groups[groupIndex],nums,numIndex)){
                numIndex += groups[groupIndex].length;
                groupIndex++;
            }  else {
                numIndex++;
            }
        }
        return  groupIndex == groups.length;
    }

    private boolean match(int[] group, int[] nums, int start){
        if (start + group.length > nums.length){
            return false;
        }

        for (int i = 0; i < group.length; i++) {
            if (group[i] != nums[start + i]){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        CanChoose sol = new CanChoose();
        int[][] groups1 = {{1, -1, -1}, {3, -2, 0}};
        int[] nums1 = {1, -1, 0, 1, -1, -1, 3, -2, 0};
        System.out.println(sol.canChoose(groups1, nums1)); // true

        int[][] groups2 = {{10, -2}, {1, 2, 3, 4}};
        int[] nums2 = {1, 2, 3, 4, 10, -2};
        System.out.println(sol.canChoose(groups2, nums2)); // false

        int[][] groups3 = {{1, 2, 3}, {3, 4}};
        int[] nums3 = {7, 7, 1, 2, 3, 4, 7, 7};
        System.out.println(sol.canChoose(groups3, nums3));
    }
}
