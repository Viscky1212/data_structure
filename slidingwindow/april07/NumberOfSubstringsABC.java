package slidingwindow.april07;

public class NumberOfSubstringsABC {

    public static  int numberOfSubstrings(String s){
        int n = s.length();
        int[] count = new int[3];  // a= 0, b = 1, c = 2

        int left = 0;
        int result = 0;

        for (int right = 0; right < n; right++) {


            //Add character
            count[s.charAt(right) - 'a']++;

            //when all  character present
            while (count[0] > 0 && count[1] > 0 && count[2] > 0){
                //All substring from left to end valid
                result += (n - right);

                //shrink window
                count[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return result;
    }

    //Brute force(for understanding)
    public static int bruteForce(String s){
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            int[] freq = new int[3];

            for (int j = i; j < s.length(); j++) {
                freq[s.charAt(j) - 'a']++;

                if (freq[0] > 0 && freq[1] > 0 && freq[2] > 0){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s1 = "abcabc";
        System.out.println("Optimal Result: " + numberOfSubstrings(s1));
        System.out.println("Brute Force Result: " + bruteForce(s1));

        String s2 = "aaacb";
        System.out.println("Test Case 2: " + numberOfSubstrings(s2));

        String s3 = "abc";
        System.out.println("Test Case 3: " + numberOfSubstrings(s3));
    }
}
