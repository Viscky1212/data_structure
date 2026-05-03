package binarySearch.april28;

public class FindLatestStep {

    public int findLatestStep(int[] arr, int m){
        int n = arr.length;

        //length[i] = length of group where i is boundary
        int[] length = new int[n + 2];

        //count[i] = how many groups of size i
        int[] count  = new int[n + 1];
        int result = -1;

        for (int step = 0; step < n; step++) {
            int pos = arr[step];

            int left = length[pos - 1];
            int right = length[pos + 1];

            int newLen = left + right + 1;

            //update boundaries
            length[pos - left] = newLen;
            length[pos + right] = newLen;

            //update counts
            if (left > 0) count[left]--;
            if (right > 0) count[right]--;

            count[newLen]++;

            //check condition
            if (count[m] > 0) {
                result = step + 1;  // 1-based step
            }
        }
            return result;

    }

    public static void main(String[] args) {

        FindLatestStep sol = new FindLatestStep();

        int[] arr1 = {3,5,1,2,4};
        System.out.println(sol.findLatestStep(arr1, 1)); // 4

        int[] arr2 = {3,1,5,4,2};
        System.out.println(sol.findLatestStep(arr2, 2)); // -1
    }
}
