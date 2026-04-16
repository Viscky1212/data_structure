package slidingwindow.april10;

import java.util.TreeSet;

public class ContainsNearbyAlmostDuplicate {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff){
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];

            //find closest smaller or equal
            Long floor = set.floor(num);

            if (floor != null && num - floor <= valueDiff){
                return true;
            }

            //Find closest greater or equal
            Long ciel = set.ceiling(num);
            if (ciel != null && ciel - num <= valueDiff) return true;

            set.add(num);

            // Maintain window size k
            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsNearbyAlmostDuplicate sol = new ContainsNearbyAlmostDuplicate();
        int[] nums1 = {1,2,3,1};
        System.out.println(sol.containsNearbyAlmostDuplicate(nums1, 3, 0)); // true

        int[] nums2 = {1,5,9,1,5,9};
        System.out.println(sol.containsNearbyAlmostDuplicate(nums2, 2, 3)); // false
    }
}
