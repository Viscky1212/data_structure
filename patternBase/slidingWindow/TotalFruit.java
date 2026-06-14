package patternBase.slidingWindow;

import java.util.*;

public class TotalFruit {

//    public int totalFruit(int[] fruits) {
//        int left = 0;
//        int maxLength = 0;
//
//        Map<Integer, Integer> fruitCountMap = new HashMap<>();
//
//        for (int right = 0; right < fruits.length; right++) {
//            int fruit = fruits[right];
//            fruitCountMap.put(fruit, fruitCountMap.getOrDefault(fruit, 0) + 1);
//
//            while (fruitCountMap.size() > 2) {
//                int leftFruit = fruits[left];
//                fruitCountMap.put(leftFruit, fruitCountMap.get(leftFruit) - 1);
//                if (fruitCountMap.get(leftFruit) == 0) {
//                    fruitCountMap.remove(leftFruit);
//                }
//                left++;
//            }
//
//            maxLength = Math.max(maxLength, right - left + 1);
//        }

//        return maxLength;
//    }

    public static  int totalFruit(int[] fruits ){
        int left = 0;
        int right = 0;
        int maxLength = 0;

        Map<Integer,Integer> map = new HashMap<>();

        System.out.println("Initial map: " + map);
        for (right = 0; right < fruits.length; right++) {
            int currentFruit = fruits[right];

            System.out.println("Right: " + right + ", Current Fruit: " + currentFruit);
            map.put(currentFruit, map.getOrDefault(currentFruit, 0) + 1);
            System.out.println("Map after adding fruit: " + map);
            map.put(currentFruit, map.getOrDefault(currentFruit,0) + 1);

            while (map.size() > 2){
                int leftFruits = fruits[left];
                System.out.println("Left: " + left + ", Left Fruit: " + leftFruits);

                map.put(leftFruits,map.get(leftFruits) - 1);

                if (map.get(leftFruits) == 0){
                    map.remove(leftFruits);
                }
                left++;
            }

            int currentWindowSize = right - left + 1;
            System.out.println("Current Window: [" + left + ", " + right + "], Size: " + currentWindowSize);

            maxLength = Math.max(maxLength, currentWindowSize);
            System.out.println("Max Length: " + maxLength);

        }
        return maxLength;
    }

    public static void main(String[] args) {
        TotalFruit sol = new TotalFruit();
        int[] fruits1 = {1, 2, 1};
        System.out.println(sol.totalFruit(fruits1)); // Output: 3

        int[] fruits2 = {0, 1, 2, 2};
        System.out.println(sol.totalFruit(fruits2)); // Output: 3

        int[] fruits3 = {1, 2, 3, 2, 2};
        System.out.println(sol.totalFruit(fruits3)); // Output: 4

        int[] fruits4 = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4};
        System.out.println(sol.totalFruit(fruits4)); // Output: 5
    }
}
