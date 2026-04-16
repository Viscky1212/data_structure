package two_pointer_problem;

public class FlipImageApp {
    public static void main(String[] args) {

        FlipImageApp solution = new FlipImageApp();

        int[][] image = {
                {1,1,0},
                {1,0,1},
                {0,0,0}
        };

        int[][] result = solution.flipAndInvertImage(image);

        // Print result
        System.out.println("Output:");
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    public int[][] flipAndInvertImage(int[][] image) {

        int n = image.length;

        for (int i = 0; i < n; i++) {

            int left = 0, right = n - 1;

            while (left <= right) {

                // Swap + invert
                int temp = image[i][left] ^ 1;
                image[i][left] = image[i][right] ^ 1;
                image[i][right] = temp;

                left++;
                right--;
            }
        }

        return image;
    }
}
