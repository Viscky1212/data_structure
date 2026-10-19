package patternBase.stack.octoberHashMap;

import java.util.*;

public class MaxNumberOfBalloons {
//    public int maxNumberOfBalloons(String text) {
//        int[] count = new int[26];
//
//        for(char ch : text.toCharArray()){
//            count[ch - 'a']++;
//        }
//
//        int answer = count['b' - 'a'];
//
//        answer = Math.min(answer, count[0]);
//        answer = Math.min(answer, count['l' - 'a'] / 2);
//        answer = Math.min(answer, count['o' - 'a'] / 2);
//        answer = Math.min(answer, count['n' - 'a']);
//
//        return answer;
//    }

    public int maxNumberOfBalloons(String text) {

        Map<Character, Integer> map = new HashMap<>();

        // Count characters
        for (char ch : text.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int answer = Integer.MAX_VALUE;

        answer = Math.min(answer, map.getOrDefault('b', 0));
        answer = Math.min(answer, map.getOrDefault('a', 0));
        answer = Math.min(answer, map.getOrDefault('l', 0) / 2);
        answer = Math.min(answer, map.getOrDefault('o', 0) / 2);
        answer = Math.min(answer, map.getOrDefault('n', 0));

        return answer;
    }

    public static void main(String[] args) {
        MaxNumberOfBalloons maxNumberOfBalloons = new MaxNumberOfBalloons();
        String input = "loonbalxballpoon";
        int result = maxNumberOfBalloons.maxNumberOfBalloons(input);
        System.out.println("Maximum number of 'balloon' that can be formed: " + result); // Output: 2
    }

    // public int maxNumberOfBalloons(String text) {


    //     int[] count = new int[26];

    //     //count every character
    //     for(char ch : text.toCharArray()){
    //         count[ch - 'a']++;
    //     }

    //     //"ballon" requires:
    //      // b -> 1
    //     // a -> 1
    //     // l -> 2
    //     // o -> 2
    //     // n -> 1

    //     int b = count['b' - 'a'];
    //     int a = count['a' - 'a'];
    //     int l = count['l' - 'a'] / 2;
    //     int o = count['o' - 'a'] / 2;
    //     int n = count['n' - 'a'];

    //     return Math.min(
    //         Math.min(a,b), Math.min(
    //             Math.min(l,o), n)
    //     );
    // }
}