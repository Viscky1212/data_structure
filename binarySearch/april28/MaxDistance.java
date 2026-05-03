package binarySearch.april28;

import java.util.Arrays;

public class MaxDistance {
    public int maxDistance(int[] position, int m){
        Arrays.sort(position);

        int low = 1;
        int high = position[position.length - 1] - position[0];

        int ans = 0;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (canPlace(position, m, mid)){
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean canPlace(int[] position, int m, int dist){
        int count  = 1;
        int lastPos = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPos >= dist){
                count++;
                lastPos = position[i];
            }

            if (count >= m){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        MaxDistance sol = new MaxDistance();

        int[] pos1 = {1,2,3,4,7};
        System.out.println(sol.maxDistance(pos1, 3)); // 3

        int[] pos2 = {5,4,3,2,1,1000000000};
        System.out.println(sol.maxDistance(pos2, 2)); // 999999999
    }
}
