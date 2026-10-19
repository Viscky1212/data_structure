package patternBase.stack.Sep29;

import java.util.*;

public class SimplifyPath {
    /*
create empty stack

parts = path.split("/")

for part in parts:

    if part == "" OR part == ".":
        continue

    if part == "..":

        if stack is not empty:
            pop()

    else:

        push(part)

create result

for every directory in stack:
    result += "/" + directory

if result is empty:
    return "/"

return result
*/

        public String simplifyPath(String path) {

            Deque<String> stack = new ArrayDeque<>();

            //split path using '/'
            String[] parts = path.split("/");

            for(String part : parts){

                //Ignore empty parts and current directory
                if(part.isEmpty() || part.equals(".")){
                    continue;
                }

                //Move to parent directory
                if(part.equals("..")){

                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                } else {

                    //normal directory
                    stack.push(part);
                }
            }

            //build canpnical path
            StringBuilder result = new StringBuilder();

            while(!stack.isEmpty()){

                result.append("/");
                result.append(stack.removeLast());
            }

            //If stack was empty, root directory
            if(result.length() == 0){
                return "/";
            }

            return result.toString();

        }

    public static void main(String[] args) {

        SimplifyPath sp = new SimplifyPath();
        String path = "/a/./b/../../c/";
        String simplifiedPath = sp.simplifyPath(path);
        System.out.println("Simplified Path: " + simplifiedPath); // Output: "/c"
    }

}
