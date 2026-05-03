package binarySearch.april28;

public class MaxValue {

    public int maxValue(int n, int index, int maxSum){
        int low = 1, high = maxSum;
        int ans = 1;

        while (low <= high){
            int mid = low + (high - low) / 2;
            if (isValid(n, index,maxSum,mid)){
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean isValid(int n, int index , int maxSum, int x){
        long left = calculateSum(x - 1, index);
        long right = calculateSum(x  -1, n - index - 1);

        long total = left + right + x;

        return total <= maxSum;
    }

    private long calculateSum(int peak, int length){
        if (peak >= length){
            //full decreasing sequence
            long low = peak - length + 1;
            return (long) (peak + low) * length / 2;
        }else {
            //hits 1 early
            long sum = (long) peak * (peak + 1) / 2;
            sum += (length - peak); //remaining 1s
            return sum;
        }
    }

    public static void main(String[] args) {

        MaxValue sol = new MaxValue();

        System.out.println(sol.maxValue(4, 2, 6));  // 2
        System.out.println(sol.maxValue(6, 1, 10)); // 3
    }
}
