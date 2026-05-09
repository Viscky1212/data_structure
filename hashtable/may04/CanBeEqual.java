package hashtable.may04;

public class CanBeEqual {

    public boolean canBeEqual(int[] target, int[] arr){
        int[] freq = new int[1001];

        //count target
        for (int num : target){
            freq[num]++;
        }

        //subtree
        for (int num : arr){
            freq[num]--;
        }

        //check
        for (int count : freq){
            if (count != 0){
                return  false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        CanBeEqual sol = new CanBeEqual();

        System.out.println(sol.canBeEqual(
                new int[]{1,2,3,4},
                new int[]{2,4,1,3}
        )); // true

        System.out.println(sol.canBeEqual(
                new int[]{3,7,9},
                new int[]{3,7,11}
        )); // false
    }
}
