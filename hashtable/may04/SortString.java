package hashtable.may04;

public class SortString {

    public String sortString(String s){
        int[]  freq = new int[26];

        //step 1 : count frequency
        for (char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }

        StringBuilder result = new StringBuilder();

        int n = s.length();

        //step 2 : build result
        while (result.length() < n) {
            //increasing (a -> z)

            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) {
                    result.append((char) (i + 'a'));
                    freq[i]--;
                }
            }


            //decressing (z -> a)
            for (int i = 25; i >= 0; i--) {
                if (freq[i] > 0) {
                    result.append((char) (i + 'a'));
                    freq[i]--;
                }
            }
        }
        return  result.toString();

    }

    public static void main(String[] args) {
        SortString sol = new SortString();

        System.out.println(sol.sortString("aaaabbbbcccc"));
        // abccbaabccba

        System.out.println(sol.sortString("rat"));
    }
}
