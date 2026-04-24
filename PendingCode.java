public class PendingCode {

    /*
    import java.util.*;

public class Solution {
    public static ArrayList<Integer> subarraySum(int[] arr, int n, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int left = 0, currSum = 0;

        for (int right = 0; right < n; right++) {
            currSum += arr[right];

            while (currSum > sum && left <= right) {
                currSum -= arr[left++];
            }

            if (currSum == sum) {
                // Shrink leading zeros to get the first valid minimal window
                while (left < right && arr[left] == 0) {
                    left++;
                }
                result.add(left + 1);
                result.add(right + 1);
                return result;
            }
        }

        result.add(-1);
        return result;
    }
}





public class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                result = mid;
                high = mid - 1; // keep searching left for first occurrence
                continue;
            }

            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return result;
    }
}

     */
}
