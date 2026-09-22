package patternBase.recursionAndBackTracking;

public class RemoveCharacter {

    public static void main(String[] args) {
        String str = "abacaeara";
        char ch = 'a';
        String result = removeCharacter(str,0, ch);
        System.out.println("Original String: " + str);
        System.out.println("String after removing '" + ch + "': " + result);
    }

    public static String removeCharacter(String str,int i,  char target) {
       if (i == str.length()) {
            return "";
        }
        String ans = removeCharacter(str, i + 1, target);
        if (str.charAt(i) == target) {
            return ans;
        } else {
            return str.charAt(i) + ans;
        }
    }
}
