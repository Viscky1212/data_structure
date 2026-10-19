package patternBase.stack.Sep29;

import java.util.Stack;

public class RemoveDuplicates {

    public String removeDuplicates(String s){

        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){

            if(!stack.isEmpty() && stack.peek() == ch){
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();

        for(char ch : stack){
            result.append(ch);
        }

        return result.toString();
    }



    // public String removeDuplicates(String s) {

    //     StringBuilder stack = new StringBuilder();

    //     for(char ch : s.toCharArray()){

    //         if(stack.length() > 0 && stack.charAt(stack.length() - 1) == ch){
    //             stack.deleteCharAt(stack.length() -1);
    //         } else {
    //             stack.append(ch);
    //         }
    //     }

    //     return stack.toString();

    // }


    public static void main(String[] args) {

        RemoveDuplicates rd = new RemoveDuplicates();
        String input = "abbaca";
        String result = rd.removeDuplicates(input);
        System.out.println("Result after removing duplicates: " + result); // Output: "ca"
    }
}
