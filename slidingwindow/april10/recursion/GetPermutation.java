package slidingwindow.april10.recursion;

import java.util.ArrayList;
import java.util.List;

public class GetPermutation {

    public String getPermutation(int n, int k){
        List<Integer> numbers = new ArrayList<>();
        int[] fact = new int[n];

        //Step 1 : Build factorial array
        fact[0] = 1;

        for (int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i;
        }

        //Step 2 : Initialise number
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        //convert k to 0-based
        k--;

        StringBuilder result =  new StringBuilder();
        for (int i = n; i > 0; i--) {
            int index = k / fact[ i  - 1];
            result.append(numbers.get(index));

            numbers.remove(index);

            k = k % fact[i - 1];
        }
        return result.toString();
    }

    public static void main(String[] args) {
        GetPermutation sol = new GetPermutation();
        System.out.println(sol.getPermutation(3, 3)); // "213"
        System.out.println(sol.getPermutation(4, 9)); // "2314"
        System.out.println(sol.getPermutation(3, 1)); // "123"
    }
}
