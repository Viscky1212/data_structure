package two_pointer_problem;

public class ValidPalindrome {

    public boolean validPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;
         while(left < right){

             if (s.charAt(left) != s.charAt(right)){
                 // try skipping one char

                 return isPalindrome(s, left + 1 , right) || isPalindrome(s,left, right -1);
             }
             left++;
             right--;
         }
         return true;
    }
    //helper method to check if it is palidrome
    private boolean isPalindrome(String s, int left, int right){
        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome solution = new ValidPalindrome();
        String s1 = "aba";
        String s2 = "abca";
        String s3 = "abc";

        System.out.println(s1 + " -> " + solution.validPalindrome(s1));
        System.out.println(s2 + " -> " + solution.validPalindrome(s2));
        System.out.println(s3 + " -> " + solution.validPalindrome(s3));
    }


}
