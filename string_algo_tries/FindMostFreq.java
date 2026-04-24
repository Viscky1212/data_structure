package string_algo_tries;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMostFreq {

    public static String findMostFreq(List<String> words, int n){
        Map<String,Integer> freq = new HashMap<>();
        for (String w : words) freq.put(w,freq.getOrDefault(w,0) + 1);
        System.out.println(freq);

        String res = "";
        int max = 0;
        for (String w : words){
            if (freq.get(w) > max){
                max = freq.get(w);
                res = w;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findMostFreq(Arrays.asList("code", "compiler", "code"), 3)); // code
        System.out.println(findMostFreq(Arrays.asList("hello", "world"), 2));
    }
}
