package patternBase.stack.Sep29;

import java.util.*;

public class RemoveAdjacentDuplicates {
    /*
create stack

for every character ch:

    if stack is not empty
       AND stack.top.character == ch:

        stack.top.count++

    else:

        push(ch, 1)

    if stack.top.count == k:

        pop()

build answer from stack

*/

        static class Pair{
            char ch;
            int count;

            Pair(char ch,int count){
                this.ch = ch;
                this.count = count;
            }
        }
        public String removeDuplicates(String s, int k) {

            Deque<Pair> stack = new ArrayDeque<>();

            for(char ch : s.toCharArray()){

                if(!stack.isEmpty()  && stack.peek().ch == ch){

                    Pair top = stack.peek();
                    top.count++;

                    if(top.count == k){
                        stack.pop();
                    }

                }  else {

                    stack.push(new Pair(ch, 1));
                }
            }



            StringBuilder result = new StringBuilder();

            while(!stack.isEmpty()){

                Pair pair = stack.removeLast();

                for(int i = 0; i < pair.count; i++){
                    result.append(pair.ch);
                }
            }

            return result.toString();
        }

    public static void main(String[] args) {

        RemoveAdjacentDuplicates rad = new RemoveAdjacentDuplicates();
        String input = "deeedbbcccbdaa";
        int k = 3;
        String result = rad.removeDuplicates(input, k);
        System.out.println("Result after removing adjacent duplicates: " + result); // Output: "aa"
    }
}
