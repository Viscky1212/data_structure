package two_pointer_problem;

public class ReverseWords {

    public static String reverseWords(String s){
        //remove leading and trailing space
        s = s.trim();

        //Split words by one or more space
        String[] words = s.split("\\s+");

        StringBuilder result = new StringBuilder();

        // Traverse words in reverse order
        for (int i = words.length - 1; i >= 0 ; i--) {
            result.append(words[i]);

            if (i != 0){
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "  hello   world   ";

        System.out.println(" Reverse words  :  -> " + reverseWords(s));
    }
}
