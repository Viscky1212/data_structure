package two_pointer_problem.aprill01;

public class MinimumLength {

    public int minimumLength(String s){
        int left = 0;
        int right = s.length() - 1;

        while (left < right && s.charAt(left) == s.charAt(right)){
            char targetChar = s.charAt(left);

            while (left <= right && s.charAt(left) == s.charAt(right)) left++;

            while (right >= left && s.charAt(right) == targetChar) right--;
        }
        return right - left + 1;
    }

    public static void main(String[] args) {
        MinimumLength sol = new MinimumLength();
        // Example 1
        String s1 = "ca";
        System.out.println("Example 1 Output: " + sol.minimumLength(s1));
        // Expected: 2 (Ends don't match, nothing is deleted)

        // Example 2
        String s2 = "cabaabac";
        System.out.println("Example 2 Output: " + sol.minimumLength(s2));
        // Expected: 0 (Everything is deleted step-by-step)

        // Example 3
        String s3 = "aabccabba";
        System.out.println("Example 3 Output: " + sol.minimumLength(s3));
        // Expected: 3 (Removes 'a's, then 'b's, leaving "cca")

        // Edge Case: String of all same characters
        String s4 = "aaaaa";
        System.out.println("Edge Case Output: " + sol.minimumLength(s4));
        // Expected: 0 (Left moves to end, right stays, difference is < 0, returns 0)
    }
}
