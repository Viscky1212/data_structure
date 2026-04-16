package stringbasic;

import java.util.Arrays;

public class StringAnagram {

    public static void main(String[] args) {
        //One character of String present in another String

        String s1= "bacd";
        String s2 = "abcd";

        if (s1.length() != s2.length()){
            System.out.println("given String is not Anagram !!");
            return;
        }

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        boolean equals = Arrays.equals(a, b);
        if (equals){
            System.out.println("s1 and s2 are Anagram.");
        } else {
            System.out.println("Given both String is not Anagram.");
        }

    }
}
