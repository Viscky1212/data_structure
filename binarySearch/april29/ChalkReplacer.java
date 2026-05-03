package binarySearch.april29;

public class ChalkReplacer {

    public int chalkReplacer(int[] chalk, int k){
        long total = 0;

        //Step 1 : compute total sum
        for (int c : chalk) total += c;

        //Step 2 : reduce k using modulo
        k %= total;

        //Step 3 : find student
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]){
                return i;
            }
            k -= chalk[i];
        }
        return -1; //never reached
    }

    public static void main(String[] args) {
        ChalkReplacer sol = new ChalkReplacer();
        int[] chalk1 = {5,1,5};
        System.out.println(sol.chalkReplacer(chalk1, 22)); // 0

        int[] chalk2 = {3,4,1,2};
        System.out.println(sol.chalkReplacer(chalk2, 25)); // 1
    }
}
