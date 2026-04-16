package BST;

import java.util.Stack;

public class CanRepresentBST {

    public static int canRepresentBST(int arr[], int N){
        //Stack to keep track of ancestor
        Stack<Integer> stack = new Stack<>();

        //This represent the minimum allowed value
        int root = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            //if we find value smaller than allowed range
            if (arr[i] < root){
                return 0;
            }
            //if current value is greater than stack top
            //we are moving to right subtree
            while(!stack.isEmpty() && arr[i] > stack.peek()){
                root = stack.pop();  // update lower bond
            }
            //push current element
            stack.push(arr[i]);
        }
        return 1;
    }

    public static void main(String[] args) {

        int arr1[] = {2,4,3};
        System.out.println(canRepresentBST(arr1,arr1.length));

        int arr2[] = {2,4,1};
        System.out.println(canRepresentBST(arr2,arr2.length));
    }

}
