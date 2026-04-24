package binarySearch;

public class ArrangeCoins {

    public int arrangeCoins(int n ){
        int row = 1;

        while (n >= row){
            n -= row;
            row++;
        }
        return row - 1;
    }

    public static void main(String[] args) {
        ArrangeCoins solution = new ArrangeCoins();
        System.out.println(solution.arrangeCoins(5)); // 2
        System.out.println(solution.arrangeCoins(8)); // 3
    }
}
