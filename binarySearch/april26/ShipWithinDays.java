package binarySearch.april26;

import java.util.Map;

public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int days){
        int low = 0;
        int high = 0;

        for (int w : weights){
            low = Math.max(low, w);  //max weight fetch
            high += w;  // total weight
        }


        //Binary search on capacity
        while (low < high){
            int mid = low + (high - low) / 2;

            if (canShip(weights,days,mid)){
                high = mid - 1;  //try for smaller capacity
            } else {
                low = mid  + 1;  //increase capacity
            }
        }
        return low;
    }

    private boolean canShip(int[] weight, int days, int capacity){
        int requiredDays = 1;
        int currentLoad = 0;

        for (int w : weight){

            if (currentLoad + w > capacity){
                requiredDays++;
                currentLoad = 0;
            }
            currentLoad += w;
        }
        return requiredDays <= days;
    }

    public static void main(String[] args) {
        ShipWithinDays solution = new ShipWithinDays();
        // Test Case 1
        int[] weights1 = {1,2,3,4,5,6,7,8,9,10};
        int days1 = 5;
        System.out.println("Minimum Capacity: " + solution.shipWithinDays(weights1, days1));
        // Expected Output: 15

        // Test Case 2
        int[] weights2 = {3,2,2,4,1,4};
        int days2 = 3;
        System.out.println("Minimum Capacity: " + solution.shipWithinDays(weights2, days2));
        // Expected Output: 6

        // Test Case 3
        int[] weights3 = {1,2,3,1,1};
        int days3 = 4;
        System.out.println("Minimum Capacity: " + solution.shipWithinDays(weights3, days3));
        // Expected Output: 3
    }
}
