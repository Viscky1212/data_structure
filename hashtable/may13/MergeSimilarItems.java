package hashtable.may13;

import java.util.*;

public class MergeSimilarItems {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2){
        TreeMap<Integer,Integer> map = new TreeMap<>();

        //Add items from first array
        for (int[] item : items1){
            int value = item[0];
            int weight = item[1];

            map.put(value,map.getOrDefault(value,0) + weight);
        }
        //add items from second array
        for (int[] item : items2){
            int value = item[0];
            int weight = item[1];
            map.put(value,map.getOrDefault(value,0) + weight);
        }
        List<List<Integer>> result = new ArrayList<>();

        //TreeMap gives value in ascending order
        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            result.add(Arrays.asList(entry.getKey(),entry.getValue()));
        }
        return result;
    }

    public static void main(String[] args) {
        MergeSimilarItems sol = new MergeSimilarItems();
        int[][] items1 = {{1,1},{4,5},{3,8}};
        int[][] items2 = {{3,1},{1,5}};

        System.out.println(sol.mergeSimilarItems(items1, items2));
        // Output: [[1, 6], [3, 9], [4, 5]]
    }
}
