package two_pointer_problem;

public class NextGreaterElement {

    public int nextGreaterElement(int n){
        char[] digits = String.valueOf(n).toCharArray();
        int len = digits.length;

        //Step 1: Find pivot - rightmost  i where digits[i] < digits[i + 1]
        int i = len - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]){
            i--;
        }
        //No pivot found - already the largest permutation
        if (i < 0) return -1;

        //Step 2 : Find rightmost j where digits[j] > digits[pivot]
        int j = len - 1;
        while (digits[j] <= digits[i]){
            j--;
        }

        // Step 3: Swap pivot and j
        swap(digits, i, j);

        // Step 4: Reverse everything after pivot
        reverse(digits, i + 1, len - 1);
        // Step 5: Convert back and check 32-bit overflow
        long result = Long.parseLong(new String(digits));
        return result <= Integer.MAX_VALUE ? (int) result : -1;

    }

    public void swap(char[] digits, int i, int j){
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }

    public void reverse(char[] digits, int left, int right){
        while (left < right){swap(digits, left++,right--);}
    }

    public static void main(String[] args) {

        NextGreaterElement sol = new NextGreaterElement();
        // Happy path
        System.out.println(sol.nextGreaterElement(12));         // 21
        System.out.println(sol.nextGreaterElement(21));         // -1
        System.out.println(sol.nextGreaterElement(1234));       // 1243
        System.out.println(sol.nextGreaterElement(4321));       // -1 (descending)
        System.out.println(sol.nextGreaterElement(534976));     // 536479

        // 32-bit overflow — valid permutation but exceeds Integer.MAX_VALUE
        System.out.println(sol.nextGreaterElement(2147483647)); // -1 (MAX_VALUE itself)
        System.out.println(sol.nextGreaterElement(1999999999)); // -1 (next perm overflows)

        // Single digit — no greater permutation possible
        System.out.println(sol.nextGreaterElement(5));          // -1

        // All same digits
        System.out.println(sol.nextGreaterElement(1111));       // -1
    }

}
