package slidingwindow.april03;

public class CountGoodSubstrings {

    public int countGoodSubstrings(String s) {

        int count = 0;
        for (int i = 0; i <= s.length() - 3; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i +1);
            char c = s.charAt(i + 2);

            //char all distinct

            if (a != b && b != c && a != c) count++;
        }
        return count;
    }


    public static void main(String[] args) {
        CountGoodSubstrings sol = new CountGoodSubstrings();
        String s1 = "xyzzaz";
        String s2 = "aababcabc";

        System.out.println("Output 1: " + sol.countGoodSubstrings(s1)); // 1
        System.out.println("Output 2: " + sol.countGoodSubstrings(s2)); // 4
    }
    }

