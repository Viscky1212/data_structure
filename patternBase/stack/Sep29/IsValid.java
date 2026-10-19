package patternBase.stack.Sep29;

import java.util.*;

public class IsValid {

    public boolean isValid(String s) {

        Map<Character, Character> map = new HashMap<>();

        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Deque<Character> stack = new ArrayDeque<>();

        for(char ch : s.toCharArray()){

            //opening bracket
            if(!map.containsKey(ch)){
                stack.push(ch);
            } else {

                //closing bracket without opening bracket

                if(stack.isEmpty()){
                    return false;
                }

                //top must match corresponding opening bracket
                if(stack.pop() != map.get(ch)){
                    return false;
                }
            }
        }

        return stack.isEmpty();

    }




    //  public boolean isValid(String s) {

    //     Deque<Character> stack = new ArrayDeque<>();

    //     for(char ch : s.toCharArray()){

    //         if(ch == '(' || ch == '[' || ch == '{'){

    //             stack.push(ch);

    //         } else {

    //             //No corresponding opening bracket
    //             if(stack.isEmpty()){
    //                 return false;
    //             }

    //             char top = stack.pop();

    //             //check if brackets match

    //             if((ch == ')' && top != '(') ||
    //             (ch == ']' && top != '[') ||
    //             (ch == '}' && top != '{')){
    //                 return false;
    //             }
    //         }
    //     }

    //     // All opening brackets should be closed
    //     return stack.isEmpty();
    // }

    // public boolean isValid(String s) {

    //     Stack<Character> stack = new Stack<>();

    //     for(char ch : s.toCharArray()){

    //         //openning bracket -> push into stack
    //         if(ch == '(' || ch == '{' || ch == '['){

    //             stack.push(ch);
    //         }  else {

    //             //closeing bracket but no openning bracket
    //             if (stack.isEmpty()){
    //                 return false;
    //             }

    //             char top = stack.peek();

    //             //check matching pair
    //             if((ch == ')' && top != '(') ||
    //             (ch == ']' && top != '[') ||
    //             (ch == '}' && top != '{')){

    //             return false;
    //             }
    //         //matching pair found
    //         stack.pop();
    //         }
    //     }
    //     //is stack is empty all bracket were matched
    //     return stack.isEmpty();
    // }

    public static void main(String[] args) {

        IsValid iv = new IsValid();
        String input = "{[()]}";
        boolean result = iv.isValid(input);
        System.out.println("Is the string \"" + input + "\" valid? " + result); // Output: true
    }
}
