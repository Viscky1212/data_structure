package two_pointer_problem;
import java.util.*;

public class CountPairsApp {

    public int countPairs(List<Integer> nums, int target){
        Collections.sort(nums);

        int left = 0;
        int right = nums.size() - 1;
        int count = 0;

        while (left < right){
            int sum = nums.get(left) + nums.get(right);

            if (sum < target){
                //All pairs from left to right -1 are valid
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        CountPairsApp solution = new CountPairsApp();
        List<Integer> nums1 = Arrays.asList(-1,1,2,3,1);
        int target1 = 2;

        List<Integer> nums2 = Arrays.asList(-6,2,5,-2,-7,-1,3);
        int target2 = -2;

        System.out.println(solution.countPairs(nums1, target1)); // 3
        System.out.println(solution.countPairs(nums2, target2)); // 10

    }
}
