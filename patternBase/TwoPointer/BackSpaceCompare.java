package patternBase.TwoPointer;

public class BackSpaceCompare {
    public static boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;

        while (i >= 0 || j >= 0) {
            int skipS = 0;
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }

            int skipT = 0;

            while (j >= 0){
                if (t.charAt(j) == '#'){
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            //compare characters
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) {
                return false;
            }

            //One String ended but the other not
            if ((i >= 0) != (j >= 0)) {
                return false;
            }
            i--;
            j--;

        }

        return true;
    }

    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";

        boolean result = backspaceCompare(s, t);
        System.out.println("Are the strings equal after processing backspaces? " + result);
    }
}
