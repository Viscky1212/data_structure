package two_pointer_problem;

public class LongestMountain {

    public static int longestMountain(int[] arr){

        int up = 0;
        int down = 0;
        int max = 0;

        for (int i = 1; i < arr.length; i++) {

            if ((down > 0 && arr[i] > arr[i - 1]) || arr[i] == arr[i - 1]) {
                up = 0;
                down = 0;
            }

            if (arr[i] > arr[i - 1]) {
                up++;
            }

            if (arr[i] < arr[i - 1]) {
                down++;
            }

            if (up > 0 && down > 0) {
                max = Math.max(max, up + down + 1);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,4,7,3,2,5};

        int result = longestMountain(arr);

        System.out.println("Longest Mountain Length: " + result);
    }
}
