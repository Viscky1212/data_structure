package patternBase.stack;

public class CountCollisions {

    public static int countCollisions(String directions) {

        int left = 0;
        int right = directions.length() - 1;

        // Leading L हटाओ
        while (left <= right && directions.charAt(left) == 'L') {
            left++;
        }

        // Trailing R हटाओ
        while (left <= right && directions.charAt(right) == 'R') {
            right--;
        }

        int collisions = 0;

        // बीच में जितने L या R हैं,
        // वे सभी collide करेंगे
        for (int i = left; i <= right; i++) {

            if (directions.charAt(i) != 'S') {
                collisions++;
            }
        }

        return collisions;
    }
    public static void main(String[] args) {

        String directions = "RLRSLL";
        System.out.println(countCollisions(directions));
    }
}
