package two_pointer_problem;

public class PrefixStringApp {

    public boolean isPrefixString(String s, String[] words){
        int i = 0; //pointer for s
        for (String word : words){
            for (int j = 0; j < word.length(); j++) {
                //if mismatch or out of bound
                if(i >= s.length() || s.charAt(i) != word.charAt(j)){
                    return false;
                }
                i++;
            }
            //if fully matched
            if (i == s.length()){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        PrefixStringApp solution = new PrefixStringApp();
        String s1 = "iloveleetcode";
        String[] words1 = {"i", "love", "leetcode", "apples"};

        String s2 = "iloveleetcode";
        String[] words2 = {"apples", "i", "love", "leetcode"};

        System.out.println(solution.isPrefixString(s1, words1)); // true
        System.out.println(solution.isPrefixString(s2, words2)); // false
    }
}
