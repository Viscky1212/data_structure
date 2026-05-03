package binarySearch.april28;

public class MinSpeedOnTime {

    public int minSpeedOnTime(int[] dist, double hour){
        int n = dist.length;

        //edge case
        if (hour <= n - 1) return -1;

        int low = 1, high = 10_000_000;
        int ans = -1;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if (canReach(dist,hour,mid)){
                ans = mid;
                high = mid - 1; //try smaller speed
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean canReach(int[] dist, double hour, int speed){
        double time = 0.0;

        int n = dist.length;

        for (int i = 0; i < n - 1; i++) {
            //ceil division
            time += Math.ceil((double) dist[i]/ speed);

            if (time > hour){
                return  false;  //early exit
            }
        }
        //last train
        time += (double) dist[n - 1] / speed;

        return time <= hour;
    }

    public static void main(String[] args) {

        MinSpeedOnTime sol = new MinSpeedOnTime();

        int[] dist1 = {1,3,2};
        System.out.println(sol.minSpeedOnTime(dist1, 6));   // 1
        System.out.println(sol.minSpeedOnTime(dist1, 2.7)); // 3
        System.out.println(sol.minSpeedOnTime(dist1, 1.9)); // -1
    }
}
