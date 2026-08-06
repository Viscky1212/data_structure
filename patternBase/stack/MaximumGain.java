package patternBase.stack;

public class MaximumGain {
    int score = 0;

    public int maximumGain(String s, int x, int y) {

        // पहले ज्यादा points वाला pattern हटाओ
        if (x >= y) {

            String remaining = removePattern(s, 'a', 'b', x);
            removePattern(remaining, 'b', 'a', y);

        } else {

            String remaining = removePattern(s, 'b', 'a', y);
            removePattern(remaining, 'a', 'b', x);
        }

        return score;
    }

    private String removePattern(String s, char first,
                                 char second, int points) {

        StringBuilder stack = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (stack.length() > 0
                    && stack.charAt(stack.length() - 1) == first
                    && ch == second) {

                stack.deleteCharAt(stack.length() - 1);

                score += points;

            } else {

                stack.append(ch);
            }
        }

        return stack.toString();
    }

    public static void main(String[] args) {

        String s = "cabcab";
        int x = 4;
        int y = 5;

        MaximumGain mg = new MaximumGain();
        int result = mg.maximumGain(s, x, y);
        System.out.println("Maximum Gain: " + result);
    }
}
