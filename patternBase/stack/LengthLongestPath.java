package patternBase.stack;

public class LengthLongestPath {

    public static int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        int maxLength = 0;
        int[] pathLengths = new int[paths.length];

        for (String path : paths) {
            int depth = path.lastIndexOf('\t') + 1;
            int length = path.length() - depth;

            if (depth > 0) {
                length += pathLengths[depth - 1] + 1; // Add 1 for the '/' separator
            }

            pathLengths[depth] = length;

            if (path.contains(".")) { // It's a file
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        int length = lengthLongestPath(input);
        System.out.println("Length of the longest absolute path: " + length);
    }
}
