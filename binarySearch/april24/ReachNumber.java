package binarySearch.april24;

public class ReachNumber {
    public int reachNumber(int target){
        target = Math.abs(target);
        int sum = 0;
        int step = 0;

        while (sum < target || (sum - target) % 2 != 0){
            step++;
            sum += step;
        }
        return step;
    }

    public static void main(String[] args) {
        ReachNumber solution = new ReachNumber();
        System.out.println(solution.reachNumber(2)); // 3
        System.out.println(solution.reachNumber(3)); // 2
        System.out.println(solution.reachNumber(-4)); // 3
    }
}
