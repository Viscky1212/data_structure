package two_pointer_problem;

public class PrefixCheckApp {


    public static void main(String[] args) {
        PrefixCheckApp solution = new PrefixCheckApp();

        String s1 = "i love eating burger";
        String search1 = "burg";

        String s2 = "this problem is an easy problem";
        String search2 = "pro";

        String s3 = "i am tired";
        String search3 = "you";

        System.out.println(solution.isPrefixOfWord(s1, search1)); // 4
        System.out.println(solution.isPrefixOfWord(s2, search2)); // 2
        System.out.println(solution.isPrefixOfWord(s3, search3)); // -1
    }

    public int isPrefixOfWord(String sentence, String searchWords ){
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWords)){
                return i + 1; //1 - based index
            }
        }
        return -1;
    }
}
