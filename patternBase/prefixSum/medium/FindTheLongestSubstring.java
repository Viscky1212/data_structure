package patternBase.prefixSum.medium;

import java.util.Arrays;

public class FindTheLongestSubstring {

    public static int findTheLongestSubstring(String s) {

        int[] first = new int[32];

        Arrays.fill(first, -2);

        first[0] = -1;

        int mask = 0;
        int maxLength = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            switch(ch){
                case 'a':
                    mask ^= (1 << 0);
                    break;
                case 'e':
                    mask ^= (1 << 1);
                    break;
                case 'i':
                    mask ^= (1 << 2);
                    break;
                case 'o':
                    mask ^= (1 << 3);
                    break;
                case 'u':
                    mask ^= (1 << 4);
                    break;

            }

            if(first[mask] == -2){
                first[mask] = i;
            } else{
                maxLength = Math.max(maxLength, i - first[mask]);
            }
        }
        return  maxLength;

    }



//    public static int findTheLongestSubstring(String s) {
//        int n = s.length();
//        int[] prefix = new int[n + 1];
//        int[] firstOccurrence = new int[32];
//        for (int i = 0; i < 32; i++) {
//            firstOccurrence[i] = -1;
//        }
//        firstOccurrence[0] = 0;
//        int maxLength = 0;
//
//        for (int i = 0; i < n; i++) {
//            char c = s.charAt(i);
//            if (c == 'a') {
//                prefix[i + 1] = prefix[i] ^ (1 << 0);
//            } else if (c == 'e') {
//                prefix[i + 1] = prefix[i] ^ (1 << 1);
//            } else if (c == 'i') {
//                prefix[i + 1] = prefix[i] ^ (1 << 2);
//            } else if (c == 'o') {
//                prefix[i + 1] = prefix[i] ^ (1 << 3);
//            } else if (c == 'u') {
//                prefix[i + 1] = prefix[i] ^ (1 << 4);
//            } else {
//                prefix[i + 1] = prefix[i];
//            }
//
//            if (firstOccurrence[prefix[i + 1]] != -1) {
//                maxLength = Math.max(maxLength, i + 1 - firstOccurrence[prefix[i + 1]]);
//            } else {
//                firstOccurrence[prefix[i + 1]] = i + 1;
//            }
//        }
//
//        return maxLength;
//    }

    public static void main(String[] args) {
        String s = "eleetminicoworoep";
        int result = findTheLongestSubstring(s);
        System.out.println("The length of the longest substring is: " + result);
    }
}
