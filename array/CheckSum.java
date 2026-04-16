package array;

public class CheckSum {

    public static void main(String[] args) {
        int arr[] = {9,2,3,1,5,12,23};
        int sum = 8;

        for (int i = 0; i< arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                if (arr[i] + arr[j] == sum){
                    System.out.println(arr[i] + " + " + arr[j] + " = " + sum);
                }
            }
        }
    }
}
