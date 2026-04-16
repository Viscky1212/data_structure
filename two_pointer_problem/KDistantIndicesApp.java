package two_pointer_problem;

import java.util.*;

public class KDistantIndicesApp {

    public static void main(String[] args) {
        KDistantIndicesApp solution = new KDistantIndicesApp();
        int[] nums1 = {3,4,9,1,3,9,5};
        System.out.println(solution.findKDistantIndices(nums1, 9, 1));

        int[] nums2 = {2,2,2,2,2};
        System.out.println(solution.findKDistantIndices(nums2, 2, 2));
    }

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
    List<Integer> res = new ArrayList<>();
    int n = nums.length;
    
    int lastAdded = -1; //to avoid duplicate

        for (int i = 0; i < n; i++) {

            if (nums[i] == key){
                int start = Math.max(0, i - k);
                int end = Math.min(n - 1, i + k);

                //Avoid Adding duplicate
                for (int j = Math.max(start, lastAdded + 1); j <= end; j++) {
                    res.add(j);
                }
                lastAdded = end;
            }
        }
        return res;
    
    }

}
