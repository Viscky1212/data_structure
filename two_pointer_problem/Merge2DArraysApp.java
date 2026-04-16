package two_pointer_problem;

import java.util.ArrayList;
import java.util.List;

public class Merge2DArraysApp {

    public int[][] mergeArrays(int[][] nums1, int[][] nums2){
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();

        while (i < nums1.length && j < nums2.length){
            int id1 = nums1[i][0];
            int val1 = nums1[i][1];

            int id2 = nums2[j][0];
            int val2 = nums2[j][1];

            if (id1 == id2){
                res.add(new int[]{id1,val1 + val2});
                i++;
                j++;
            } else if (id1 < id2) {
                res.add(new int[] {id1,val1});
                i++;
            }
            else {
                res.add(new int[]{id2,val2});
                j++;
            }
        }

        //Remaining element
        while (i < nums1.length){
            res.add(nums1[i++]);
        }
        while (j < nums2.length){
            res.add(nums2[j++]);
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        Merge2DArraysApp solution = new Merge2DArraysApp();
        int[][] nums1 = {{1,2},{2,3},{4,5}};
        int[][] nums2 = {{1,4},{3,2},{4,1}};

        int[][] result = solution.mergeArrays(nums1, nums2);

        for (int[] pair : result) {
            System.out.println(pair[0] + " " + pair[1]);
        }
    }
}
