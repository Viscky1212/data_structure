package binarySearch.april26;

public class CocoEatBanana {
    public int minEatingSpeed(int[] piles, int h){
        int left = 1;
        int right = 0;

        for (int pile : piles){
            right = Math.max(right,pile);
        }

        while (left < right){
            int mid = left + (right - left) / 2;

            if (canFinish(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canFinish(int[] piles, int h, int speed){
        long hoursNeeded = 0;

        for(int pile : piles){
            hoursNeeded += (pile + speed - 1)/ speed;
        }
        return hoursNeeded <= h;
    }

    public static void main(String[] args) {
        CocoEatBanana sol = new CocoEatBanana();
        int[] piles1 = {3, 6, 7, 11};
        int h1 = 8;
        System.out.println(sol.minEatingSpeed(piles1, h1)); // 4

        int[] piles2 = {30, 11, 23, 4, 20};
        int h2 = 5;
        System.out.println(sol.minEatingSpeed(piles2, h2)); // 30

        int[] piles3 = {30, 11, 23, 4, 20};
        int h3 = 6;
        System.out.println(sol.minEatingSpeed(piles3, h3)); // 23
    }
}
