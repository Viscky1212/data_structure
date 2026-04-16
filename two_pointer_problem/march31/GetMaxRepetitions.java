package two_pointer_problem.march31;

import java.util.HashMap;
import java.util.Map;

public class GetMaxRepetitions {

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0) return 0;

        int index = 0, count1 = 0, count2 = 0;

        Map<Integer, int[]> map = new HashMap<>();

        while (true) {
            count1++;

            // match s1 -> s2
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(index)) {
                    index++;
                    if (index == s2.length()) {
                        index = 0;
                        count2++;
                    }
                }
            }

            // if finished all s1
            if (count1 == n1) {
                return count2 / n2;
            }

            // cycle detected
            if (map.containsKey(index)) {
                int[] prev = map.get(index);

                int prevCount1 = prev[0];
                int prevCount2 = prev[1];

                // prefix
                int prefixCount1 = prevCount1;
                int prefixCount2 = prevCount2;

                // cycle
                int cycleLen1 = count1 - prevCount1;
                int cycleLen2 = count2 - prevCount2;

                int remaining = n1 - prefixCount1;

                int cycles = remaining / cycleLen1;

                int totalCount2 = prefixCount2 + cycles * cycleLen2;

                // remaining part after cycles
                int rest = remaining % cycleLen1;

                // simulate rest manually
                int tempIndex = index;
                int tempCount2 = 0;

                for (int i = 0; i < rest; i++) {
                    for (int j = 0; j < s1.length(); j++) {
                        if (s1.charAt(j) == s2.charAt(tempIndex)) {
                            tempIndex++;
                            if (tempIndex == s2.length()) {
                                tempIndex = 0;
                                tempCount2++;
                            }
                        }
                    }
                }

                totalCount2 += tempCount2;

                return totalCount2 / n2;
            } else {
                map.put(index, new int[]{count1, count2});
            }
        }
    }

    public static void main(String[] args) {

        GetMaxRepetitions sol = new GetMaxRepetitions();
        String s1 = "acb";
        int n1 = 4;
        String s2 = "ab";
        int n2 = 2;

        System.out.println("Output: " + sol.getMaxRepetitions(s1, n1, s2, n2)); // 2
    }
}
