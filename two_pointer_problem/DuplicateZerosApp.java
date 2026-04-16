package two_pointer_problem;

public class DuplicateZerosApp {

    public static void main(String[] args) {
        DuplicateZerosApp solution = new DuplicateZerosApp();
        int[] arr1 = {1,0,2,3,0,4,5,0};
        solution.duplicateZeros(arr1);
        print(arr1);

        System.out.println("------------------");

        int[] arr2 = {1,2,3};
        solution.duplicateZeros(arr2);
        print(arr2);
    }

    private void duplicateZeros(int[] arr) {
        int n = arr.length;
        int zeros = 0;

        //step 1 : Count zeros
        for (int num : arr){
            if (num == 0) zeros++;
        }

        //Step 2 : Traverse backword
        int i = n- 1;
        int j = n + zeros - 1;  //virtual index
        while (i >= 0){
            //if within the bound
            if ( j < n){
                arr[j] = arr[i];
            }

            //If zero duplicate it
            if (arr[i] == 0){
                j--;
                if (j < n){
                    arr[j] = 0;
                }
            }
            i--;
            j--;
        }

    }

    private static void print(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
