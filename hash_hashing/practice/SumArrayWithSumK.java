package hash_hashing.practice;

import java.util.*;

public class SumArrayWithSumK {

    public static int countSubArray(int[] nums, int k){
        int n = nums.length;

        //step 1 : find index of k
        int kIndex = 0;
        for(int i = 0; i < n; i++){
            if (nums[i] == k){
                kIndex = i;
                break;
            }
        }

        //Step 2 : map for right side balance
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);

        int balance = 0;

        //right side
        for (int i = kIndex + 1; i < n; i++) {
            if(nums[i] > k) balance += 1;
            else balance -= 1;
            map.put(balance,map.getOrDefault(balance,0) + 1);
        }
        //STep 3 : traverse left + count
        int count = 0;
        balance = 0;

        for (int i = kIndex; i >= 0; i--){
            if (nums[i] > k) balance += 1;
            else if (nums[i] < k) balance -= 1;

            //key logic
           count += map.getOrDefault(-balance, 0);
           count += map.getOrDefault(1 - balance, 0);
        }
        return count;

    }

    public static void main(String[] args) {
        int[] nums1 = {3,2,1,4,5};
        int k1 = 4;
        System.out.println("count  : "+countSubArray(nums1,k1));


        int[] nums2 = {2,3,1};
        int k2 = 3;

        System.out.println("Count : " + countSubArray(nums2,k2));

    }
}
