package dp.dp2;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t){
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()){
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();

    }

    public static void main(String[] args) {
        IsSubsequence sol = new IsSubsequence();
        String s = "abc";
        String t = "ahbgdc";

        boolean result = sol.isSubsequence(s, t);

        System.out.println("Is subsequence: " + result);
    }
}
