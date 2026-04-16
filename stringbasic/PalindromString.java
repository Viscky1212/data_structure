package stringbasic;

public class PalindromString {
    public static void main(String[] args) {
        String s= "madam";

        String s1 = "";

        for (int i = s.length() -1 ; i >= 0; i--){
            s1 = s1 + s.charAt(i);
        }
        if (s1.equals(s)){
            System.out.println("is palindrome");
        } else {
            System.out.println("not palindrome");
        }
    }
}
