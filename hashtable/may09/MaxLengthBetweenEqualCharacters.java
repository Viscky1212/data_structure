package hashtable.may09;

public class MaxLengthBetweenEqualCharacters {

    public int maxLengthBetweenEqualCharacters(String s) {

        int[] first = new int[26];

        // initialize with -1
        for (int i = 0; i < 26; i++) {
            first[i] = -1;
        }

        int max = -1;

        for (int i = 0; i < s.length(); i++) {

            int idx = s.charAt(i) - 'a';

            if (first[idx] == -1) {
                first[idx] = i;
            } else {
                max = Math.max(max, i - first[idx] - 1);
            }
        }

        return max;
    }

    public static void main(String[] args) {

        MaxLengthBetweenEqualCharacters sol = new MaxLengthBetweenEqualCharacters();

        System.out.println(sol.maxLengthBetweenEqualCharacters("aa"));   // 0
        System.out.println(sol.maxLengthBetweenEqualCharacters("abca")); // 2
        System.out.println(sol.maxLengthBetweenEqualCharacters("cbzxy")); // -1
    }
}
