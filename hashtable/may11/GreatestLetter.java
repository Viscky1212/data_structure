package hashtable.may11;

import java.util.HashSet;
import java.util.Set;
// sol 10
public class GreatestLetter {

    public String greatestLetter(String s){
        Set<Character> set = new HashSet<>();

        //strore all character
        for (char ch : s.toCharArray()){
            set.add(ch);
        }

        //check from z to a
        for (char ch = 'Z'; ch >= 'A'; ch--) {
            char low = Character.toLowerCase(ch);

            if (set.contains(ch) && set.contains(low)){
                return String.valueOf(ch);
            }
        }
        return "";
    }


    public static void main(String[] args) {

        GreatestLetter sol = new GreatestLetter();

        System.out.println(
                sol.greatestLetter("lEeTcOdE")
        );
        // E

        System.out.println(
                sol.greatestLetter("arRAzFif")
        );
        // R

        System.out.println(
                sol.greatestLetter("AbCdEfGhIjK")
        );
        // ""
    }
}
