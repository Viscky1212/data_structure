package hashtable.may04;

public class FindLucky {

    public int findLucky(int[] arr){
        int[] freq = new int[501];

        //step 1 count freq
        for (int num : arr){
            freq[num]++;
        }

        //step 2 : find largest lucky number
        for (int i = 500; i >= 1; i--) {
            if (freq[i] == i) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FindLucky sol = new FindLucky();

        System.out.println(sol.findLucky(new int[]{2,2,3,4})); // 2
        System.out.println(sol.findLucky(new int[]{1,2,2,3,3,3})); // 3
        System.out.println(sol.findLucky(new int[]{2,2,2,3,3})); // -1
    }
}
