package two_pointer_problem;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums){
        //if array length <= 2, all element are valid

        if (nums.length <= 2){
            return nums.length;
        }

        int index = 2; //position to place next valid element

        for (int i = 2; i < nums.length; i++) {
            //allow element only if it is not same as element to place before
            if (nums[i] != nums[index - 2]){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = removeDuplicates(nums);

        System.out.println("New Length (k) : " + k);

        System.out.println("Array after removing extra  duplicate");

        for (int i = 0; i < k; i++) {
            System.out.println(nums[i] + " ");
        }
    }

}
