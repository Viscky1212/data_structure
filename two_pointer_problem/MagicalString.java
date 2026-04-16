package two_pointer_problem;

import java.util.ArrayList;
import java.util.Arrays;

public class MagicalString {

    public static int magicalString(int n){
        if (n <= 0) return 0;
        if (n <= 3) return 1;

        int[] magic = new int[n];

        magic[0] = 1;
        magic[1] = 2;
        magic[2] = 2;

        int head = 2;
        int tail = 3;
        int num = 1;
        int countOnes = 1;

        while (tail < n){
            for (int i = 0; i < magic[head] && tail < n; i++) {
                magic[tail] = num;
                if (num == 1) countOnes++;
                tail++;
            }
            num = (num == 1) ? 2 : 1;
            head++;
        }

        // Print magical string
        System.out.print("Magical String: ");
        for(int i = 0; i < n; i++){
            System.out.print(magic[i]);
        }
        System.out.println();

        return countOnes;
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println(magicalString(n));
    }
}
