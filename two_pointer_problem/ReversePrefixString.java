package two_pointer_problem;

public class ReversePrefixString {

    public String reversePrefix(String s, int k) {
        //convert string to char array for in-place  modification
        char[] arr = s.toCharArray();

        int left = 0;
        int right = k - 1;

        //reverse first ke character
        while (left < right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        //convert back to string
        return new String(arr);

    }
    public static void main(String[] args) {
        ReversePrefixString sol = new ReversePrefixString();

        String s1 = "abcd";
        int k1 = 2;

        String s2 = "xyz";
        int k2 = 3;

        String s3 = "hey";
        int k3 = 1;

        System.out.println("Output 1: " + sol.reversePrefix(s1, k1)); // bacd
        System.out.println("Output 2: " + sol.reversePrefix(s2, k2)); // zyx
        System.out.println("Output 3: " + sol.reversePrefix(s3, k3)); // hey

    }
}
