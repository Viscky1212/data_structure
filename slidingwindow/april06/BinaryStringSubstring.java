package slidingwindow.april06;

public class BinaryStringSubstring {

    public static boolean queryString(String s , int n){
        //Optimization : check only n -> n / 2
        for (int i = n; i > n / 2; i--) {
            String subString = Integer.toBinaryString(i);
            if (!s.contains(subString)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "0110";
        int n = 3;

        boolean result = queryString(s, n);

        System.out.println("Result: " + result);
    }
}
