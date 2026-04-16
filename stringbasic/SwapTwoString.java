package stringbasic;

public class SwapTwoString {

    public static void main(String[] args) {
        String s1 = "java";
        String s2 = "code";
        s1 = s1 + s2;

        s2 = s1.substring(0,s1.length() - s2.length());
        s1 = s1.substring(s2.length());


//        s2 = s1.substring(0, s1.length() - s2.length()); // s2 = "java"
//        s1 = s1.substring(s2.length()); // s1 = "code"


        System.out.println("S1 String after Swap ::  " + s1);
        System.out.println("S2 String after Swap  :: " + s2);

    }
}
