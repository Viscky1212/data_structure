package two_pointer_problem;

public class SmallestPalindromeApp {

    public String makeSmallestPalindrome(String s){
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;

        while (left < right){
            if (arr[left] != arr[right]){
                //choose smaller char
                char minChar = (char) Math.min(arr[left], arr[right]);
                arr[left] = minChar;
                arr[right] = minChar;
            }
            left++;
            right--;
        }
        return new String(arr);
    }
    public static void main(String[] args) {
        SmallestPalindromeApp solution = new SmallestPalindromeApp();

        System.out.println(solution.makeSmallestPalindrome("egcfe")); // efcfe
        System.out.println(solution.makeSmallestPalindrome("abcd"));  // abba
        System.out.println(solution.makeSmallestPalindrome("seven")); // neven
    }
}
