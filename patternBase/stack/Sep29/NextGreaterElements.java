package patternBase.stack.Sep29;

import java.util.*;

public class NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;

        int[] result = new int[n];

        //default answer is -1
        Arrays.fill(result, -1);

        //store indices
        Deque<Integer> stack = new ArrayDeque<>();

        //Traverse array twice for circular behaviour
        for(int i = 0; i < 2 * n; i++){

            int index = i % n;

            //current element is greater than
            //elements waiting in stack
            while(!stack.isEmpty() && nums[index] > nums[stack.peek()]){
                int previousIndex = stack.pop();

                result[previousIndex] = nums[index];
            }

            //Push only during first traversal
            if(i < n){
                stack.push(index);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        NextGreaterElements nge = new NextGreaterElements();
        int[] nums = {1, 2, 1};
        int[] result = nge.nextGreaterElements(nums);
        System.out.println(Arrays.toString(result)); // Output: [2, -1, 2]
    }

}
