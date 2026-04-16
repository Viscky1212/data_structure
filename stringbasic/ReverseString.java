package stringbasic;

public class ReverseString {

    public static void main(String[] args) {
        String s = "java";
        String rev = "";

        //approch 1
        StringBuffer sb = new StringBuffer(s);
        StringBuffer reverse = sb.reverse();
        System.out.println(reverse);

        /* approch - 2
        *
        * */

        for (int i = s.length() - 1; i >=0; i--){
            String s1 = rev + s.charAt(i);
            System.out.print(s1);

        }
        System.out.println();


        /* approch 3 */
        char[] charArray = s.toCharArray();
        String s2 = "";
        for (int i = charArray.length - 1; i>=0; i--){
            s2 = s2 + charArray[i];
        }
        System.out.println(s2);

    }
}
