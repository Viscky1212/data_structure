package two_pointer_problem.march31;

public class CheckPalindromeFormation {

    public boolean checkPalindromeFormation(String a, String b) {

        return check(a, b) || check(b, a);
    }

    private boolean check(String a, String b) {

        int i = 0, j = a.length() - 1;

        // Move while matching
        while (i < j && a.charAt(i) == b.charAt(j)) {
            i++;
            j--;
        }

        // Check remaining substring
        return isPalindrome(a, i, j) || isPalindrome(b, i, j);
    }


    private boolean isPalindrome(String s, int i, int j) {

        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        CheckPalindromeFormation sol = new CheckPalindromeFormation();
        String a1 = "ulacfd";
        String b1 = "jizalu";

        String a2 = "xbdef";
        String b2 = "xecab";

        System.out.println("Output 1: " + sol.checkPalindromeFormation(a1, b1)); // true
        System.out.println("Output 2: " + sol.checkPalindromeFormation(a2, b2)); // false
    }
}
