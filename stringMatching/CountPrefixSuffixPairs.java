package stringMatching;

public class CountPrefixSuffixPairs {

    public int countPrefixSuffixPairs(String[] words){
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j =  i + 1; j < words.length; j++) {
                if (isPrefix(words[i], words[j]));
            count++;
            }
        }
        return count;
    }

    private  boolean isPrefix(String str1 , String str2){
        return str2.startsWith(str1) && str2.endsWith(str1);
    }

    public static void main(String[] args) {
        CountPrefixSuffixPairs sol = new CountPrefixSuffixPairs();
        String[] words1 = {"a", "aba", "ababa", "aa"};
        System.out.println(sol.countPrefixSuffixPairs(words1)); // 4

        String[] words2 = {"pa", "papa", "ma", "mama"};
        System.out.println(sol.countPrefixSuffixPairs(words2)); // 2

        String[] words3 = {"abab", "ab"};
        System.out.println(sol.countPrefixSuffixPairs(words3));
    }
}
