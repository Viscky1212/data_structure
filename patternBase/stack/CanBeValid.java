package patternBase.stack;

public class CanBeValid {
    public static boolean canBeValid(String s, String locked) {

        int n = s.length();

        // Odd length कभी valid नहीं हो सकती
        if (n % 2 == 1) {
            return false;
        }

        int open = 0;

        // Left -> Right
        for (int i = 0; i < n; i++) {

            if (locked.charAt(i) == '0' || s.charAt(i) == '(') {
                open++;
            } else {
                open--;
            }

            if (open < 0) {
                return false;
            }
        }

        int close = 0;

        // Right -> Left
        for (int i = n - 1; i >= 0; i--) {

            if (locked.charAt(i) == '0' || s.charAt(i) == ')') {
                close++;
            } else {
                close--;
            }

            if (close < 0) {
                return false;
            }
        }

        return true;
    }

//    public static boolean canBeValid(String s) {
//        int n = s.length();
//        if (n % 2 == 1) {
//            return false;
//        }
//
//        int balance = 0;
//        int stars = 0;
//
//        for (char c : s.toCharArray()) {
//            if (c == '(') {
//                balance++;
//            } else if (c == ')') {
//                balance--;
//            } else {
//                stars++;
//            }
//
//            if (balance + stars < 0) {
//                return false;
//            }
//        }
//
//        return balance <= stars;
//    }

    public static void main(String[] args) {

        String s = "(*))";
       // System.out.println(canBeValid(s));
        String locked = "0101";
        System.out.println(canBeValid(s, locked));
    }
}
