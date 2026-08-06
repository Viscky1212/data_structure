package patternBase.stack;

import java.util.*;

public class GetCollisionTimes {

    public static double[] getCollisionTimes(int[][] cars) {

        int n = cars.length;

        double[] ans = new double[n];
        Arrays.fill(ans, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty()) {

                int j = stack.peek();

                // Current car can never catch j
                if (cars[i][1] <= cars[j][1]) {
                    stack.pop();
                    continue;
                }

                double time =
                        (double)(cars[j][0]-cars[i][0])/
                                (cars[i][1]-cars[j][1]);

                // j collides before i reaches it
                if (ans[j] > 0 && time > ans[j]) {
                    stack.pop();
                } else {
                    break;
                }
            }

            if (!stack.isEmpty()) {

                int j = stack.peek();

                ans[i] =
                        (double)(cars[j][0]-cars[i][0])/
                                (cars[i][1]-cars[j][1]);
            }

            stack.push(i);
        }

        return ans;
    }

//    public static double[] getCollisionTimes(int[] cars, int[] speeds) {
//        int n = cars.length;
//        double[] collisionTimes = new double[n];
//
//        for (int i = 0; i < n; i++) {
//            collisionTimes[i] = -1; // Initialize with -1 (no collision)
//        }
//
//        for (int i = 0; i < n - 1; i++) {
//            if (speeds[i] > speeds[i + 1]) {
//                collisionTimes[i] = (double)(cars[i + 1] - cars[i]) / (speeds[i] - speeds[i + 1]);
//            }
//        }
//
//        return collisionTimes;
//    }

    public static void main(String[] args) {

//        int[] cars = {10, 8, 5, 3};
//        int[] speeds = {2, 4, 1, 3};

       // double[] collisionTimes = getCollisionTimes(cars, speeds);

//        for (double time : collisionTimes) {
//            System.out.println(time);
//        }

        int[][] cars = {{10, 2}, {8, 4}, {5, 1}, {3, 3}};
        double[] collisionTimes = getCollisionTimes(cars);

        for (double time : collisionTimes) {
            System.out.println(time);
        }
    }
}
