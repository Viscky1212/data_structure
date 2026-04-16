package slidingwindow.april03;

import java.util.*;

public class FindXSum {

    public int[] findXSum(int[] nums, int k, int x){
        int n = nums.length;
        int[] result = new int[n - k + 1];

        for (int i = 0; i < n - k; i++) {
            //Step 1 : Frequency map
            Map<Integer,Integer>freq = new HashMap<>();

            for (int j = i; j < i + k; j++) {
                freq.put(nums[j],freq.getOrDefault(nums[j],0) +1);
            }

            //Step 2 : convert in list
            List<int[]> list =new ArrayList<>();

            for (Map.Entry<Integer,Integer> entry : freq.entrySet()){
                list.add(new int[]{entry.getKey(),entry.getValue()});
            }

            //Step 3 : Sort
            list.sort((a, b) ->
                    {
                        if (b[1] != a[1]) return  b[1] - a[1]; //freq DESC
                        return b[0] - a[0];// value desc
                    }
            );

            //Step 4 : Pick top x

            int sum = 0;
            int count = 0;

            for (int[] pair : list){
                if (count == x) break;

                int val = pair[0];
                int f = pair[1];

                sum += val * f;
                count++;
            }
            result[i] = sum;

        }
        return result;
    }


    public static void main(String[] args) {
        FindXSum sol = new FindXSum();
        int[] nums1 = {1,1,2,2,3,4,2,3};
        int k1 = 6, x1 = 2;

        int[] nums2 = {3,8,7,8,7,5};
        int k2 = 2, x2 = 2;

        System.out.println(Arrays.toString(sol.findXSum(nums1, k1, x1)));
        // [6, 10, 12]

        System.out.println(Arrays.toString(sol.findXSum(nums2, k2, x2)));
        // [11, 15, 15, 15, 12]
    }
}
