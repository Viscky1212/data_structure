package two_pointer_problem;

public class LongPressedNameApp {


    public static void main(String[] args) {
        LongPressedNameApp solution = new LongPressedNameApp();
        String name1 = "alex";
        String typed1 = "aaleex";

        String name2 = "saeed";
        String typed2 = "ssaaedd";

        System.out.println(name1 + " vs " + typed1 + " -> " +
                solution.isLongPressedName(name1, typed1));

        System.out.println(name2 + " vs " + typed2 + " -> " +
                solution.isLongPressedName(name2, typed2));
    }

    public boolean isLongPressedName(String name, String typed) {

        int i = 0, j = 0;
        while (j < typed.length()){
            //case 1 : character match
            if (i < name.length() && name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
            }

            //case 2 : long press (repeat previous char in type )
            else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            }

            //case 3  : invalid condition
            else {
                return false;
            }
        }
        //ensure all character of name are used
        return i == name.length();
    }
}
