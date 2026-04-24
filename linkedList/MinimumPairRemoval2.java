//package linkedList;
//
//import java.util.TreeMap;
//import java.util.TreeSet;
//
//// LeetCode 3510 - Minimum Pair Removal to Sort Array II
////
//// Strategy: Doubly Linked List + TreeMap
////
//// We simulate the merging process efficiently:
////   - Doubly linked list  : O(1) node removal and neighbor lookup after each merge
////   - TreeMap<sum, TreeSet<leftIndex>> : always gives minimum-sum, leftmost pair in O(log n)
////   - badCount            : tracks how many adjacent pairs violate non-decreasing order
////
//// Each merge:
////   1. Pull the min-sum pair from the TreeMap
////   2. Remove its two neighbour-pairs from the map (they'll change)
////   3. Update badCount for the three affected pairs (before and after)
////   4. Update the linked list and insert the two new neighbour-pairs
////
//// Total: O(n log n) time, O(n) space
//public class MinimumPairRemoval2 {
//
//    // pairMap: sum -> sorted set of left-node indices that have that pair sum
//    private TreeMap<Long, TreeSet<Integer>> pairMap;
//
//    public int minimumPairRemoval(int[] nums) {
//        int n = nums.length;
//        if (n == 1) return 0;
//
//        // Doubly linked list arrays (index = original position)
//        int[]  prv = new int[n];
//        int[]  nxt = new int[n];
//        long[] val = new long[n];
//
//        for (int i = 0; i < n; i++) {
//            val[i] = nums[i];
//            prv[i] = i - 1;
//            nxt[i] = i + 1;
//        }
//
//        pairMap = new TreeMap<>();
//        int badCount = 0;
//
//        // Build initial pairs
//        for (int i = 0; i < n - 1; i++) {
//            addPair(val[i] + val[i + 1], i);
//            if (val[i] > val[i + 1]) badCount++;
//        }
//
//        int ops = 0;
//
//        while (badCount > 0) {
//            // --- pick minimum-sum, leftmost pair ---
//            var firstEntry = pairMap.firstEntry();
//            long minSum   = firstEntry.getKey();
//            int  leftIdx  = firstEntry.getValue().first();
//            int  rightIdx = nxt[leftIdx];
//
//            removePair(minSum, leftIdx);
//
//            // Count the violation being merged
//            if (val[leftIdx] > val[rightIdx]) badCount--;
//
//            int prevIdx = prv[leftIdx];
//            int nextIdx = nxt[rightIdx];
//
//            // --- remove left-neighbour pair (prevIdx, leftIdx) ---
//            if (prevIdx >= 0) {
//                removePair(val[prevIdx] + val[leftIdx], prevIdx);
//                if (val[prevIdx] > val[leftIdx]) badCount--;
//            }
//
//            // --- remove right-neighbour pair (rightIdx, nextIdx) ---
//            if (nextIdx < n) {
//                removePair(val[rightIdx] + val[nextIdx], rightIdx);
//                if (val[rightIdx] > val[nextIdx]) badCount--;
//            }
//
//            // --- merge: update leftIdx's value, skip rightIdx ---
//            val[leftIdx] = minSum;
//            nxt[leftIdx] = nextIdx;
//            if (nextIdx < n) prv[nextIdx] = leftIdx;
//
//            // --- add new left-neighbour pair (prevIdx, leftIdx) ---
//            if (prevIdx >= 0) {
//                addPair(val[prevIdx] + val[leftIdx], prevIdx);
//                if (val[prevIdx] > val[leftIdx]) badCount++;
//            }
//
//            // --- add new right-neighbour pair (leftIdx, nextIdx) ---
//            if (nextIdx < n) {
//                addPair(val[leftIdx] + val[nextIdx], leftIdx);
//                if (val[leftIdx] > val[nextIdx]) badCount++;
//            }
//
//            ops++;
//        }
//
//        return ops;
//    }
//
//    private void addPair(long sum, int leftIdx) {
//        pairMap.computeIfAbsent(sum, k -> new TreeSet<>()).add(leftIdx);
//    }
//
//    private void removePair(long sum, int leftIdx) {
//        TreeSet<Integer> set = pairMap.get(sum);
//        if (set == null) return;
//        set.remove(leftIdx);
//        if (set.isEmpty()) pairMap.remove(sum);
//    }
//
//    // ---------------------------------------------------------------
//    public static void main(String[] args) {
//        MinimumPairRemoval2 sol = new MinimumPairRemoval2();
//
//        // Example 1: [5,2,3,1] -> 2
//        System.out.println(sol.minimumPairRemoval(new int[]{5, 2, 3, 1}));  // 2
//
//        // Example 2: [1,2,2] -> 0
//        System.out.println(sol.minimumPairRemoval(new int[]{1, 2, 2}));     // 0
//
//        // Already sorted single element
//        System.out.println(sol.minimumPairRemoval(new int[]{7}));           // 0
//
//        // Reverse sorted: [3,2,1] -> 2
//        // Op1: min pair (2,1)=3 -> [3,3]  -> 1 bad pair
//        // Op2: min pair (3,3)=6 -> [6]    -> 0 bad pairs
//        System.out.println(sol.minimumPairRemoval(new int[]{3, 2, 1}));     // 2
//
//        // Tie-breaking (leftmost): [4,1,1,4]
//        // pairs: (4,1)=5, (1,1)=2, (1,4)=5   -> min=2 at idx1
//        // Op1: merge idx1+idx2 -> [4,2,4]     -> (4,2)=6, (2,4)=6
//        // still bad: 4>2, op2: merge idx0+idx1(now merged) -> [6,4] -> 1 bad
//        // op3: merge -> [10]  done
//        System.out.println(sol.minimumPairRemoval(new int[]{4, 1, 1, 4}));  // 3
//    }
//}