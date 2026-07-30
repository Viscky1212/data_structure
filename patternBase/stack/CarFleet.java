package patternBase.stack;

import java.util.Arrays;

public class CarFleet {

    public static int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        int[][] cars = new int[n][2];

        // Position + Speed को एक साथ रखो
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Position Descending
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        int fleets = 0;
        double lastTime = 0;

        for (int[] car : cars) {

            double time = (double) (target - car[0]) / car[1];

            // नई Fleet
            if (time > lastTime) {
                fleets++;
                lastTime = time;
            }
        }

        return fleets;
    }

//    public static int carFleet(int target, int[] position, int[] speed) {
//        int n = position.length;
//        double[][] cars = new double[n][2];
//
//        for (int i = 0; i < n; i++) {
//            cars[i][0] = position[i];
//            cars[i][1] = (double) (target - position[i]) / speed[i];
//        }
//
//        java.util.Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
//
//        int fleets = 0;
//        double lastTime = 0;
//
//        for (double[] car : cars) {
//            if (car[1] > lastTime) {
//                fleets++;
//                lastTime = car[1];
//            }
//        }
//
//        return fleets;
//    }

    public static void main(String[] args) {

        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};

        System.out.println(carFleet(target, position, speed)); // Output: 3
    }
}
