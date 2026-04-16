package two_pointer_problem;

public class CountBinarySubstringsApp {

    public int countBinarySubstrings(String s){
        int prevGroup = 0;
        int currGroup = 1;
        int result = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)){
                currGroup++;
            } else {
                result += Math.min(prevGroup,currGroup);
                prevGroup = currGroup;
                currGroup = 1;
            }
        }
        //Add last group comparison
        result += Math.min(prevGroup,currGroup);
        return result;
    }

    public static void main(String[] args) {
        CountBinarySubstringsApp solution = new CountBinarySubstringsApp();
        String s1 = "00110011";
        String s2 = "10101";

        System.out.println("Input: " + s1);
        System.out.println("Output: " + solution.countBinarySubstrings(s1));

        System.out.println("------------------------");

        System.out.println("Input: " + s2);
        System.out.println("Output: " + solution.countBinarySubstrings(s2));


    }
}
