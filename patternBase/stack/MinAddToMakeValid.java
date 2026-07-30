package patternBase.stack;

import akhil_dsa.basic_pattern.ArrasyReArrange;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MinAddToMakeValid {

    public static int minAddToMakeValid(String s) {
        int open = 0;
        int close = 0;



        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    close++;
                }
            }
        }

        return open + close;
    }

    public static void main(String[] args) {
        String s = "())";
        System.out.println(minAddToMakeValid(s)); // Output: 1
        System.out.println(Arrays.toString(s.toCharArray()));

        String s1 = "Vikrant Saini";
        System.out.println(Arrays.toString(s1.toCharArray()));

        //using stream
        String s2 = "Vikrant Saini";
        System.out.println(Arrays.toString(s2.chars().mapToObj(c -> (char) c).toArray(Character[]::new)));


        System.out.println("Valid"+Arrays.toString(IntStream.range(0, s2.length()).mapToObj(s2::charAt).toArray(Character[]::new)));


    }
}
