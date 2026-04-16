package hash_hashing.practice;

import  java.util.*;
public class ShortestSequence {

    public int shortestSequence(int[] A, int k){
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int num : A){
            set.add(num);

            //id we have all k numbers
            if(set.size() == k){
                count++;
                set.clear(); //reset for next round
            }
        }
        //Answer is count + 1
        return count + 1;
    }
    public static void main(String[] args) {
        ShortestSequence sol = new ShortestSequence();

        int[] rolls1 = {4,2,1,2,3,3,2,4,1};
        int k1 = 4;
        System.out.println("Output: " + sol.shortestSequence(rolls1, k1)); // 3

        int[] rolls2 = {1,1,2,2};
        int k2 = 2;
        System.out.println("Output: " + sol.shortestSequence(rolls2, k2)); // 2

    }
}
