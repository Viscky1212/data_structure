package patternBase.prefixSum;

public class CountValidSelections {
    public int countValidSelections(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (isValidSelection(nums, i, 1)) {
                    count++;
                }

                if (isValidSelection(nums, i, -1)) {
                    count++;
                }
            }

        }

        return count;
    }

    public boolean isValidSelection(int[] nums, int  curr, int dir) {
        int[] arr = nums.clone();
        int n = arr.length;

        while (curr >= 0 && curr < n) {
            if (arr[curr] == 0) {
                curr += dir;
            } else{
                arr[curr]--;
                dir = -dir;
                curr += dir;
                }
        }

        for (int num : arr) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CountValidSelections sol = new CountValidSelections();
        int[] nums = {1,0,2,0,3};
        int target = 5;
        System.out.println(sol.countValidSelections(nums, target)); // Output: 2
    }
}
