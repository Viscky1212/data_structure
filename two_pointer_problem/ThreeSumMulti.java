package two_pointer_problem;

import java.util.Arrays;

public class ThreeSumMulti {

    public static int threeSumMulti(int[] arr, int target) {

        Arrays.sort(arr);

        long count = 0;
        int MOD = 1_000_000_007;
        int n = arr.length;

        for (int i = 0; i < n - 2; i++) {

            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                int sum = arr[i] + arr[left] + arr[right];

                if (sum < target) left++;
                else if (sum > target) right--;
                else {

                    if (arr[left] != arr[right]) {

                        int leftCount = 1;
                        int rightCount = 1;

                        while (left + 1 < right && arr[left] == arr[left + 1]) {
                            leftCount++;
                            left++;
                        }

                        while (right - 1 > left && arr[right] == arr[right - 1]) {
                            rightCount++;
                            right--;
                        }

                        count += (long) leftCount * rightCount;

                        left++;
                        right--;
                    }
                    else {

                        int nCount = right - left + 1;
                        count += (long) nCount * (nCount - 1) / 2;
                        break;
                    }
                }
            }
        }

        return (int)(count % MOD);
    }

    public static void main(String[] args) {


        int[] arr = {1,1,2,2,3,3,4,4,5,5};
        int target = 8;



        System.out.println("Total triplets: " + threeSumMulti(arr,target));
    }
}

