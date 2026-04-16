package two_pointer_problem.march30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPositiveInteger {

    interface CustomFunction{
        int f(int x, int y);
    }

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z){
        List<List<Integer>> result = new ArrayList<>();
        
        int x = 1;
        int y = 1000;
        
        while (x <= 1000 && y >= 1){
            int val = customfunction.f(x,y);
            
            if (val == z){
                result.add(Arrays.asList(x, y));
                x++;
                y--;
            } else if (val < z) {
                x++;
            } else {
                y--;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        FindPositiveInteger sol = new FindPositiveInteger();
        // f(x,y) = x + y, z = 5  →  [[1,4],[2,3],[3,2],[4,1]]
        CustomFunction addFn = (x, y) -> x + y;
        System.out.println(sol.findSolution(addFn, 5));

        // f(x,y) = x * y, z = 5  →  [[1,5],[5,1]]
        CustomFunction mulFn = (x, y) -> x * y;
        sol = new FindPositiveInteger ();
        System.out.println(sol.findSolution(mulFn, 5));

        // f(x,y) = x + y, z = 1  →  [] (min is f(1,1)=2)
        sol = new FindPositiveInteger ();
        System.out.println(sol.findSolution(addFn, 1));

        // f(x,y) = x * y, z = 12  →  [[1,12],[2,6],[3,4],[4,3],[6,2],[12,1]]
        sol = new FindPositiveInteger ();
        System.out.println(sol.findSolution(mulFn, 12));
    }
}
