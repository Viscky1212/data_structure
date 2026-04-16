package slidingwindow.april10.recursion;

import java.util.Stack;

public class Calculate {
    
    public int calculate(String s){
        int result = 0;
        int sign = 1;
        int num = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            //build number 
            if (Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }
            
            //'+' operator
            else if (c == '+') {
                result += sign* num;
                num = 0;
                sign = 1;
            }
            //'-' operator
            else if (c == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            } 
            //'('
            else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }
            
            //')'
            else if (c == ')') {
                result += sign * num;
                num = 0;
                result *= stack.pop(); //sign
                result += stack.pop();   //previous result
            }
        }
        result += sign * num;
        return result;
    }

    public static void main(String[] args) {
        Calculate sol = new Calculate();

        System.out.println(sol.calculate("1 + 1")); // 2
        System.out.println(sol.calculate(" 2-1 + 2 ")); // 3
        System.out.println(sol.calculate("(1+(4+5+2)-3)+(6+8)")); // 23
        System.out.println(sol.calculate("-2+ 1")); // -1
    }
}
