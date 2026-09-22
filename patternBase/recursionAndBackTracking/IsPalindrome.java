package patternBase.recursionAndBackTracking;

public class IsPalindrome {

    public static void main(String[] args) {
        String str = "racecar";
        boolean result = isPalindrome(str, 0, str.length() - 1);
        System.out.println("Is the string \"" + str + "\" a palindrome? " + result);
    }

    public static boolean isPalindrome(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindrome(str, start + 1, end - 1);
    }
}
