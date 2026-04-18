package stringMatching;

import java.util.ArrayList;
import java.util.List;

public class StringMatching2 {

    public List<String> stringMatching(String[] words){
        List<String> res = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])){
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        StringMatching2 sol = new StringMatching2();
        String[] words1 = {"mass", "as", "hero", "superhero"};
        System.out.println(sol.stringMatching(words1)); // [as, hero]

        String[] words2 = {"leetcode", "et", "code"};
        System.out.println(sol.stringMatching(words2)); // [et, code]

        String[] words3 = {"blue", "green", "bu"};
        System.out.println(sol.stringMatching(words3)); // []
    }
}
