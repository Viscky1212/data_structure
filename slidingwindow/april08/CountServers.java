package slidingwindow.april08;

import java.net.Inet4Address;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountServers {
    public static int[] countServers(int n, int[][] logs, int x, int[] queries){
        //sort log by time
        Arrays.sort(logs,(a, b) -> a[1] - b [1]);

        int q = queries.length;

        //store queries with index
        int[][] queryArr = new int[q][2];
        for (int i = 0; i < q; i++) {
            queryArr[i][0] = queries[i];
            queryArr[i][1] = i;
        }

        Arrays.sort(queryArr,(a,b) -> a[0] - b[0]);

        int[] result = new int[q];

        Map<Integer, Integer> freq =   new HashMap<>();
        int left = 0, right = 0;

        for (int i = 0; i < q; i++) {
            int queryTime = queryArr[i][0];
            int startTime = queryTime - x;

            //Add logs within[<= queryTime]
            while (right < logs.length && logs[right][1] <= queryTime){
                int server = logs[right][0];
                freq.put(server,freq.getOrDefault(server,0) + 1);
                right++;
            }
            //remove lof < start time
            while (left < logs.length && logs[left][1] < startTime){
                int server = logs[left][0];

                freq.put(server, freq.get(server) - 1);

                if (freq.get(server) == 0){
                    freq.remove(server);
                }
                left++;
            }
            //Active server = freq.size()
            int active = freq.size();
            result[queryArr[i][1]] = n - active;
        }
        return result;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of servers:");
        int n = sc.nextInt();

        System.out.println("Enter number of logs:");
        int m = sc.nextInt();

        int[][] logs = new int[m][2];

        System.out.println("Enter logs (server_id time):");
        for (int i = 0; i < m; i++) {
            logs[i][0] = sc.nextInt();
            logs[i][1] = sc.nextInt();
        }

        System.out.println("Enter x:");
        int x = sc.nextInt();

        System.out.println("Enter number of queries:");
        int q = sc.nextInt();

        int[] queries = new int[q];

        System.out.println("Enter queries:");
        for (int i = 0; i < q; i++) {
            queries[i] = sc.nextInt();
        }

        int[] result = countServers(n, logs, x, queries);

        System.out.println("Result:");
        for (int val : result) {
            System.out.print(val + " ");
        }

        sc.close();
    }
}
