package patternBase.recursionAndBackTracking.sheet;

public class RemoveCharacter {

    public void removeCharacter(StringBuilder str, char ch) {
        solve(str, ch, 0);
    }
    public void solve(StringBuilder str, char ch, int index) {
        if (index == str.length()) {
            System.out.println("Resulting string: " + str.toString());
            return;
        }

        if (str.charAt(index) == ch) {
            str.deleteCharAt(index);
            solve(str, ch, index); // Do not increment index since we removed a character
        } else {
            solve(str, ch, index + 1); // Move to the next character
        }
    }
//    public void removeCharacter(String str, char ch) {
//        if (str.isEmpty()) {
//            System.out.println("Resulting string: " + str);
//            return;
//        }
//
//        char firstChar = str.charAt(0);
//        String remainingString = str.substring(1);
//
//        if (firstChar == ch) {
//            removeCharacter(remainingString, ch);
//        } else {
//            System.out.print(firstChar);
//            removeCharacter(remainingString, ch);
//        }
//    }

//    public String removeCharacter(String str, char ch) {
//        if (str.isEmpty()) {
//            return str;
//        }
//
//        char firstChar = str.charAt(0);
//        String remainingString = str.substring(1);
//
//        if (firstChar == ch) {
//            return removeCharacter(remainingString, ch);
//        } else {
//            return firstChar + removeCharacter(remainingString, ch);
//        }
//    }

    public static String removechar(String word, char ch)
    {
        StringBuilder s = new StringBuilder(word);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                s.deleteCharAt(i);
                i--;
            }
        }

        return s.toString();
    }

    public static void main(String[] args) {
        RemoveCharacter remover = new RemoveCharacter();
        String inputString = "hello world";
        char characterToRemove = 'o';
    //    String result = remover.removeCharacter(inputString, characterToRemove);
        System.out.println("Original string: " + inputString);
        System.out.println("String after removing '" + characterToRemove + "': ");
        //remover.removeCharacter(inputString, characterToRemove);
        StringBuilder sb = new StringBuilder(inputString);
        remover.removeCharacter(sb, characterToRemove);

        //last solution
        String result = removechar(inputString, characterToRemove);
        System.out.println("Resulting string: " + result);
    }
}
