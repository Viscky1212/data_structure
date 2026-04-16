package two_pointer_problem;

public class RemovePalindromeSubApp {

    public static void main(String[] args) {
        RemovePalindromeSubApp solution = new RemovePalindromeSubApp();
        String s1 = "ababa";
        String s2 = "abb";
        String s3 = "baabb";

        System.out.println(s1 + " -> " + solution.removePalindromeSub(s1));
        System.out.println(s2 + " -> " + solution.removePalindromeSub(s2));
        System.out.println(s3 + " -> " + solution.removePalindromeSub(s3));
    }

    public int removePalindromeSub(String s) {

        //Edge case : emptyb string
        if (s.length() == 0) return  0;

        //check if palindrome
        if (isPalindrome(s)){
            return 1;
        }

        //otherwise remove 'a' and 'b' separately
        return 2;
    }

    //helper function to check paindrome
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
