package stringbasic;

public class CountWord {
    public static void main(String[] args) {
        String str = "i love java   programming";
//approch :1
        String[] split = str.split("\\s+");

        System.out.println(split.length);
//Approch : 2
        String str2 = "  i  love my inida ";
        String[] split1 = str2.trim().split("\\s+"); //=> \\+ use for ignoring extra spaces
        System.out.println(split1.length);

        //Approch : 3

    }
}
