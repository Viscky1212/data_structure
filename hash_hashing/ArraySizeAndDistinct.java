package hash_hashing;

import java.util.ArrayList;
import java.util.HashSet;

public class ArraySizeAndDistinct {
    public static void main(String[] args) {
        int[] a = {1,2,2,3,3,3,1};
        System.out.println(counAnInt(a));

    }

    static String counAnInt(int[] a){
        HashSet<Integer> set = new HashSet();
        System.out.println(set.hashCode());

        for(int i : a){
            set.add(i);
        }
        System.out.println(set);

        return "Please find the value of Set  : " + set.toString();
    }
}
