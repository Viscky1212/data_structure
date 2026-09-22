package patternBase.heap;

public class KSmallestPairs {

    static class Pair {
        int num1;
        int num2;
        int sum;

        Pair(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
            this.sum = num1 + num2;
        }
    }

    public static int[][] kSmallestPairs(int[] nums1, int[] nums2, int k) {
        java.util.PriorityQueue<Pair> maxHeap = new java.util.PriorityQueue<>((a, b) -> b.sum - a.sum);

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            for (int j = 0; j < Math.min(nums2.length, k); j++) {
                Pair pair = new Pair(nums1[i], nums2[j]);
                maxHeap.offer(pair);
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }

        int[][] result = new int[maxHeap.size()][2];
        int index = 0;
        while (!maxHeap.isEmpty()) {
            Pair pair = maxHeap.poll();
            result[index][0] = pair.num1;
            result[index][1] = pair.num2;
            index++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;

        int[][] result = kSmallestPairs(nums1, nums2, k);

        System.out.println("The " + k + " smallest pairs are:");
        for (int[] pair : result) {
            System.out.println("[" + pair[0] + ", " + pair[1] + "]");
        }
    }
}
