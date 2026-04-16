package two_pointer_problem;

public class DIStringMatchApp {
    public static void main(String[] args) {
        DIStringMatchApp solution = new DIStringMatchApp();
        String s1 = "IDID";
        int[] result1 = solution.diStringMatch(s1);
        print(result1);

        System.out.println("------------------");

        String s2 = "III";
        int[] result2 = solution.diStringMatch(s2);
        print(result2);

        System.out.println("------------------");

        String s3 = "DDI";
        int[] result3 = solution.diStringMatch(s3);
        print(result3);
    }

    private int[] diStringMatch(String s) {
        int n = s.length();
        int[] result = new int[n + 1];

        int low = 0;
        int high = n;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I'){
                result[i] = low++;
            } else {
                result[i] = high--;
            }
        }
        //last remaining number
        result[n] = low; //or high (both same now)
    return result;
    }


    private static void print(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

    }
}
