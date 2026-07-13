package patternBase.prefixSum.hard;

import java.util.TreeSet;

public class TreeSetPractice {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(5);
        set.add(2);
        set.add(8);
        System.out.println(set.ceiling(4)); // returns 5
        System.out.println(set.ceiling(10)); // returns null
        System.out.println(set.floor(6)); // returns 5
        System.out.println(set.floor(1)); // returns null
        System.out.println(set);
    }
}
