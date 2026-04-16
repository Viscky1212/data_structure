package slidingwindow.april08;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumWhiteTiles {

    public static int maximumWhiteTiles(int[][] tiles, int carpetLen){
        //Step 1 : sort tiles by start
        Arrays.sort(tiles,(a,b) -> Integer.compare(a[0],b[0]));

        int n = tiles.length;

        int maxCovered = 0;
        int currentSum = 0;

        int j =0;
        for (int i = 0; i < n; i++) {
            int start = tiles[i][0];
            int carpetEnd = start + carpetLen - 1;

            //Expand window fully covered tiles
            while (j < n && tiles[j][1] <= carpetEnd){
                currentSum += tiles[j][1] - tiles[j][0] + 1;
                j++;
            }

            //partial coverage
            int partial = 0;
            if (j < n && tiles[j][0] <= carpetEnd){
                partial = carpetEnd- tiles[j][0] + 1;
            }
            maxCovered = Math.max(maxCovered, currentSum + partial);

            //shrink window (remove i-th tile)
            currentSum -= tiles[i][1] - tiles[i][0] + 1;
        }
        return maxCovered;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of tiles:");
        int n = sc.nextInt();

        int[][] tiles = new int[n][2];

        System.out.println("Enter tile ranges (li ri):");
        for (int i = 0; i < n; i++) {
            tiles[i][0] = sc.nextInt();
            tiles[i][1] = sc.nextInt();
        }

        System.out.println("Enter carpet length:");
        int carpetLen = sc.nextInt();

        int result = maximumWhiteTiles(tiles, carpetLen);

        System.out.println("Maximum white tiles covered: " + result);

        sc.close();
    }
}
