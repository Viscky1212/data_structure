package hashtable.april30;

public class ShortestCompletingWord {

    public String shortestCompletingWord(String licensePlate, String[] words){
        int[] target = new int[26];
        //step 1: Build frequency for licensePlate
        for (char ch : licensePlate.toCharArray()){
            if (Character.isLetter(ch)){
                target[Character.toLowerCase(ch) - 'a']++;
            }
        }

        String result = null;

        //Step 2: check each word
        for (String word : words){
            if (isValid(word,target)){
                if (result == null || word.length() < result.length()){
                    result = word;
                }
            }
        }
        return result;
    }

    public boolean isValid(String word, int[] target){
        int[] freq = new int[26];
        for (char ch : word.toCharArray()){
            freq[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++){
            if (freq[i] < target[i]) return false;
        }
            return true;
    }

    public static void main(String[] args) {

        ShortestCompletingWord sol = new ShortestCompletingWord();

        String licensePlate1 = "1s3 PSt";
        String[] words1 = {"step","steps","stripe","stepple"};

        System.out.println(sol.shortestCompletingWord(licensePlate1, words1));
        // steps

        String licensePlate2 = "1s3 456";
        String[] words2 = {"looks","pest","stew","show"};

        System.out.println(sol.shortestCompletingWord(licensePlate2, words2));
        // pest
    }
}
