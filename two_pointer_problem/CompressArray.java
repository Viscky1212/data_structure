package two_pointer_problem;

public class CompressArray {

    public static int compress(char[] chars){
        int write = 0;  // position to write compressed data
        int read = 0;   // position to read characters

        while (read < chars.length){
            char currentChar = chars[read];
            int count = 0;

            //count occurrence

            while (read < chars.length && chars[read] == currentChar){
                read++;
                count++;
            }

            //write character
            chars[write++] = currentChar;

            //write count if greater than 1
            if (count > 1){
                String countStr = String.valueOf(count);

                for (char c : countStr.toCharArray()){
                    chars[write++] = c;
                }
            }
        }
        return write;
    }

    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};

        int length = compress(chars);

        System.out.println("Compressed Length: " + length);

        System.out.print("Compress Array :");

        for (int i = 0; i < length; i++) {
            System.out.print(chars[i] + " ");
        }

    }
}
