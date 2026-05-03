package binarySearch.april30;

import java.util.Arrays;

public class PlatesBetweenCandles {

    public int[] platesBetweenCandles(String s, int[][] queries){

        int n = s.length();

        int[] prefix = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];

        //Step 1 : prefix sum
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') count++;
            prefix[i] = count;
        }

        //Step 2 nearest left candle
        int last = -1 ;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|'){
                last = i;
            }
            left[i] = last;
        }


        //Step 3 : nearest right candle
        last = -1;
        for (int i = n - 1; i >= 0; i--) {

            if (s.charAt(i) == '|'){
                last = i;
            }
            right[i] = last;
        }

        //Step 4 : answer queries
        int [] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int start = right[l];
            int end = left[r];

            if (start != -1 && end != -1 && start < end){
                result[i] = prefix[end] - prefix[start];
            } else {
                result[i] = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        PlatesBetweenCandles sol = new PlatesBetweenCandles();

        String s = "**|**|***|";
        int[][] queries = {{2,5},{5,9}};

        System.out.println(Arrays.toString(
                sol.platesBetweenCandles(s, queries)
        ));
        // [2, 3]
    }
}
