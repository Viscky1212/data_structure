package hashtable.may01;

public class CountCharacters {

    public int countCharacters(String[] words, String chars){
        int[] charsFreq = new int[26];

        //count chars frequency
        for (char ch : chars.toCharArray()){
            charsFreq[ch - 'a']++;
        }

        int total = 0;

        //Step 2 : check each word
        for (String word : words){
            if (canFrom(word,charsFreq)){
                total += word.length();
            }
        }
        return total;
    }

    public boolean canFrom(String word , int[] charsFreq){
        int[] freq = new int[26];
        for (char ch : word.toCharArray()){
            freq[ch - 'a']++;

            if (freq[ch - 'a'] > charsFreq[ch - 'a']) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CountCharacters sol = new CountCharacters();

        String[] words1 = {"cat","bt","hat","tree"};
        String chars1 = "atach";

        System.out.println(sol.countCharacters(words1, chars1)); // 6

        String[] words2 = {"hello","world","leetcode"};
        String chars2 = "welldonehoneyr";

        System.out.println(sol.countCharacters(words2, chars2)); // 10
    }
}
