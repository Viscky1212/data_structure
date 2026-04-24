package binarySearch;

import java.util.Arrays;

public class KWeakestRows {

    public int[] kWeakestRows(int[][] mat, int k){
        int m = mat.length;
        int[][] soldierCount = new int[m][2];

        for (int i = 0; i < m; i++) {
            soldierCount[i][0] = countSoldiers(mat[i]);
            soldierCount[i][1] = i;
        }

        Arrays.sort(soldierCount,(a,b) -> a[0] != b[0] ? a[0] -b[0] : a[1] - b[1]);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = soldierCount[i][1];
        }
        return result;

    }

  public int countSoldiers(int[] row){
      int lo = 0, hi = row.length;

      while (lo < hi){
          int mid = lo + (hi - lo) / 2;
          if (row[mid] == 1) lo = mid + 1;
          else hi = mid;
      }
      return lo;
  }

    public static void main(String[] args) {
        KWeakestRows sol =new KWeakestRows();
        int[][] mat1 = {
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}
        };
        System.out.println(Arrays.toString(sol.kWeakestRows(mat1, 3))); // [2,0,3]

        int[][] mat2 = {
                {1,0,0,0},
                {1,1,1,1},
                {1,0,0,0},
                {1,0,0,0}
        };
        System.out.println(Arrays.toString(sol.kWeakestRows(mat2, 2))); // [0,2]
    }
}
