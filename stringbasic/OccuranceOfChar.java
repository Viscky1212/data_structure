package stringbasic;

public class OccuranceOfChar {

    public static void main(String[] args) {
        String str = "java";
        char ch = 'a';
        char [ ] charArray = str.toCharArray();
        int count = 0;



        for (int i = 0; i < charArray.length; i++){
//            if (charArray[i] == 'a'){
//                count++;
//            }
            if (str.charAt(i) == 'a'){
                count++;
            }
        }
        System.out.println(count);
    }
}
