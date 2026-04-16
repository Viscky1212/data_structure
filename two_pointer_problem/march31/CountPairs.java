package two_pointer_problem.march31;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountPairs {

    public int[] countPairs(int n, int[][] edges, int[] queries) {

        int[] degree = new int[n + 1];

        // Step 1: Count degree
        Map<Long, Integer> map = new HashMap<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1];

            degree[u]++;
            degree[v]++;

            int a = Math.min(u, v);
            int b = Math.max(u, v);

            long key = (long)a * 100000 + b;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        // Step 2: Sort degrees
        int[] sorted = degree.clone();
        Arrays.sort(sorted);

        int[] result = new int[queries.length];

        // Step 3: Process each query
        for (int qi = 0; qi < queries.length; qi++) {

            int q = queries[qi];
            int count = 0;

            int left = 1, right = n;

            // Two pointer
            while (left < right) {
                if (sorted[left] + sorted[right] > q) {
                    count += (right - left);
                    right--;
                } else {
                    left++;
                }
            }

            // Step 4: Fix overcount
            for (Map.Entry<Long, Integer> entry : map.entrySet()) {

                long key = entry.getKey();
                int shared = entry.getValue();

                int u = (int)(key / 100000);
                int v = (int)(key % 100000);

                if (degree[u] + degree[v] > q &&
                        degree[u] + degree[v] - shared <= q) {
                    count--;
                }
            }

            result[qi] = count;
        }

        return result;
    }

    public static void main(String[] args) {
        CountPairs sol = new CountPairs();
        int n = 4;
        int[][] edges = {
                {1,2},{2,4},{1,3},{2,3},{2,1}
        };
        int[] queries = {2,3};

        System.out.println(Arrays.toString(sol.countPairs(n, edges, queries)));
        // Output: [6,5]
    }

}
