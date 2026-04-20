package linkedList;

import java.util.ArrayList;
import java.util.List;

public class MinimumPairRemoval {

    public int minimumPairRemoval(int[] nums){
        List<Long> list = new ArrayList<>();

        for (int n : nums) list.add((long)n);

        int ops = 0;
        while (!isNonDecreasing(list)){
            int idx = 0;
            long minsum = Long.MAX_VALUE;
            for (int i = 0; i < list.size() - 1; i++) {
                long sum = list.get(i) + list.get(i + 1);
                if (sum < minsum){
                    minsum = sum;
                    idx = i;
                }
            }
            list.set(idx,minsum);
            list.remove(idx + 1);
            ops++;
        }
        return ops;
    }

    private boolean isNonDecreasing(List<Long>list){
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MinimumPairRemoval sol = new MinimumPairRemoval();
        System.out.println(sol.minimumPairRemoval(new int[]{5, 2, 3, 1})); // 2
        System.out.println(sol.minimumPairRemoval(new int[]{1, 2, 2}));    // 0
        System.out.println(sol.minimumPairRemoval(new int[]{3, 1, 2}));    // 1
    }
}
