package patternBase.prefixSum.medium;

public class CorpFlightBookings {

    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n];

        //build difference array
        for(int[] booking : bookings){
            int first = booking[0];
            int last = booking[1];
            int seats = booking[2];

            //add seats at the starting flight
            diff[first - 1] += seats;

            //remove seats after the ending flight
            if(last < n){
                diff[last] -= seats;
            }
        }

        //convert difference array to actual reservation
        for(int i = 1; i < n; i++){
            diff[i] += diff[i - 1];
        }
        return diff;
    }
    public static void main(String[] args) {
        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int n = 5;
        int[] result = corpFlightBookings(bookings, n);
        for (int seats : result) {
            System.out.print(seats + " ");
        }
    }
}
