package stringbasic;
import java.util.*;

public class StringObject {

    public static void main(String[] args) {
//        String str = "Vikrant@saini";
//        String str1 = "Java Developer";
//        System.out.println(str.charAt(0));
//        System.out.println(str.length());
//        System.out.println(str.substring(2));
//        System.out.println(str.concat(" Ramesh Saini"));

  //     String s3 =  str.replace("saini", "Java classes ");
  //      System.out.println(s3);


//        if (str.equals(str1)){
//            System.out.println("Welcome in java world");
//        } else {
//            System.out.println("Thanks you !");
//        }
//
//        System.out.println(str.toUpperCase());
//        System.out.println(str.toLowerCase());
//
//        System.out.println(str.indexOf("saini"));

//        System.out.println(str.substring(2,5));
//
//        //Split based on the delimeter
//        String[] s4  = str.split("@");
//        System.out.println(Arrays.toString(s4));

        //valueOF Method  --> used to convert anydata type in String
//        int a = 10;
//        int b = 20;
//        String s = String.valueOf(a) + String.valueOf(b);
//        System.out.println(s);

        /*
      startWith ==> check its start with that char or not
      endsWith ==> check its end with that char or not

      trim ==> trim method used to remove start or ending spaces
         */
//
//        String str = "vikrant saini";
//        System.out.println(str.startsWith("v"));
//        System.out.println(str.endsWith("i"));
//        System.out.println(str.trim());

        //convert string to char arr
        String str = "Vikrant Saini";
        char[] charArray = str.toCharArray();
        System.out.println(Arrays.toString(charArray));

    }
}
