package two_pointer_problem;

public class ShortestDistanceApp {

    public int[] shortestToChar(String s, char c) {

        int n = s.length();
        int[] result = new int[n];

        // First pass (left → right)
        int prev = -n; // very far

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            result[i] = i - prev;
        }

        // Second pass (right → left)
        prev = 2 * n; // very far

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                prev = i;
            }
            result[i] = Math.min(result[i], prev - i);
        }

        return result;
    }
    public static void main(String[] args) {
        ShortestDistanceApp solution = new ShortestDistanceApp();

        String s1 = "loveleetcode";
        char c1 = 'e';

        int[] result1 = solution.shortestToChar(s1, c1);

        System.out.print("Output: ");
        for (int num : result1) {
            System.out.print(num + " ");
        }

        System.out.println("\n----------------------");

        String s2 = "aaab";
        char c2 = 'b';

        int[] result2 = solution.shortestToChar(s2, c2);

        System.out.print("Output: ");
        for (int num : result2) {
            System.out.print(num + " ");
        }
    }
}
