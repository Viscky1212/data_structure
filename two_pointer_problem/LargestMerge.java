package two_pointer_problem;

public class LargestMerge {

    public String largestMerge(String word1, String word2){
        StringBuilder merge = new StringBuilder();
        int i = 0, j= 0;
        int n = word1.length(),m = word2.length();

        //Traverse String
        while (i < n && j < m){

            // Compare remaining substrings
            if (isGreater(word1, i, word2, j)) {
                merge.append(word1.charAt(i));
                i++;
            } else {
                merge.append(word2.charAt(j));
                j++;
            }
        }

        //Append remaining character
        while (i < n){
            merge.append(word1.charAt(i++));
        }
        while (j < m){
            merge.append(word2.charAt(j++));
        }
        return merge.toString();

    }

    public boolean isGreater(String word1,int i, String word2 , int j){
        int n = word1.length();
        int m = word2.length();

        //compare character by character
        while (i < n && j < m){
            if (word1.charAt(i) > word2.charAt(j)) return true;
            if (word1.charAt(i) < word2.charAt(j)) return false;
            i++;
            j++;
        }

        //if equal till one end -> longer one is greater
        return (i != n);
    }

   public static void main(String[] args) {

        LargestMerge solution = new LargestMerge();
        // Test Case 1
        String word1 = "cabaa";
        String word2 = "bcaaa";

        String result = solution.largestMerge(word1, word2);

        System.out.println("Input:");
        System.out.println("word1 = " + word1);
        System.out.println("word2 = " + word2);

        System.out.println("\nOutput:");
        System.out.println(result);

        // Test Case 2
        String word3 = "abcabc";
        String word4 = "abdcaba";

        System.out.println("\n-------------------------");

        System.out.println("Input:");
        System.out.println("word1 = " + word3);
        System.out.println("word2 = " + word4);

        System.out.println("\nOutput:");
        System.out.println(solution.largestMerge(word3, word4));
    }
}
