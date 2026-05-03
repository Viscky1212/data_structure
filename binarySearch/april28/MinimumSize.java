package binarySearch.april28;

public class MinimumSize {

    public int minimumSize(int[] nums , int mazOperations){
        int low = 1;
        int high = 0;

        //find max element
        for (int num : nums){
            high = Math.max(high, num);
        }

        int ans = high;

        while (low <= high){
            int mid = low + (high - low) / 2;

            if (canAchieve(nums, mazOperations,mid)){
                ans = mid;
                high = mid - 1; //try smaller penalty
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public boolean canAchieve(int[] nums, int maxOperations, int penalty){
        long operations = 0;
        for (int num : nums){
            operations += (num - 1) / penalty;

            //early stop (optimization)
            if (operations > maxOperations){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        MinimumSize sol = new MinimumSize();

        int[] nums1 = {9};
        System.out.println(sol.minimumSize(nums1, 2)); // 3

        int[] nums2 = {2,4,8,2};
        System.out.println(sol.minimumSize(nums2, 4)); // 2
    }
}
