package two_pointer_problem.march30;

import java.util.ArrayList;
import java.util.List;

public class CamelMatch {

    public List<Boolean> camelMatch(String[] queries, String pattern){
        List<Boolean> result = new ArrayList<>();

        for (String query : queries){
            result.add(isMatch(query,pattern));
        }
        return result;
    }


    public boolean isMatch(String query, String pattern){
        int i = 0; //pointer for query
        int j = 0;  //pointer for pattern

        while (i < query.length()){
            char qc = query.charAt(i);

            //MAtch cases
            if (j < pattern.length() && qc == pattern.charAt(j)){
                i++;
                j++;
            }

            //Extra lowercase allowed
            else if (Character.isLowerCase(qc)) {
                i++;
            }
            else {
                return false;
            }
        }

        //Pattern should be fully matched
        return j == pattern.length();
    }

    public static void main(String[] args) {
        CamelMatch sol = new CamelMatch();
        String[] queries = { "FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String pattern1 = "FB";
        String pattern2 = "FoBa";
        String pattern3 = "FoBaT";
        System.out.println("Output 1: " + sol.camelMatch(queries, pattern1));
        System.out.println("Output 2: " + sol.camelMatch(queries, pattern2));
        System.out.println("Output 3: " + sol.camelMatch(queries, pattern3));
    }
}
