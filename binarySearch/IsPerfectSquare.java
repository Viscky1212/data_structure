package binarySearch;

public class IsPerfectSquare {
    public boolean isPerfectSquare(int num){
    if (num < 2) return true;
    long lo = 1, hi = num / 2;
    while (lo <= hi){
        long mid = lo + (hi - lo) / 2;
        long sq = mid * mid;
        if (sq == num) return true;
        if (sq < num) lo = mid + 1;
        else hi = mid - 1;
    }
    return false;
    }

    public static void main(String[] args) {
        IsPerfectSquare s = new IsPerfectSquare();
        System.out.println(s.isPerfectSquare(1));   // true
        System.out.println(s.isPerfectSquare(16));  // true
        System.out.println(s.isPerfectSquare(14));  // false
        System.out.println(s.isPerfectSquare(2147395600)); // true (46340²)
    }
}
