package dp.dp2;

public class HouseRobbery {

    public int rob(int[] nums){
        int n = nums.length;

        if (n == 1){
            return nums[0];
        }
        return Math.max(robLinear(nums,0, n - 2),robLinear(nums,1,n - 1));
    }

    private int robLinear(int[] nums, int start, int end){
        int prev1 = 0;
        int prev2 = 0;

        for (int i = start; i <= end; i++) {
            System.out.println("i : "+ i);
            int pic = nums[i] + prev2;
            System.out.println("pic : "+pic);
            int notPick = prev1;
            System.out.println("Not pic : "+notPick);
            int curr = Math.max(pic,notPick);
            System.out.println("current pic : "+curr);

            prev2 = prev1;
            System.out.println("prev2 : " + prev2);
            prev1 =curr;
            System.out.println("prev1 : " + prev1);
        }
        return prev1;
    }

    public static void main(String[] args) {
        HouseRobbery sol = new HouseRobbery();
        int[] nums = {2, 3, 2};

        System.out.println(sol.rob(nums));
    }
}
