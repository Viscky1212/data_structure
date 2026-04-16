package hash_hashing.practice;
import java.util.Arrays;

public class Solution1 {

    public static String sortDescending(String s) {

        // Convert to char array
        char[] arr = s.toCharArray();

        // Sort in ascending order
        Arrays.sort(arr);

        // Reverse for descending
        StringBuilder result = new StringBuilder();

        for (int i = arr.length - 1; i >= 0; i--) {
            result.append(arr[i]);
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String s1 = "vikrant";

        String output = sortDescending(s1);

        System.out.println("Input  : " + s1);
        System.out.println("Output : " + output);
    }
}