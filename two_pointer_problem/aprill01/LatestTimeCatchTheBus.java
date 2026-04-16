package two_pointer_problem.aprill01;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LatestTimeCatchTheBus {

    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity){
        Arrays.sort(buses);
        Arrays.sort(passengers);

        int j = 0;
        int last = -1;

        //Simulate boarding
        for (int i = 0; i < buses.length; i++) {
            int count = 0;
            while (j < passengers.length && passengers[j] <= buses[i] && count < capacity){
                last = passengers[j];
                j++;
                count++;
            }

            //For last bus --> decide answer
            if (i == buses.length -1){
                int candidate;
                if (count < capacity){
                    candidate = buses[i];
                } else candidate = last - 1;

                //To avoid collision
                Set<Integer> set = new HashSet<>();
                for (int p : passengers ) set.add(p);
                while (set.contains(candidate)) candidate--;
                return candidate;
            }
        }
        return -1;
    }

//    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity){
//        Arrays.sort(buses);
//        Arrays.sort(passengers);
//        int j = 0; //passenger pointer
//
//        //Simulate boarding process
//        for (int i = 0; i < buses.length; i++) {
//            int count = 0;
//            while (j < passengers.length && passengers[j] <= buses[i] && count < capacity){
//                j++;
//                count++;
//            }
//        }
//
//        int lastBus = buses[buses.length - 1];
//
//        //To check how many boarded last bus
//        int count = 0;
//        int idx = j - 1;
//
//        while (idx >= 0 && passengers[idx] <= lastBus && count < capacity){
//            idx--;
//            count++;
//        }
//        int candidate;
//        if (count < capacity){
//            candidate = lastBus;
//        } else {
//            candidate = passengers[j - 1] - 1;
//        }
//
//        //To avoid collision
//        Set<Integer> set = new HashSet<>();
//        for (int p : passengers) set.add(p);
//
//        while (set.contains(candidate)) candidate--;
//        return candidate;
//    }


    public static void main(String[] args) {
        LatestTimeCatchTheBus sol = new LatestTimeCatchTheBus();
        int[] buses1 = {10,20};
        int[] passengers1 = {2,17,18,19};
        int capacity1 = 2;

        int[] buses2 = {20,30,10};
        int[] passengers2 = {19,13,26,4,25,11,21};
        int capacity2 = 2;

        System.out.println("Output 1: " + sol.latestTimeCatchTheBus(buses1, passengers1, capacity1)); // 16
        System.out.println("Output 2: " + sol.latestTimeCatchTheBus(buses2, passengers2, capacity2)); // 20
    }
}
