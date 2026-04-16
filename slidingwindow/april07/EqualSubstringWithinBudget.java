package slidingwindow.april07;

public class EqualSubstringWithinBudget {

    public static  int equalSubstring(String s, String t, int maxCost){
        int n = s.length();

        int left = 0;
        int currentCost = 0;
        int maxLength = 0;

        for (int right = 0; right < n; right++) {

            //Add cost of current character
            currentCost += Math.abs(s.charAt(right) - t.charAt(right));

            //if cost exceed -> shrink window
            while (currentCost > maxCost){
                currentCost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            //Update max length
            maxLength = Math.max(maxLength, right- left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {

        String s = "abcd";
        String t = "bcdf";
        int maxCost = 3;

        int result = equalSubstring(s, t, maxCost);

        System.out.println("Maximum valid substring length: " + result);
    }
}
