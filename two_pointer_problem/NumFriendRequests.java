package two_pointer_problem;

import java.util.Arrays;

public class NumFriendRequests {

    public int numFriendRequests(int[] ages){
        Arrays.sort(ages);

        int left = 0;
        int right = 0;
        int count = 0;

        for (int age : ages){
            if (age < 15) continue;

            while (ages[left] <= 0.5 * age + 7){
                left++;
            }

            while (right < ages.length && ages[right] <= age){
                right++;
            }
            count += right - left - 1;
        }
        return count;
    }

    public static void main(String[] args) {

        NumFriendRequests sol = new NumFriendRequests();

        int[] ages = {16,17,18};

        int result = sol.numFriendRequests(ages);

        System.out.println("Total friend requests: " + result);


    }
}
