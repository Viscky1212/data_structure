package hashtable.may09;

public class CountBalls {

    public int countBalls(int lowLimit, int highLimit){
        int[] freq = new int[46]; //max digit sum = 46
        int max = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = digitSum(i);
            freq[sum]++;
            max = Math.max(max,freq[sum]);
        }
        return max;

    }

    private int digitSum(int num){
        int sum = 0;

        while (num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        CountBalls sol = new CountBalls();
        System.out.println(sol.countBalls(1, 10));  // 2
        System.out.println(sol.countBalls(5, 15));  // 2
        System.out.println(sol.countBalls(19, 28)); // 2

    }
}
