package binarySearch;

public class NumOfUnplacedFruits {

    public int numOfUnplacedFruits(int[] fruits, int[] baskets){
        int n = fruits.length;
        boolean[] used = new boolean[n];
        int unplaced = 0;

        for (int i = 0; i < n; i++) {
            boolean placed = false;

            for (int j = 0; j < n; j++) {
                if (!used[j] && baskets[j] >= fruits[i]){
                    used[j] = true;
                    placed = true;
                    break;
                }
            }
            if (!placed) unplaced++;
        }
        return unplaced;
    }

    public static void main(String[] args) {
        NumOfUnplacedFruits solution = new NumOfUnplacedFruits();
        int[] fruits1 = {4, 2, 5};
        int[] baskets1 = {3, 5, 4};
        System.out.println(solution.numOfUnplacedFruits(fruits1, baskets1)); // 1

        int[] fruits2 = {3, 6, 1};
        int[] baskets2 = {6, 4, 7};
        System.out.println(solution.numOfUnplacedFruits(fruits2, baskets2)); // 0
    }
}
