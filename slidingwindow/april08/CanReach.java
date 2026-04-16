package slidingwindow.april08;

import java.util.Scanner;

public class CanReach {

    public static boolean canReach(String s, int minJump, int maxJump){
        int n = s.length();

        boolean[] reachable = new boolean[n];
        reachable[0] = true;
        int reachableCount = 0;//number of reachable indices in window

        for (int i = 1; i < n; i++) {
            //Add new index into window
            if (i - minJump >= 0 && reachable[i - minJump]){
                reachableCount++;
            }

            //Remove index going out of window
            if (i - maxJump - 1 >= 0 &&  reachable[i - maxJump - 1]){
                reachableCount--;
            }

            // Check if current index is reachable
            if (s.charAt(i) == '0' && reachableCount > 0) {
                reachable[i] = true;
            }
        }
        return reachable[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter binary string:");
        String s = sc.nextLine();

        System.out.println("Enter minJump:");
        int minJump = sc.nextInt();

        System.out.println("Enter maxJump:");
        int maxJump = sc.nextInt();

        boolean result = canReach(s, minJump, maxJump);

        System.out.println("Can reach last index: " + result);

        sc.close();
    }
}
