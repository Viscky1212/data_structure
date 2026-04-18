package stringMatching;

public class RotateString {

    public boolean rotateString(String s, String goal){
        if (s.length() != goal.length()) return false;

        String doubleed = s + s;
        return doubleed.contains(goal);
    }

    public static void main(String[] args) {
        RotateString sol = new RotateString();
        String s1 = "abcde";
        String goal1 = "cdeab";
        System.out.println("Example 1 Output: " + sol.rotateString(s1, goal1)); // true

        String s2 = "abcde";
        String goal2 = "abced";
        System.out.println("Example 2 Output: " + sol.rotateString(s2, goal2)); // false
    }
}
