package two_pointer_problem.march31;

public class LongestDecomposition {

    public int longestDecomposition(String text) {

        int n = text.length();

        String left = "";
        String right = "";

        int count = 0;

        for (int i = 0; i < n; i++) {

            left += text.charAt(i);
            right = text.charAt(n - 1 - i) + right;

            if (left.equals(right)) {
                count++;
                left = "";
                right = "";
            }
        }

        return count;
    }

//    public int longestDecomposition(String text){
//
//        int n = text.length();
//
//        String left = "";
//        String right = "";
//
//       int i = 0, j = n - 1;
//        int count = 0;
//
//        while (i <= j){
//            left += text.charAt(i);
//            right = text.charAt(j) + right;
//
//            if (left.equals(right)){
//
//                //if some position -> middle chunk
//                if (i == j){
//                    count += 1;
//
//                } else {
//                    count += 2;
//                }
//
////                System.out.print("left  : "+left+ "   " + left.length() + "  ");
////                System.out.print("right  : "+right + right.length());
//
//                left = "";
//                right = "";
//            }
//            i++;
//            j--;
//        }
//        return count;
//    }
    public static void main(String[] args) {
        LongestDecomposition sol = new LongestDecomposition();
        String text1 = "ghiabcdefhelloadamhelloabcdefghi";
        String text2 = "merchant";
        String text3 = "antaprezatepzapreanta";

        System.out.println("Output 1: " + sol.longestDecomposition(text1)); // 7
        System.out.println("Output 2: " + sol.longestDecomposition(text2)); // 1
        System.out.println("Output 3: " + sol.longestDecomposition(text3)); // 11
    }
}
