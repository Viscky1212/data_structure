package slidingwindow.april03;

public class CountKConstraintSubstrings {

    public int countKConstraintSubstrings(String s, int k){
        int n = s.length();

        //Total substrings
        int total = n *(n + 1)/ 2;

        int left = 0;
        int count0 = 0, count1 = 0;
        int invalid = 0;

        for (int right = 0; right < n; right++) {
            if (s.charAt(right) == '0') count0++;
            else count1++;

            //If both exceed k -> invalid
            while (count0 > k && count1 > k){
                if (s.charAt(left) == '0') count0--;
                else count1--;
                left++;
            }

            //number of invalid substrings ending at right
            invalid += left;
        }
        return total - invalid;
    }

    public static void main(String[] args) {
        CountKConstraintSubstrings sol = new CountKConstraintSubstrings();
        String s1 = "10101";
        int k1 = 1;

        String s2 = "1010101";
        int k2 = 2;

        String s3 = "11111";
        int k3 = 1;

        System.out.println(sol.countKConstraintSubstrings(s1, k1)); // 12
        System.out.println(sol.countKConstraintSubstrings(s2, k2)); // 25
        System.out.println(sol.countKConstraintSubstrings(s3, k3)); // 15
    }
}
