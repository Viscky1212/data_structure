package hashtable.may03;

import java.util.HashMap;
import java.util.Map;

public class HasGroupsSizeX {

    public boolean hasGroupsSizeX(int[] deck){
        Map<Integer,Integer> freq = new HashMap<>();

        //step 1 : count frequency
        for (int num : deck){
            freq.put(num,freq.getOrDefault(num,0) + 1);
        }

        //step 2 : compute GCD of frequncies
        int gcd = 0;

        for (int count : freq.values()){
            gcd = gcd(gcd,count);
        }
        return gcd >= 2;
    }

    private int gcd(int a , int b){
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {

        HasGroupsSizeX sol = new HasGroupsSizeX();

        int[] d1 = {1,2,3,4,4,3,2,1};
        System.out.println(sol.hasGroupsSizeX(d1)); // true

        int[] d2 = {1,1,1,2,2,2,3,3};
        System.out.println(sol.hasGroupsSizeX(d2)); // false
    }
}
