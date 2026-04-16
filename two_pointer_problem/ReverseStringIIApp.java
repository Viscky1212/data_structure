package two_pointer_problem;

public class ReverseStringIIApp {
    public String reverseStr(String s, int k){
        char[] arr = s.toCharArray();
        int n = arr.length;

        //Traverse every 2k block
        for (int i = 0; i < n; i += 2 * k){
            //define range to reverse
            int left = i;
            int right = Math.min(i + k - 1, n - 1);
            //Reverse first k character
            reverse(arr, left, right);
        }
        return new String(arr);

    }
    public void reverse(char[] arr, int left, int right){
        while (left < right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ReverseStringIIApp solution  = new ReverseStringIIApp();

        // Test Case 1
        String s1 = "abcdefg";
        int k1 = 2;
        System.out.println("Input: " + s1 + ", k = " + k1);
        System.out.println("Output: " + solution.reverseStr(s1, k1));

        System.out.println("------------------------");

        // Test Case 2
        String s2 = "abcd";
        int k2 = 2;
        System.out.println("Input: " + s2 + ", k = " + k2);
        System.out.println("Output: " + solution.reverseStr(s2, k2));

    }
}
