package patternBase.slowFast;

public class CircularArrayLoop {

    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;

            int slow = i, fast = i;
            boolean isForward = nums[i] > 0;

            while (true) {
                slow = nextIndex(nums, isForward, slow);
                fast = nextIndex(nums, isForward, fast);
                if (fast != -1) {
                    fast = nextIndex(nums, isForward, fast);
                }

                if (slow == -1 || fast == -1 || slow == fast) break;
            }

            if (slow != -1 && slow == fast) return true;

            // Mark all nodes in the current loop as 0 to avoid reprocessing
            int index = i;
            while (index != -1 && nums[index] != 0) {
                int next = nextIndex(nums, nums[index] > 0, index);
                nums[index] = 0;
                index = next;
            }
        }

        return false;
    }

    private int nextIndex(int[] nums, boolean isForward, int currentIndex) {
        boolean direction = nums[currentIndex] > 0;
        if (direction != isForward) return -1;

        int nextIndex = (currentIndex + nums[currentIndex]) % nums.length;
        if (nextIndex < 0) nextIndex += nums.length;

        if (nextIndex == currentIndex) return -1; // Single-element loop

        return nextIndex;
    }

    public static void main(String[] args) {
        CircularArrayLoop sol = new CircularArrayLoop();
        int[] nums1 = {2, -1, 1, 2, 2};
        System.out.println(sol.circularArrayLoop(nums1)); // Output: true

        int[] nums2 = {-1, 2};
        System.out.println(sol.circularArrayLoop(nums2)); // Output: false

        int[] nums3 = {-2, 1, -1, -2, -2};
        System.out.println(sol.circularArrayLoop(nums3)); // Output: false
    }
}
