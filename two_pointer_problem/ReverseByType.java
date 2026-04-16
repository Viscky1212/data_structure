package two_pointer_problem;
import java.util.*;

public class ReverseByType {

    public String reverseByType(String s) {
        List<Character> letters = new ArrayList<>();
        List<Character> special = new ArrayList<>();

        //step 1 : to separate character
        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                letters.add(ch);
            } else {
                special.add(ch);
            }
        }

        //Step 2 : Reverse both lists
        Collections.reverse(letters);
        Collections.reverse(special);

        //Special 3 : Reconstruct string
        StringBuilder res = new StringBuilder();

        int i = 0;  //pointer for letter
        int j = 0; // pointer for specials

        for (char ch : s.toCharArray()){
            if (Character.isLowerCase(ch)){
                res.append(letters.get(i++));
            } else{
                res.append(special.get(j++));
            }
        }
        return  res.toString();
    }

    public static void main(String[] args) {
        ReverseByType sol = new ReverseByType();

        String s1 = ")ebc#da@f(";
        String s2 = "z";
        String s3 = "!@#$%^&*()";

        System.out.println("Output 1: " + sol.reverseByType(s1)); // (fad@cb#e)
        System.out.println("Output 2: " + sol.reverseByType(s2)); // z
        System.out.println("Output 3: " + sol.reverseByType(s3)); // )(*&^%$#@!


    }
}
