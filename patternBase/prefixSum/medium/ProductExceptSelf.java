package patternBase.prefixSum.medium;

import java.util.Arrays;

public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        //answer[i] will first store left product
        answer[0] = 1;

        //left product for each index
        for(int i = 1; i < n; i++){
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        //running product of right side
        int suffixProduct = 1;

        //multiply left product by right product
        for(int i = n - 1; i >= 0; i--){
            answer[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }
        return answer;

    }
    public static void main(String[] args) {
        ProductExceptSelf solution = new ProductExceptSelf();
        int[] nums = {1, 2, 3, 4};

        int[] result = solution.productExceptSelf(nums);
        System.out.println("Product of array except self: " + Arrays.toString(result));
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
