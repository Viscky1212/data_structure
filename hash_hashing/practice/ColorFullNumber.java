package hash_hashing.practice;

import java.util.*;

public class ColorFullNumber {

    public static int colorFullNumber(int A){
        //step 1 : convert number to digits
        List<Integer> digits = new ArrayList<>();

        while (A > 0){
            digits.add(0, A % 10); //maintain order
            A /= 10;
        }

        //Step 2 : use set to track product
        Set<Integer> set = new HashSet<>();
        int n  = digits.size();

        //step 3 : generates all subarrays
        for(int i = 0; i < n; i++){
            int product = 1;
            for(int j = i; j < n; j++){
                product *= digits.get(j);

                //check duplicate
                if(set.contains(product)){
                    return  0; //not colorful
                }
                set.add(product);
            }
        }
        return  1; //colorful
    }

    public static void main(String[] args) {

        int A1= 23;
        System.out.println("Is colorful : " + colorFullNumber(A1));


        int A2 = 541;
        System.out.println("Is Colorful: " + colorFullNumber(A2));

    }
}
