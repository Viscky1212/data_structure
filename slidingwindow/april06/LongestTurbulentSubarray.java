package slidingwindow.april06;

public class LongestTurbulentSubarray {

    public static int maxTurbulenceSize(int[] arr){
        int n = arr.length;
        if (n == 1) return 1;

        int maxLength = 1;
        int currLength = 1;

        int prevCmp = 0; //previous comparison

        for (int i = 1; i < n; i++) {
            int currCmp = Integer.compare(arr[i - 1], arr[i]);

            if (currCmp == 0) currLength = 1;
            else if (currCmp * prevCmp == -1) currLength++; //alternating sign
            else currLength = 2;
            maxLength = Math.max(maxLength, currLength);
            prevCmp = currCmp;
        }
        return maxLength;
    }

    public static void main(String[] args) {

        int[] arr = {9, 4, 2, 10, 7, 8, 8, 1, 9};

        int result = maxTurbulenceSize(arr);

        System.out.println("Longest Turbulent Subarray Length: " + result);
    }
}
