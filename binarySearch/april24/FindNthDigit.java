package binarySearch.april24;

public class FindNthDigit {

    public int findNthDigit(int n){
        long digitLength = 1;
        long count = 9;
        long start = 1;

        while (n > digitLength* count){
            n -= digitLength* count;
            digitLength++;
            count *= 10;
            start *= 10;
        }
        long number = start + (n - 1) /digitLength;
        String str = String.valueOf(number);

        return str.charAt((int)((n - 1) % digitLength)) - '0';
    }

    public static void main(String[] args) {
        FindNthDigit solution = new FindNthDigit();
        System.out.println(solution.findNthDigit(3));   // 3
        System.out.println(solution.findNthDigit(11));  // 0
    }
}
