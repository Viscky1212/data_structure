package patternBase.prefixSum.medium;

public class ShiftingLetters {

    public String shiftingLetters(String s, int[] shifts) {
        char[] chars = s.toCharArray();
        long totalShift = 0;

        for(int i = shifts.length - 1; i >= 0; i--){
            totalShift = (totalShift + shifts[i]) % 26;

            int current = chars[i] - 'a';
            int shifted = (int)((current + totalShift)% 26);
            chars[i] = (char) ('a' + shifted);
        }
        return new String(chars);

    }
    public static void main(String[] args) {
        String s = "abc";
        int[] shifts = {3, 5, 9};
        ShiftingLetters solution = new ShiftingLetters();
        String result = solution.shiftingLetters(s, shifts);
        System.out.println(result); // Output: "rpl"
    }
}
