package slidingwindow.april08;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinimumCardPickup {

    public static int minimumCardPickup(int[] cards){
        Map<Integer, Integer> map = new HashMap<>();

        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < cards.length; i++) {

            //if duplicate found
            if (map.containsKey(cards[i])){
                int prevIndex = map.get(cards[i]);
                int length = i - prevIndex + 1;

                minLength = Math.min(minLength, length);
            }

            //update last seen index
            map.put(cards[i], i);
        }
        return (minLength == Integer.MAX_VALUE) ? -1 : minLength;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array size:");
        int n = sc.nextInt();

        int[] cards = new int[n];

        System.out.println("Enter card values:");
        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }

        int result = minimumCardPickup(cards);

        System.out.println("Minimum consecutive cards: " + result);

        sc.close();
    }
}
