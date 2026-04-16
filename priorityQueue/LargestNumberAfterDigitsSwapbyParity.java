package priorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class LargestNumberAfterDigitsSwapbyParity {
    public  static  int largestInteger(int num){
        PriorityQueue<Integer> oddHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> evenHeap = new PriorityQueue<>(Collections.reverseOrder());

        String s = String.valueOf(num);

        //step 1 : seperate digits into odd and even
        for (char c : s.toCharArray()){

            int digit = c - '0';
            if (digit % 2 == 0 ){
                evenHeap.add(digit);
            } else {
                oddHeap.add(digit);
            }
        }
        //step 2 : build largest number
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()){
            int digit = c - '0';
            if (digit % 2 == 0){
                result.append(evenHeap.poll());
            } else {
                result.append(oddHeap.poll());
            }
        }
        return Integer.parseInt(result.toString());
    }
    public static void main(String[] args) {
int num = 12345;
        System.out.println(largestInteger(num));
    }
}
