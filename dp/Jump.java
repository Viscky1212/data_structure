package dp;

public class Jump {


    public int jump(int[] A) {

        int n = A.length;

        // Edge case
        if (n == 1) return 0;

        int jumps = 0;
        int farthest = 0;
        int end = 0;

        for (int i = 0; i < n - 1; i++) {

            // Update farthest reachable index
            farthest = Math.max(farthest, i + A[i]);

            // When we reach the boundary of current jump
            if (i == end) {
                jumps++;
                end = farthest;
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        Jump sol = new Jump();
        System.out.println(sol.jump(new int[]{2,3,1,1,4})); // 2
        System.out.println(sol.jump(new int[]{2,3,0,1,4})); // 2
    }
}
