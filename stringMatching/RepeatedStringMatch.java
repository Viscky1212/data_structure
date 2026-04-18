package stringMatching;

public class RepeatedStringMatch {

    public int repeatedStringMatch(String a, String b){
        StringBuilder sb = new StringBuilder();
        int count = 0;

        while (sb.length() < b.length()){
            sb.append(a);
            count++;
        }
        if (sb.toString().contains(b)) return count;

        sb.append(a);
        count++;

        if (sb.toString().contains(b)) return count;
        return -1;
    }


    public static void main(String[] args) {
        RepeatedStringMatch sol = new RepeatedStringMatch();

        String a1 = "abcd";
        String b1 = "cdabcdab";
        System.out.println(sol.repeatedStringMatch(a1, b1)); // 3

        String a2 = "a";
        String b2 = "aa";
        System.out.println(sol.repeatedStringMatch(a2, b2)); // 2
    }
}
