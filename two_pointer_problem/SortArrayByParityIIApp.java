package two_pointer_problem;

public class SortArrayByParityIIApp {

    public static void main(String[] args) {
        SortArrayByParityIIApp solution = new SortArrayByParityIIApp();

        int[] nums1 = {4, 2, 5, 7};
        int[] result1 = solution.sortArrayByParityII(nums1);

        System.out.print("Output: ");
        printArray(result1);

        System.out.println("---------------------");

        int[] nums2 = {2, 3};
        int[] result2 = solution.sortArrayByParityII(nums2);

        System.out.print("Output: ");
        printArray(result2);
    }
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public int[] sortArrayByParityII(int[] nums) {

        int n = nums.length;
        int evenIndex = 0;
        int oddIndex = 1;
        while (evenIndex < n && oddIndex < n){
            //correct even position
            if (nums[evenIndex] % 2 == 0){
                evenIndex += 2;
            } else if (nums[oddIndex] % 2 == 1) {
                oddIndex += 2;
            }
            //Both are incorrect -> swap
            else {
                int temp = nums[evenIndex];
                nums[evenIndex] = nums[oddIndex];
                nums[oddIndex] = temp;

                evenIndex += 2;
                oddIndex += 2;

            }
        }
        return nums;
    }
    }
