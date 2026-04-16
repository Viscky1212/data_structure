package stringbasic;

public class Palidrom2 {
    public static void main(String[] args) {
        String s = "madam";
        StringBuffer sb= new StringBuffer(s);
        sb.reverse();

       String s1 = sb.toString();

        if (s1.equals(s)){
            System.out.println("is Palindrom");
        } else {
            System.out.println("not palidrome");
        }
    }
}
