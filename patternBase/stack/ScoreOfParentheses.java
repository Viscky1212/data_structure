package patternBase.stack;

public class ScoreOfParentheses {

    public static int scoreOfParentheses(String s) {
        int score = 0;
        int balance = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
                if (s.charAt(i - 1) == '(') {
                    score += 1 << balance; // 2^balance
                }
            }
        }

        return score;
    }

    // public int scoreOfParentheses(String s) {
    //     Stack<Integer> stack = new Stack<>();

    //     int score = 0;

    //     for(char ch : s.toCharArray()){
    //         if(ch == '('){
    //             stack.push(score);
    //             score = 0;
    //         } else{
    //             score = stack.pop() + Math.max(2*score,1);
    //         }
    //     }
    //     return score;
    // }


    public static void main(String[] args) {
        String s = "(()(()))";
        System.out.println(scoreOfParentheses(s)); // Output: 6
    }
}
