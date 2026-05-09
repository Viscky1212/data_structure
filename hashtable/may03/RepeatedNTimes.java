package hashtable.may03;

public class RepeatedNTimes {
    public int repeatedNTimes(int[] nums){
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i + 1 < n && nums[i] == nums[ i + 1]){
                return nums[i];
            }

            if (i + 2 < n && nums[i] == nums[ i + 2]){
                return nums[i];
            }

            if (i + 3 < n && nums[i] == nums[ i + 3]){
                return nums[i];
            }
        }
        return  -1;

    }

    public static void main(String[] args) {

        RepeatedNTimes sol = new RepeatedNTimes();

        System.out.println(sol.repeatedNTimes(new int[]{1,2,3,3})); // 3
        System.out.println(sol.repeatedNTimes(new int[]{2,1,2,5,3,2})); // 2
        System.out.println(sol.repeatedNTimes(new int[]{5,1,5,2,5,3,5,4})); // 5
    }
}
