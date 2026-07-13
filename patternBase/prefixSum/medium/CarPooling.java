package patternBase.prefixSum.medium;

public class CarPooling {

    public static boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];

        for(int[] trip : trips){
            int passangers = trip[0];
            int from = trip[1];
            int to = trip[2];

            diff[from] += passangers;
            diff[to] -= passangers;
        }
        int currentPassangers = 0;

        //prefix sum to know active passangers at each point
        for(int i = 0; i <= 1000; i++){
            currentPassangers += diff[i];

            if(currentPassangers > capacity){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] trips = {{2, 1, 5}, {3, 3, 7}};
        int capacity = 4;
        boolean result = carPooling(trips, capacity);
        System.out.println(result); // Output: false
    }
}
