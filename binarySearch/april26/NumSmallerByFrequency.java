package binarySearch.april26;

import java.util.Arrays;

public class NumSmallerByFrequency {

    public int[] numSmallerByFrequency(String[] queries, String[] words){
        int n = words.length;

        //Step 1 : compute frequncy foe words
        int[] wordFreq = new int[n];

        for (int i = 0; i < n; i++) {
            wordFreq[i] = getFrequency(words[i]);
        }

        //step 2 : sort frequencies
        Arrays.sort(wordFreq);

        int[] result = new int[queries.length];

        //step 3 : process each query
        for (int i = 0; i < queries.length; i++) {
            int queryFreq = getFrequency(queries[i]);

            int index = upperBound(wordFreq,queryFreq);

            result[i] = n - index;
        }
        return result;
    }

    //function to calculate f(s)
    private int getFrequency(String s){
        char minChar  = 'z';
        int count  = 0;

        for (char c : s.toCharArray()){
            if (c < minChar){
                minChar = c;
                count = 1;
            } else if (c == minChar){
                count++;
            }
        }
        return count;
    }

    //Binary search : first index > target
    private int upperBound(int[] arr, int target){
        int left = 0;
        int right = arr.length;

        while (left < right){
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        NumSmallerByFrequency solution = new NumSmallerByFrequency();
        String[] queries1 = {"cbd"};
        String[] words1 = {"zaaaz"};
        System.out.println(Arrays.toString(solution.numSmallerByFrequency(queries1, words1)));
        // Expected: [1]

        String[] queries2 = {"bbb", "cc"};
        String[] words2 = {"a", "aa", "aaa", "aaaa"};
        System.out.println(Arrays.toString(solution.numSmallerByFrequency(queries2, words2)));
        // Expected: [1, 2]
    }
}
