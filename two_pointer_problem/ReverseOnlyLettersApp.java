package two_pointer_problem;

public class ReverseOnlyLettersApp {

    public static void main(String[] args) {
        ReverseOnlyLettersApp solution = new ReverseOnlyLettersApp();
        String s1 = "ab-cd";
        String s2 = "a-bC-dEf-ghIj";
        String s3 = "Test1ng-Leet=code-Q!";

        System.out.println(s1 + " -> " + solution.reverseOnlyLetters(s1));
        System.out.println(s2 + " -> " + solution.reverseOnlyLetters(s2));
        System.out.println(s3 + " -> " + solution.reverseOnlyLetters(s3));
    }

    private String reverseOnlyLetters(String s) {

        char[] arr = s.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        while (left < right){
            //skip non letter from left
            if (!Character.isLetter(arr[left])){
                left++;
                continue;
            }
            //skip non letter from right
            if (!Character.isLetter(arr[right])){
                right--;
                continue;
            }
            //swap letter
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
        return new String(arr);
    }
}
