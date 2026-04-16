package dp;

public class NthUglyNumber {

    public static int nthUglyNumber(int n){
        //Step 1 : DP array to store ugly numbers
        int[] ugly = new int[n];
        ugly[0] = 1;  //first ugly number

        //Step 2 : pointer for 2, 3, 4
        int i2 = 0, i3 = 0, i5 = 0;

        //Step 3 : next multiple
        int next2 = 2, next3 = 3, next5 = 5;

        for (int i = 1; i < n; i++) {
            //pick smallest
            int nextUgly = Math.min(next2, Math.min(next3,next5));
            ugly[i] = nextUgly;

            // Step 5: move pointer(s)
            if (nextUgly == next2) {
                i2++;
                next2 = ugly[i2] * 2;
            }
            if (nextUgly == next3) {
                i3++;
                next3 = ugly[i3] * 3;
            }
            if (nextUgly == next5) {
                i5++;
                next5 = ugly[i5] * 5;
            }

        }
        return ugly[n - 1];
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(nthUglyNumber(n)); // Output: 12
    }
}
