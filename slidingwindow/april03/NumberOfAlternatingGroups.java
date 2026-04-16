package slidingwindow.april03;

public class NumberOfAlternatingGroups {

    public int numberOfAlternatingGroups(int[] colors){
        int n = colors.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int left = colors[(i - 1 + n) % n];
            int mid = colors[i];
            int right = colors[(i + 1) % n];

            //check alternating condition
            if (mid != left && mid != right){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfAlternatingGroups sol = new NumberOfAlternatingGroups();
        int[] colors1 = {1,1,1};
        int[] colors2 = {0,1,0,0,1};

        System.out.println(sol.numberOfAlternatingGroups(colors1)); // 0
        System.out.println(sol.numberOfAlternatingGroups(colors2)); // 3
    }
}
