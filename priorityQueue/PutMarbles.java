package priorityQueue;

import java.util.ArrayList;
import java.util.Arrays;

public class PutMarbles {
    public long putMarbles(int[] weights, int k ){
        int n  = weights.length;

        if (k == 1) return 0;
        long[] pair = new long[n - 1];

        //step 1 : compute pair sums
        for (int i = 0; i < n - 1; i ++){
            pair[i] = weights[i] + weights[i + 1];
        }
        //step 2 : sort
        Arrays.sort(pair);

        long minScore = 0;
        long maxScore = 0;

        //step 3 : pick k - 1 smallest and largest
        for (int i = 0; i < k - 1; i++) {
            minScore += pair[i];
            maxScore += pair[n - 2 - i];
        }
        return  maxScore - minScore;
    }

    public static void main(String[] args) {
        PutMarbles obj = new PutMarbles();
        int[] weight = {1,3,5,1};
        int k = 2;
        System.out.println(obj.putMarbles(weight,k));
    }
}
