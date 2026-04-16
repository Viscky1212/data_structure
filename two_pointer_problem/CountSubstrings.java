package two_pointer_problem;

public class CountSubstrings {

    public  static int countSubstrings(String s){
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += expand(s , i , i); //odd length
            count += expand(s, i, i + 1); //even length
        }
        return count;
    }
    public static  int expand(String s, int left , int right){
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }
    public static void main(String[] args) {
        String s = "aaa";

        int result = countSubstrings(s);

        System.out.println("Total Palindromic Substrings: " + result);
    }

}
