package binarySearch;

public class NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target){
        for (char ch : letters){
            if (ch > target){
                return ch;
            }
        }
        return letters[0];
    }

    public static void main(String[] args) {
        NextGreatestLetter solution = new NextGreatestLetter();

        char[] letters1 = {'c', 'f', 'j'};
        char target1 = 'a';
        System.out.println(solution.nextGreatestLetter(letters1, target1)); // c

        char[] letters2 = {'c', 'f', 'j'};
        char target2 = 'c';
        System.out.println(solution.nextGreatestLetter(letters2, target2)); // f

        char[] letters3 = {'x', 'x', 'y', 'y'};
        char target3 = 'z';
        System.out.println(solution.nextGreatestLetter(letters3, target3)); // x

    }
}
