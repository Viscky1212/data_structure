package two_pointer_problem.march31;

public class ReverseWords {

    public String reverseWords(String s){
        String[] words = s.split(" ");

        int targetVowelCount = countVowel(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (countVowel(words[i]) == targetVowelCount){
                words[i] = reverse(words[i]);
            }
        }
        return String.join(" ",words);
    }

    public int countVowel(String word){
        int count = 0;
        for (char c : word.toCharArray()){
            if (isVowel(c)) count++;
        }
        return count;
    }

    public boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private String reverse(String word) {
        return new StringBuilder(word).reverse().toString();
    }

    public static void main(String[] args) {
        ReverseWords sol = new ReverseWords();
        String s1 = "cat and mice";
        String s2 = "book is nice";
        String s3 = "banana healthy";

        System.out.println(sol.reverseWords(s1)); // cat dna mice
        System.out.println(sol.reverseWords(s2)); // book is ecin
        System.out.println(sol.reverseWords(s3)); // banana healthy
    }

}
