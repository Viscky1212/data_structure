package hashtable.may03;

public class IsAlienSorted {

    public boolean isAlienSorted(String[] words, String order){
        int[] orderMap = new int[26];

        //Step 1 : build order map
        for (int i = 0; i < order.length(); i++) {
            orderMap[order.charAt(i) - 'a'] = i;
        }

        //step 2 : compare adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            if (!isSorted(words[i],words[i + 1],orderMap )){
                return false;
            }
        }
        return true;
    }

    private  boolean isSorted(String w1, String w2, int[] orederMap){
        int len = Math.min(w1.length(),w2.length());

        for (int i = 0; i < len; i++) {
            char c1 = w1.charAt(i);
            char c2 = w2.charAt(i);

            if (c1 != c2){
                return orederMap[c1 - 'a'] < orederMap[c2 - 'a'];
            }
        }

        return w1.length() <= w2.length();
    }

    public static void main(String[] args) {

        IsAlienSorted sol = new IsAlienSorted();

        String[] words1 = {"hello","leetcode"};
        String order1 = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(sol.isAlienSorted(words1, order1)); // true

        String[] words2 = {"word","world","row"};
        String order2 = "worldabcefghijkmnpqstuvxyz";
        System.out.println(sol.isAlienSorted(words2, order2)); // false

        String[] words3 = {"apple","app"};
        String order3 = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(sol.isAlienSorted(words3, order3)); // false
    }

}
