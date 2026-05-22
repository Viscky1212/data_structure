package sorting.may20;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SplitNum {

    public int splitNum(int num){

        List<Integer> digits = new ArrayList<>();

        while (num > 0){
            digits.add(num % 10);
            num /= 10;
        }

        Collections.sort(digits);

        int num1 = 0;
        int num2 = 0;

        for (int i = 0; i < digits.size(); i++) {
           if (i % 2 == 0){
               num1 = num1 * 10 + digits.get(i);
           } else {
               num2 = num2 * 10 + digits.get(i);
           }
        }
        return num1 + num2;
    }

    public static void main(String[] args) {
        SplitNum sol = new SplitNum();
        System.out.println(sol.splitNum(4325));
        // Output: 59

        System.out.println(sol.splitNum(687));
        // Output: 75

        System.out.println(sol.splitNum(1002));
        // Output: 3
        // digits: [0,0,1,2] => num1 = 1, num2 = 2
    }
}
