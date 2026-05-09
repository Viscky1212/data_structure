package hashtable.may06;

public class IsCovered {

    public boolean isCovered(int[][] ranges, int left, int right){

        int[] diff = new int[52];
        //step 1 : mark range
        for (int[] r : ranges){
            diff[r[0]]++;
            diff[r[1] + 1]--;
        }

        //step 2 : prefix sum and check coverage
        int coverage = 0;

        for (int i = 1; i <= 50; i++) {
            coverage += diff[i];

            if (i >= left && i <= right && coverage <= 0){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        IsCovered sol = new IsCovered();

        int[][] ranges1 = {{1,2},{3,4},{5,6}};
        System.out.println(sol.isCovered(ranges1, 2, 5)); // true

        int[][] ranges2 = {{1,10},{10,20}};
        System.out.println(sol.isCovered(ranges2, 21, 21)); // false
    }
}
