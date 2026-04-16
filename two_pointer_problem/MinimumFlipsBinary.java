package two_pointer_problem;

public class MinimumFlipsBinary {

    public static int minimumFlips(int n) {

        // Convert to binary string
        String s = Integer.toBinaryString(n);

        // Reverse string
        String rev = new StringBuilder(s).reverse().toString();

        int flips = 0;

        // Compare all positions
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != rev.charAt(i)) {
                flips++;
            }
        }

        return flips;
    }



    public static void main(String[] args) {

        int n1 = 7;
        int n2 = 10;

        System.out.println("Input" + n1);
        System.out.println("Min Flips" + minimumFlips(n1));

        System.out.println("Input" + n2);
        System.out.println("Min Flips" + minimumFlips(n2));


    }
}
