package stringbasic;

public class RemoveVowels {
    public static void main(String[] args) {
        String str = " hello i love my india";
        str = str.replaceAll("[aeiouAEIOU]","");

        System.out.println(str);

    }
}
