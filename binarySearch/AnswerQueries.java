package binarySearch;

import java.util.Arrays;

public class AnswerQueries {

    public int[] answerQueries(int[] nums, int[] queries){
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int count = 0;

            while (count < nums.length && nums[count] <= queries[i]){
                count++;
            }
            answer[i] = count;
        }
        return answer;
    }

    public static void main(String[] args) {
        AnswerQueries solution = new AnswerQueries();
        int[] nums1 = {4, 5, 2, 1};
        int[] queries1 = {3, 10, 21};
        System.out.println(Arrays.toString(solution.answerQueries(nums1, queries1))); // [2, 3, 4]

        int[] nums2 = {2, 3, 4, 5};
        int[] queries2 = {1};
        System.out.println(Arrays.toString(solution.answerQueries(nums2, queries2))); // [0]
    }
}
