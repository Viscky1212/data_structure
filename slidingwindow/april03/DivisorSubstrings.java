package slidingwindow.april03;

public class DivisorSubstrings {

    public int divisorSubstrings(int num, int k) {

        String s = String.valueOf(num);
        int count = 0;

        for (int i = 0; i <= s.length() - k; i++) {

            String sub = s.substring(i, i + k);

            int val = Integer.parseInt(sub);

            // Skip if zero
            if (val != 0 && num % val == 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        DivisorSubstrings sol = new DivisorSubstrings();
        int num1 = 240;
        int k1 = 2;

        int num2 = 430043;
        int k2 = 2;

        System.out.println("Output 1: " + sol.divisorSubstrings(num1, k1)); // 2
        System.out.println("Output 2: " + sol.divisorSubstrings(num2, k2)); // 2
    }
}
