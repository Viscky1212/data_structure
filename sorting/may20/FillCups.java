package sorting.may20;

public class FillCups {

    public int fillCups(int[] amount){

        int total = 0;
        int maxAmount = 0;

        for (int cups : amount){
            total += cups;
            maxAmount = Math.max(maxAmount,cups);
            System.out.println("Max Amount " + maxAmount);
            System.out.println("cups count  " + cups);
            System.out.println("Kuch nhi mila"+ total);
        }
        int result = Math.max(maxAmount,(total + 1) / 2);
        System.out.println("Result is : " + result);
        return result;
    }

    public static void main(String[] args) {
        FillCups sol = new FillCups();
        int[] amount1 = {1, 4, 2};
        System.out.println(sol.fillCups(amount1));

        //System.out.println(fillCups(amount1));
        // Output: 4

//        int[] amount2 = {5, 4, 4};
//        System.out.println(sol.fillCups(amount2));
//        // Output: 7
//
//        int[] amount3 = {5, 0, 0};
//        System.out.println(sol.fillCups(amount3));
//        // Output: 5
    }
}
