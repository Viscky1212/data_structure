package hash_hashing.practice;

import java.util.*;

public class LeastBricks {

    public static int leastBricks(List<List<Integer>> wall){
        Map<Integer,Integer> map = new HashMap<>();

        int maxEdge = 0;

        //step 1 : process each row
        for(List<Integer> row : wall){
            int sum = 0;

            //step 2 : calculate prefix sum (include last brick)
            for (int i = 0; i < row.size() - 1; i++){
                sum += row.get(i);

                //count edge frequency
                int count = map.getOrDefault(sum, 0) + 1;
                map.put(sum,count);

                maxEdge = Math.max(maxEdge,count);
            }
        }
        //step 3 result
        return wall.size() - maxEdge;
    }

    public static void main(String[] args) {
        List<List<Integer>> wall = new ArrayList<>();
        wall.add(Arrays.asList(1,2,2,1));
        wall.add(Arrays.asList(3,2,1));
        wall.add(Arrays.asList(1,3,2));
        wall.add(Arrays.asList(2,4));
        wall.add(Arrays.asList(3,1,2));
        wall.add(Arrays.asList(1,3,1,1));

        System.out.println(leastBricks(wall));
    }
}
