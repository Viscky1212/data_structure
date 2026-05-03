package binarySearch.april28;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class AvoidFlood {

    public int[] avoidFlood(int[] rains){
        int n = rains.length;

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        //lake -> last rain day
        Map<Integer,Integer> lastRain = new HashMap<>();
        //Available dry days
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0){
                //store dry day
                dryDays.add(i);
                ans[i] = 1; //temporary can overwrite later
            } else {
                int lake = rains[i];

                //if lake is already filled -> need to dry before today
                if (lastRain.containsKey(lake)){
                    int lastDay = lastRain.get(lake);

                    //find dry day after lastday
                    Integer dryDay = dryDays.ceiling(lastDay);


                    if (dryDay == null) {
                        return new int[0]; // impossible
                    }
                    // assign dry day to this lake
                    ans[dryDay] = lake;

                    // remove used dry day
                    dryDays.remove(dryDay);
                }

                // update last rain day
                lastRain.put(lake, i);

                ans[i] = -1; // raining day
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        AvoidFlood sol = new AvoidFlood();
        int[] rains1 = {1,2,0,0,2,1};
        System.out.println(Arrays.toString(sol.avoidFlood(rains1)));
        // Expected: [-1,-1,2,1,-1,-1] (or similar)

        int[] rains2 = {1,2,3,4};
        System.out.println(Arrays.toString(sol.avoidFlood(rains2)));
        // [-1,-1,-1,-1]

        int[] rains3 = {1,2,0,1,2};
        System.out.println(Arrays.toString(sol.avoidFlood(rains3)));
        // []
    }
}
