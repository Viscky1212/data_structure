package two_pointer_problem;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n){
        Set<Integer> seen = new HashSet<>();

        while (n != 1){
            if (seen.contains(n)){
                return false;
            }
            seen.add(n);
           n =  getNext(n);

        }

        return true;

    }
    //helper function : sum of squares of digits
    private int getNext(int n){
        int sum = 0;
        while (n > 0){
            int digit =  n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        HappyNumber solution = new HappyNumber();
        int n1 = 19;
        int n2 = 2;
        System.out.println("Is " + n1 + " a happy number");

        System.out.println("Is " + n2 + " a happy number");
    }

}
