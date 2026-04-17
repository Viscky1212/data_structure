package recursion;

public class LastRemainingInteger {



    public  long lastInteger(long n){

        return solve(n, 0);
    }

    public long solve(long n, int dir){
        if (n == 1) return 1;

        if (dir == 0){
            return 2 * solve(n / 2,1) - 1;
        } else {
            if (n % 2 == 0){
                return 2* solve(n / 2, 0);
            } else {
                return 2 * solve(n / 2, 0) -1;
            }
        }
    }

    public static void main(String[] args) {

        LastRemainingInteger sol = new LastRemainingInteger();
        System.out.println(sol.lastInteger(8)); // 3 ✅
        System.out.println(sol.lastInteger(5)); // 1 ✅
        System.out.println(sol.lastInteger(1)); // 1
    }
}
