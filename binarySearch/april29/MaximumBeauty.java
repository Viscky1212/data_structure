package binarySearch.april29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaximumBeauty {

    public int[] maximumBeauty(int[][] items, int[] queries) {
        int maxI = Integer.MAX_VALUE;
        List<int[]> res = new ArrayList<>();
        res.add(new int[] {0,0,maxI});

        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));

        for (int[] item : items){
            int price = item[0];
            int beauty = item[1];
            int[] lastBracket = res.get(res.size() - 1);
            if (beauty > lastBracket[1]){
                lastBracket[2] = price;
                res.add(new int[] {price,beauty,maxI});
            }
        }
        int [] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int x = queries[i];
            for (int j = res.size() - 1; j >= 0; j--) {
                if (res.get(j)[0] <= x){
                    ans[i] = res.get(j)[1];
                    break;
                }
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        MaximumBeauty sol = new MaximumBeauty();
        int[][] items = {{1,2},{3,2},{2,4},{5,6},{3,5}};
        int[] queries = {1,2,3,4,5,6};

        System.out.println(Arrays.toString(
                sol.maximumBeauty(items, queries)
        ));
        // [2,4,5,5,6,6]
    }
}

