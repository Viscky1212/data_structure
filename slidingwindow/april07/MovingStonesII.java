package slidingwindow.april07;

import java.util.Arrays;

public class MovingStonesII {

    public static int[] numMovesStonesII(int[] stones){
        int n = stones.length;
        Arrays.sort(stones);

        //Max Moves

        int maxMoves = Math.max(
                stones[n - 1] - stones[1] - (n - 2),
                stones[n - 2] - stones[0] - (n - 2)
        );

        //Min moves sliding window
        int minMoves = n;
        int left = 0;

        for (int right = 0; right < n; right++) {
            //Maintain window size <= n
            while (stones[right] - stones[left] + 1 > n){
                left++;
            }
            int alreadyPlaced = right - left + 1;

            //spacial case
            if (alreadyPlaced == n - 1 && stones[right] - stones[left] + 1 == n - 1){
                minMoves = Math.min(minMoves, 2);
            } else {
                minMoves = Math.min(minMoves, n - alreadyPlaced);
            }
        }
        return new int[]{minMoves, maxMoves};
    }


    public static void main(String[] args) {

        int[] stones = {6, 5, 4, 3, 10};

        int[] result = numMovesStonesII(stones);

        System.out.println("Min Moves: " + result[0]);
        System.out.println("Max Moves: " + result[1]);
    }
}
