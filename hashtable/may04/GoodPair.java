package hashtable.may04;

public class GoodPair {
    public int numIdenticalPairs(int[] nums){
        int[] freq = new int[101];

        int pairs = 0;

        for (int num : nums){
            pairs += freq[num]; //existing matches
            freq[num]++;
        }
        return pairs;
    }

    public static void main(String[] args) {

        GoodPair sol = new GoodPair();

        System.out.println(sol.numIdenticalPairs(new int[]{1,2,3,1,1,3})); // 4
        System.out.println(sol.numIdenticalPairs(new int[]{1,1,1,1})); // 6
        System.out.println(sol.numIdenticalPairs(new int[]{1,2,3})); // 0
    }
}
