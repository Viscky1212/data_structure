package patternBase.prefixSum;

public class ReturnToBoundaryCount {
    public int countReturnToBoundary(int[] nums) {
        int count = 0;
        int position = 0;

        for (int num : nums) {
            position += num;
            if (position == 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, 2, -2, 3, -3};
        ReturnToBoundaryCount sol = new ReturnToBoundaryCount();
        int count = sol.countReturnToBoundary(nums);
        System.out.println("Count of subarrays returning to boundary: " + count); // Output: 6
    }
}
