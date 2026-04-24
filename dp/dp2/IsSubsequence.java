package dp.dp2;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t){
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()){
            System.out.println("ith value : "+i);
            System.out.println("J value : " + j);
            if (s.charAt(i) == t.charAt(j)) {
                System.out.println("if  condition matched ");
                i++;
                System.out.println("i value after increment :"+i);
            }
           else {
                System.out.println("else  condition matched ");
                j++;
                System.out.println("j value after increment : " + j) ;
            }
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
