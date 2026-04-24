package binarySearch;

public class FindKthPositive {

    public int findKthPositive(int[] arr, int k){
        int num = 1;
        int i = 0;

        while (k > 0){
            if (i < arr.length && arr[i] == num){
                i++;
            } else {
                k--;
                if (k == 0) return num;
            }
            num++;
        }
        return num;
    }

    public static void main(String[] args) {
        FindKthPositive solution = new FindKthPositive();
        int[] arr1 = {2, 3, 4, 7, 11};
        int k1 = 5;
        System.out.println(solution.findKthPositive(arr1, k1)); // 9

        int[] arr2 = {1, 2, 3, 4};
        int k2 = 2;
        System.out.println(solution.findKthPositive(arr2, k2)); // 6
    }
}
