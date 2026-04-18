package stringMatching;

public class SubStringMatchPattern {

    public boolean hasMatch(String s, String p){
        int startIndex = p.indexOf('*');

        String prefix = p.substring(0, startIndex);
        String suffix = p.substring(startIndex + 1);

        for (int i = 0; i <= s.length() - prefix.length() ; i++) {
            if (s.startsWith(prefix,i)){
                int suffixStart = i + prefix.length();

                for (int j = suffixStart; j <= s.length() - suffix.length() ; j++) {
                    if (s.startsWith(suffix,j)) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SubStringMatchPattern sol = new SubStringMatchPattern();
        System.out.println(sol.hasMatch("leetcode", "ee*e")); // true
        System.out.println(sol.hasMatch("car", "c*v"));       // false
        System.out.println(sol.hasMatch("luck", "u*"));
    }
}
