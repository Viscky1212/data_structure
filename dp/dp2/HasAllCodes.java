package dp.dp2;

import java.util.HashSet;
import java.util.Set;

public class HasAllCodes {

    public boolean hasAllCodes(String s, int k){
        if (k > s.length()){
            return false;
        }
        Set<String> seen = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            seen.add(s.substring(i, i + k));
        }
        return seen.size() == (1 << k);
    }

    public static void main(String[] args) {
        HasAllCodes sol = new HasAllCodes();
        String s = "00110110";
        int k = 2;

        System.out.println(sol.hasAllCodes(s, k));

    }
}
