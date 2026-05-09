package hashtable.may04;

public class CountLargestGroup {

    public int countLargestGroup(int n ){
        int[] freq = new int[37]; //max digit sum for 9999 = 36

        //step 1 : compute frequency
        for (int i = 1; i <= n; i++) {
            int sum = digitSum(i);
            freq[sum]++;
        }

        //Step 2 : find max group size
        int maxSize = 0;
        for (int count : freq){
           maxSize = Math.max(maxSize,count);
        }

        //step 3 : count group with max size
        int result = 0;
        for (int count : freq){
            if (count == maxSize){
                result++;
            }
        }

        return result;
    }

    public int digitSum(int num){
        int sum = 0;

        while (num > 0){
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }


    public static void main(String[] args) {

        CountLargestGroup sol = new CountLargestGroup();

        System.out.println(sol.countLargestGroup(13)); // 4
        System.out.println(sol.countLargestGroup(2));  // 2
    }
}
