package binarySearch.april29;

public class MinimizedMaximum {

    public int minimizedMaximum(int n, int[] quantities){
        int low = 1;
        int high = 0;

        for (int q : quantities){
            high = Math.max(high,q);
        }

        int ans = high;

        while (high >= low){
            int mid = low + (high - low) / 2;

            if (canDistribute(quantities, n , mid)){
                ans = mid;
                high = mid - 1; //try smaller max
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public boolean canDistribute(int[] quantities, int n, int maxPerStore){
        long storeNeeded = 0;
        for (int q  : quantities){
            //ceil (q / maxPerStore)
            storeNeeded += (q + maxPerStore - 1) / maxPerStore;

            if (storeNeeded > n ){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        MinimizedMaximum sol = new MinimizedMaximum();

        int[] q1 = {11,6};
        System.out.println(sol.minimizedMaximum(6, q1)); // 3

        int[] q2 = {15,10,10};
        System.out.println(sol.minimizedMaximum(7, q2)); // 5

        int[] q3 = {100000};
        System.out.println(sol.minimizedMaximum(1, q3)); // 100000
    }
}
