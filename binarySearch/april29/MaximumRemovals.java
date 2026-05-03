package binarySearch.april29;

public class MaximumRemovals {

    public int maximumRemovals(String s, String p, int[] removable) {

        int low = 0, high = removable.length;
        int ans = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isValid(s, p, removable, mid)) {
                ans = mid;
                low = mid + 1; // try removing more
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean isValid(String s, String p, int[] removable, int k) {

        int n = s.length();

        boolean[] removed = new boolean[n];

        // mark removed indices
        for (int i = 0; i < k; i++) {
            removed[removable[i]] = true;
        }

        int j = 0; // pointer for p

        for (int i = 0; i < n && j < p.length(); i++) {

            if (removed[i]) continue;

            if (s.charAt(i) == p.charAt(j)) {
                j++;
            }
        }

        return j == p.length();
    }

    public static void main(String[] args) {
        MaximumRemovals sol = new MaximumRemovals();
        String s1 = "abcacb";
        String p1 = "ab";
        int[] rem1 = {3,1,0};

        System.out.println(sol.maximumRemovals(s1, p1, rem1)); // 2
    }
}
