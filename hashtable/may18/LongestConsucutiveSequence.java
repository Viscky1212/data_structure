package hashtable.may18;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//Sol = 3
public class LongestConsucutiveSequence {

    public int longestConsecutive(int[] nums){
        Set<Integer> set = new HashSet<>();

        for (int num : nums){
            set.add(num);
        }

        int longest = 0;

        for (int num : set){
            if (!set.contains(num - 1)){
                int currentNum = num;
                int currentLength = 1;

                while (set.contains(currentNum + 1)){
                    currentNum++;
                    currentLength++;
                }
                longest = Math.max(longest,currentLength);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestConsucutiveSequence sol = new LongestConsucutiveSequence();
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println(sol.longestConsecutive(nums1));
        // Output: 4

        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(sol.longestConsecutive(nums2));
        // Output: 9

        int[] nums3 = {1, 0, 1, 2};
        System.out.println(sol.longestConsecutive(nums3));
        // Output: 3

        int[] nums4 = {};
        System.out.println(sol.longestConsecutive(nums4));
        // Output: 0
    }
}
