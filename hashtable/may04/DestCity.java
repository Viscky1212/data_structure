package hashtable.may04;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DestCity {

    public String destCity(List<List<String>> paths){
        Set<String> sources = new HashSet<>();

        //step 1 : collect all source cities
        for (List<String> path : paths){
            sources.add(path.get(0));
        }

        //step 2 : find destination city
        for (List<String> path : paths){
            String dest = path.get(1);

            if (!sources.contains(dest)){
                return dest;
            }
        }
        return ""; //gauranteed not needed
    }

    public static void main(String[] args) {

        DestCity sol = new DestCity();

        List<List<String>> paths1 = Arrays.asList(
                Arrays.asList("London", "New York"),
                Arrays.asList("New York", "Lima"),
                Arrays.asList("Lima", "Sao Paulo")
        );

        System.out.println(sol.destCity(paths1)); // Sao Paulo

        List<List<String>> paths2 = Arrays.asList(
                Arrays.asList("B", "C"),
                Arrays.asList("D", "B"),
                Arrays.asList("C", "A")
        );

        System.out.println(sol.destCity(paths2)); // A
    }
}
