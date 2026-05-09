package hashtable.may04;

import java.util.HashSet;
import java.util.Set;

public class IsPathCrossing {

    public boolean isPathCrossing(String path) {

        int x = 0, y = 0;

        Set<String> visited = new HashSet<>();
        visited.add("0,0");

        for (char ch : path.toCharArray()) {

            if (ch == 'N') y++;
            else if (ch == 'S') y--;
            else if (ch == 'E') x++;
            else if (ch == 'W') x--;

            String pos = x + "," + y;

            if (visited.contains(pos)) {
                return true;
            }

            visited.add(pos);
        }

        return false;
    }
    public static void main(String[] args) {

        IsPathCrossing sol = new IsPathCrossing();

        System.out.println(sol.isPathCrossing("NES"));   // false
        System.out.println(sol.isPathCrossing("NESWW")); // true
    }
}
