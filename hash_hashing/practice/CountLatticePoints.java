package hash_hashing.practice;

import java.util.*;

public class CountLatticePoints {

   static int countLatticePoints(int[][] circles){
       Set<String> set = new HashSet<>();

       //step  1 : process each circle
       for(int[] circle : circles){
           int x = circle[0];
           int y = circle[1];
           int r = circle[2];

           //step 2 : iterate bounding box
           for (int i = x - r; i <= x + r ; i++) {
               for (int j = y - r; j <= y + r ; j++) {
                   //check inside circle
                   int dx = i - x;
                   int dy = j - y;

                   if (dx * dx + dy * dy <= r * r){
                       set.add(i + " , " + j);
                   }

               }
           }

       }
       return set.size();
    }

    public static void main(String[] args) {

        int[][] circles1 = {{2,2,1}};
        System.out.println(countLatticePoints(circles1)); // 5

        int[][] circles2 = {{2,2,2},{3,4,1}};
        System.out.println(countLatticePoints(circles2)); // 16
    }
}
