package hashtable.may01;

public class MaxNumberOfBalloons {

    public int maxNumberOfBalloons(String text){
        int[] freq = new int[26];

        //count character
        for (char ch : text.toCharArray()){
            freq[ch - 'a']++;
        }

        return Math.min(
                Math.min(freq['b' - 'a'],freq['a' - 'a']),
                Math.min(
                        Math.min(freq['l' - 'a'] /2,freq['o' - 'a'] / 2),
                        freq['n' - 'a']
                )
        );

    }

    public static void main(String[] args) {

        MaxNumberOfBalloons sol = new MaxNumberOfBalloons();

        System.out.println(sol.maxNumberOfBalloons("nlaebolko")); // 1
        System.out.println(sol.maxNumberOfBalloons("loonbalxballpoon")); // 2
        System.out.println(sol.maxNumberOfBalloons("leetcode")); // 0
    }
}
