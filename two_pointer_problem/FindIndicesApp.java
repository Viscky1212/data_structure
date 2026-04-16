package two_pointer_problem;

public class FindIndicesApp {

    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(i - j) >= indexDifference &&
                        Math.abs(nums[i] - nums[j]) >= valueDifference){
                 return new int[]{i, j};
                }
            }
        }
        return new int[] {-1,-1};

    }


        public static void main(String[] args) {
        FindIndicesApp solution = new FindIndicesApp();
        int[] nums1 = {5,1,4,1};
        int[] result1 = solution.findIndices(nums1, 2, 4);
        print(result1);

        int[] nums2 = {2,1};
        int[] result2 = solution.findIndices(nums2, 0, 0);
        print(result2);

        int[] nums3 = {1,2,3};
        int[] result3 = solution.findIndices(nums3, 2, 4);
        print(result3);
    }

    private static void print(int[] arr) {
        System.out.println("[" + arr[0] + ", " + arr[1] + "]");

    }
}
