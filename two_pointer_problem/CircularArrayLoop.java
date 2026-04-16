package two_pointer_problem;

public class CircularArrayLoop {

    public static  boolean circularArrayLoop(int[] nums){
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;;

            int slow = i;
            int fast = i;

            boolean forward = nums[i] > 0;

            while (true){
                slow = next(nums, forward, slow);
                if(slow == -1) break;

                fast = next(nums, forward, fast);
                if(fast == -1) break;

                fast = next(nums, forward, fast);
                if(fast == -1) break;

                if(slow == fast)
                    return true;
            }

            // mark visited nodes
            int index = i;
            int sign = nums[i];

            while(sign * nums[index] > 0){

                int nextIndex = ((index + nums[index]) % n + n) % n;
                nums[index] = 0;
                index = nextIndex;
            }
        }

        return false;
    }

    public static   int next(int[] nums, boolean forward, int index){

        boolean direction = nums[index] > 0;
        if (direction != forward) return -1;

        int n = nums.length;

        int nextIndex = ((index + nums[index]) % n + n) % n;

        if (nextIndex == index) return -1;

        return nextIndex;
    }

    public static void main(String[] args) {

        int[] nums = {2,-1,1,2,2};

        System.out.println(circularArrayLoop(nums));


    }
}
