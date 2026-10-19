package patternBase.stack.Sep29;

public class RemoveKdigits {

    /*
create empty stack

for digit in num:

    while k > 0
          AND stack not empty
          AND stack.top > digit:

        pop stack
        k--

    push digit

while k > 0:
    pop stack
    k--

remove leading zeros

if stack empty:
    return "0"

return stack


*/

        public String removeKdigits(String num, int k) {
            StringBuilder stack = new StringBuilder();

            for(char digit : num.toCharArray()){

                //remove larger previous digits
                while(k > 0 && stack.length() > 0 && stack.charAt(stack.length() - 1) > digit){

                    stack.deleteCharAt(stack.length() - 1);
                    k--;
                }

                //Add current digit
                stack.append(digit);
            }

            //If k is still remaining
            //remove digits from the end

            while(k > 0 && stack.length() > 0){

                stack.deleteCharAt(stack.length() - 1);
                k--;
            }

            //remove leading zeros
            int index = 0;

            while(index < stack.length()  && stack.charAt(index) == '0'){
                index++;
            }

            //All digits were zero or removed
            if(index == stack.length()){
                return "0";
            }

            return stack.substring(index);
        }

    public static void main(String[] args) {

        RemoveKdigits rk = new RemoveKdigits();
        String num = "1432219";
        int k = 3;
        String result = rk.removeKdigits(num, k);
        System.out.println("Result after removing " + k + " digits: " + result); // Output: "1219"
    }
}
