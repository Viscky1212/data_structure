package slidingwindow.april06;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

    public int totalFruit(int[] fruits){
        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < fruits.length; right++) {
            //Add current fruits
            map.put(fruits[right], map.getOrDefault(fruits[right],0) + 1);

            //if more than 2 types -> shrink window
            while (map.size() > 2){
                map.put(fruits[left], map.get(fruits[left]) -1);
                if (map.get(fruits[left])== 0){
                    map.remove(fruits[left]);
                }
                left++;
            }

            //update max length

            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        FruitIntoBaskets sol = new FruitIntoBaskets();

        int[] fruits = {1, 2, 3, 2, 2};

        int result = sol.totalFruit(fruits);

        System.out.println("Maximum fruits collected: " + result);
    }
}
