package patternBase.recursionAndBackTracking.sheet;

public class IsPalindrome {

    public boolean isPalindrome(String s) {
        return isPalindromeHelper(s, 0, s.length() - 1);
    }

    private boolean isPalindromeHelper(String s, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }
        return isPalindromeHelper(s, start + 1, end - 1);
    }

//    public String isPalindrome(String s) {
//        // Implementation for checking palindrome
//        if (validate(s)) {
//            return "Yes";
//        } else {
//            return "No";
//        }
//    }
//
//    public boolean validate(String s) {
//        // Implementation for validating palindrome
//        //base case
//        if (s.length() <= 1) {
//            return true;
//        }
//        //check first and last character
//        if (s.charAt(0) != s.charAt(s.length() - 1)) {
//            return false;
//        }
//        //recursive call
//        return validate(s.substring(1, s.length() - 1));
//
//    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        String s = "racecar"; // Change this value to test different strings
       // String result = isPalindrome.isPalindrome(s);
        boolean result = isPalindrome.isPalindrome(s);
        System.out.println("Is \"" + s + "\" a palindrome? " + result);
        System.out.println("Substring: " + s.substring(1, s.length() - 1));
    }
}
