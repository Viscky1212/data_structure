package stringMatching;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MatchReplacement {

    public boolean matchReplacement(String s, String sub, char[][] mappings ){
        Map<Character, Set<Character>> allowed = new HashMap<>();

        for (char[] mapping : mappings){
            allowed.computeIfAbsent(mapping[0],
                    key -> new HashSet<>()).add(mapping[1]);
        }


        int n = s.length();
        int m = sub.length();

        for (int start = 0; start <= n - m; start++) {
            if (canMatch(s,sub,start,allowed)) return true;
        }
        return false;
    }

    private boolean canMatch(String s, String sub, int start, Map<Character, Set<Character>> allowed){
        for (int i = 0; i < sub.length(); i++) {
            char subChar = sub.charAt(i);
            char sChar = s.charAt(start + i);

            if (subChar == sChar){
                continue;
            }

            if (!allowed.containsKey(subChar) || !allowed.get(subChar).contains(sChar)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MatchReplacement sol = new MatchReplacement();

        String s1 = "fool3e7bar";
        String sub1 = "leet";
        char[][] mappings1 = {
                {'e', '3'},
                {'t', '7'},
                {'t', '8'}
        };
        System.out.println(sol.matchReplacement(s1, sub1, mappings1)); // true

        String s2 = "fooleetbar";
        String sub2 = "f00l";
        char[][] mappings2 = {
                {'o', '0'}
        };
        System.out.println(sol.matchReplacement(s2, sub2, mappings2)); // false

        String s3 = "Fool33tbaR";
        String sub3 = "leetd";
        char[][] mappings3 = {
                {'e', '3'},
                {'t', '7'},
                {'t', '8'},
                {'d', 'b'},
                {'p', 'b'}
        };
        System.out.println(sol.matchReplacement(s3, sub3, mappings3)); // true
    }
}
