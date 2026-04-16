package two_pointer_problem.aprill01;

public class ExpressiveWords {

    public int expressiveWords(String s, String[] words){
        int count = 0;
        for (String word : words){
            if (isStratchy(s, word)) count++;
        }
        return count;
    }

    public boolean isStratchy(String s, String word){
        int i = 0, j = 0;
        int n = s.length(), m = word.length();

        while (i < n && j < m){
            if (s.charAt(i) != word.charAt(j)) return false;

            int startS = i;
            while (i < n && s.charAt(i) == s.charAt(startS)) i++;
            int lenS = i - startS;

            int startW = j;
            while (j < m && word.charAt(j) == word.charAt(startW)) j++;
            int lenW = j - startW;

            if (lenW > lenS || lenS < 3 && lenS != lenW){
                return false;
            }
        }
        return i == n && j == m;
    }

    public static void main(String[] args) {
        ExpressiveWords sol = new ExpressiveWords();
        // Example 1
        String s1 = "heeellooo";
        String[] words1 = {"hello", "hi", "helo"};
        System.out.println("Example 1 Output: " + sol.expressiveWords(s1, words1));
        // Expected: 1 ("hello" is stretchy, "hi" doesn't match, "helo" lacks an 'l' group of 3+)

        // Example 2
        String s2 = "zzzzzyyyyy";
        String[] words2 = {"zzyy", "zy", "zyy"};
        System.out.println("Example 2 Output: " + sol.expressiveWords(s2, words2));
        // Expected: 3 (All groups in S are >= 3, and words have same chars in order)
    }

}
