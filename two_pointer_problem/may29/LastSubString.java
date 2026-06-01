package two_pointer_problem.may29;

public class LastSubString {

    public static void main(String[] args) {
        LastSubString sol = new LastSubString();
        String s1 = "abab";
        System.out.println(sol.lastSubstring(s1));
        // Output: "bab"

        String s2 = "leetcode";
        System.out.println(sol.lastSubstring(s2));
        // Output: "tcode"
    }

    public String lastSubstring(String s) {
        int n = s.length();
        int first = 0;
        int second = 1;
        int offset = 0;

        while (second + offset < n) {
            char left = s.charAt(first + offset);
            char right = s.charAt(second + offset);

            if (left == right) {
                offset++;
            } else if (left < right) {
                first = Math.max(first + offset + 1, second);
                second = first + 1;
                offset = 0;
            } else {
                second = second + offset + 1;
                offset = 0;
            }
        }

        return s.substring(first);
    }

}
