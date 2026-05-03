package binarySearch.april28;

public class MinDays {

    public int minDays(int[] bloomDay, int m , int k){
        int n = bloomDay.length;

        //edge case
        if ((long) m * k > n){
            return -1;
        }

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        //Find min and max
        for (int day : bloomDay){
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        int ans = -1;

        while (low <= high){
            int mid = low + (high - low) / 2;
            if (canMake(bloomDay, m, k , mid)){
                ans = mid;
                high = mid - 1; //try earlier day
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public boolean canMake(int[] bloomDay, int m, int k, int day){
        int bouquets = 0;
        int flowers = 0;

        for (int bloom : bloomDay){

            if (bloom <= day){
                flowers++;

                if (flowers == k){
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
            if (bouquets >= m) return true;
        }
        return false;
    }

    public static void main(String[] args) {

        MinDays sol = new MinDays();

        int[] arr1 = {1,10,3,10,2};
        System.out.println(sol.minDays(arr1, 3, 1)); // 3

        int[] arr2 = {1,10,3,10,2};
        System.out.println(sol.minDays(arr2, 3, 2)); // -1

        int[] arr3 = {7,7,7,7,12,7,7};
        System.out.println(sol.minDays(arr3, 2, 3)); // 12
    }
}
