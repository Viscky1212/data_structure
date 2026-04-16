package two_pointer_problem;

public class JudgeSquareSum {

    public static boolean judgeSquareSum(int c){
        long left = 0;
        long right = (long) Math.sqrt(c);

        while (left <= right){
            long sum = left * left + right * right;

            if (sum == c) return true;

            else if (sum > c) right--;

            else left++;
        }
        return false;
    }

    public static void main(String[] args) {
        int c = 5;

        boolean result = judgeSquareSum(c);

        System.out.println("Can be expressed as sum of squares: " + result);
    }
}
