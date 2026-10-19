package patternBase.stack.Sep29;

import java.util.*;

public class ReverseString {
    public void reverseString(char[] s) {
        Deque<Character> stack = new ArrayDeque<>();

        //push all character
        for(char ch : s){
            stack.push(ch);
        }

        //pop in reverse order
        for(int i = 0; i < s.length; i++){
            s[i] = stack.pop();
        }
    }



    // public void reverseString(char[] s) {

    //     reverse(s, 0, s.length - 1);
    // }

    // public void reverse(char[] s, int left, int right){

    //     //base condition
    //     if(left >= right){
    //         return;

    //     }


    //     char temp = s[left];
    //     s[left] = s[right];
    //     s[right] = temp;


    //     reverse(s, left + 1, right - 1);
    // }




    // public void reverseString(char[] s) {

    //     int left = 0;
    //     int right = s.length - 1;

    //     while(left < right){
    //         char temp = s[left];
    //         s[left] = s[right];
    //         s[right] = temp;


    //         //mpve pointer
    //         left++;
    //         right--;
    //     }

    // }


    public static void main(String[] args) {

        ReverseString rs = new ReverseString();
        char[] input = {'h', 'e', 'l', 'l', 'o'};
        rs.reverseString(input);

        // i want print in array format
        System.out.println("Reversed string: " + Arrays.toString(input)); // Output: "olleh"
    }
}
