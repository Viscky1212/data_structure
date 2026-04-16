package array;

public class NonRepeatingElement {

    public static void main(String[] args) {
        int arr[] = {1,2,3,3,4,4,4,5,6,3,7};

        for (int i = 0; i < arr.length; i++){
            int count =0;

            for (int j = 0; j < arr.length; j++){
                if (arr[i] == arr[j]){
                    //if (arr[i] == arr[j] && i != j){
                    count++;
                }
            }
            if (count == 1){
                // if (count == 0){
                System.out.print(arr[i] + " ");
                //break;
            }

        }

    }
}
