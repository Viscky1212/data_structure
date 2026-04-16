package priorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MagicianAndChocolates {

    public int magicianAndChocolates(int A, ArrayList<Integer> B){
        long MOD = 1000000007;

        //Max Heap
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        //Insert all bags
        maxHeap.addAll(B);
        long total = 0;
        //Perform A operation
        while (A-- > 0){
            int chocolates = maxHeap.poll();
            total = (total + chocolates) % MOD;

            //magician refills bag
            maxHeap.add(chocolates / 2);
        }
        return  (int) total;
    }
    public static void main(String[] args) {
        MagicianAndChocolates obj = new MagicianAndChocolates();

        int A = 3;
        ArrayList<Integer> B = new ArrayList<>();

        B.add(6);
        B.add(5);

        System.out.println(obj.magicianAndChocolates(A, B));

    }
}
