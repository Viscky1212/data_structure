package patternBase.stack;

import java.util.Stack;

public class MostCompetitive {

//    public static int[] mostCompetitive(int[] nums, int k) {
//        int n = nums.length;
//        int[] result = new int[k];
//        int index = 0;
//
//        for (int i = 0; i < n; i++) {
//            while (index > 0 && nums[i] < result[index - 1] && n - i > k - index) {
//                index--;
//            }
//            if (index < k) {
//                result[index++] = nums[i];
//            }
//        }
//
//        return result;
//    }

    public static int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty()
                    && stack.peek() > nums[i]
                    && stack.size() - 1 + (n - i) >= k){
                stack.pop();
            }

            if(stack.size() < k){
                stack.push(nums[i]);
            }
        }
        int[] ans = new int[k];

        for(int i = k - 1; i >= 0;  i--){
            ans[i] = stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {3, 5, 2, 6};
        int k = 2;
        int[] result = mostCompetitive(nums, k);

        // Print the result
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
