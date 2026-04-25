package binarySearch.april24;

import java.util.Arrays;
import java.util.Random;

public class RandomPick {

    int[][] rects;
    int[] prefixSum;
    Random random;

    public RandomPick(int[][] rects){
        this.rects = rects;
        this.prefixSum = new int[rects.length];
        this.random = new Random();

        int sum = 0;
        for (int i = 0; i < rects.length; i++) {
            int points = (rects[i][2] - rects[i][0] + 1) *  (rects[i][3] - rects[i][1] + 1);
            sum += points;
            prefixSum[i] = sum;
        }
    }

    public int[] pick(){
        int target = random.nextInt(prefixSum[prefixSum.length - 1] + 1);
        int left = 0, right = prefixSum.length - 1;

        while (left < right){
            int mid = left + ( right - left) / 2;

            if (prefixSum[mid] < target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int[] rect = rects[left];

        int x = rect[0] + random.nextInt(rect[2] - rect[0] + 1);
        int y = rect[1] + random.nextInt(rect[3] - rect[1] + 1);

        return  new int[]{x, y};
    }


    public static void main(String[] args) {
        int[][] rects = {
                {-2, -2, 1, 1},
                {2, 2, 4, 6}
        };

        RandomPick solution = new RandomPick(rects);

        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
    }
}
