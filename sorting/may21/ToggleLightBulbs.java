package sorting.may21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToggleLightBulbs {

    public  List<Integer> toggleLightBulbs(List<Integer> bulbs){
        boolean[] isOn = new boolean[101];

        for (int bulb : bulbs){
            isOn[bulb] = !isOn[bulb];
        }

        List<Integer> result = new ArrayList<>();

        for (int bulb = 1; bulb <= 100; bulb++) {
            if (isOn[bulb]){
                result.add(bulb);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ToggleLightBulbs sol = new ToggleLightBulbs();

        List<Integer> bulbs1 = Arrays.asList(10, 30, 20, 10);
        System.out.println(sol.toggleLightBulbs(bulbs1));
        // Output: [20, 30]

        List<Integer> bulbs2 = Arrays.asList(100, 100);
        System.out.println(sol.toggleLightBulbs(bulbs2));
        // Output: []

        List<Integer> bulbs3 = Arrays.asList(1);
        System.out.println(sol.toggleLightBulbs(bulbs3));
        // Output: [1]

        List<Integer> bulbs4 = Arrays.asList(1, 1, 1);
        System.out.println(sol.toggleLightBulbs(bulbs4));
        // Output: [1]

        List<Integer> bulbs5 = Arrays.asList(2, 2, 3, 3);
        System.out.println(sol.toggleLightBulbs(bulbs5));
        // Output: []
    }
}
