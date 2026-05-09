package hashtable.may09;

//problem 3:
public class CountConsistentStrings {

    public int countConsistentStrings(String allowed, String[] words){
        boolean[] allowedSet = new boolean[26];

        //Step 1 mark allowed characters
        for (char ch : allowed.toCharArray()){
            allowedSet[ch - 'a'] = true;
        }

        int count = 0;

        //Step 2 : check each word
        for (String word : words){
            boolean valid = true;

            for (char ch : word.toCharArray()){
                if (!allowedSet[ch - 'a']){
                    valid = false;
                    break;
                }
            }
            if (valid) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        CountConsistentStrings sol = new CountConsistentStrings();

        System.out.println(sol.countConsistentStrings(
                "ab", new String[]{"ad","bd","aaab","baa","badab"}
        )); // 2

        System.out.println(sol.countConsistentStrings(
                "abc", new String[]{"a","b","c","ab","ac","bc","abc"}
        )); // 7

        System.out.println(sol.countConsistentStrings(
                "cad", new String[]{"cc","acd","b","ba","bac","bad","ac","d"}
        )); // 4
    }
}
