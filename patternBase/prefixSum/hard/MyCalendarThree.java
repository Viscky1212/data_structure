package patternBase.prefixSum.hard;

import java.util.TreeMap;
//sol = 3


//public class MyCalendarThree {
//    private TreeMap<Integer, Integer> timeline;
//
//    public MyCalendarThree() {
//        timeline = new TreeMap<>();
//    }
//
//    public int book(int start, int end) {
//        timeline.put(start, timeline.getOrDefault(start, 0) + 1);
//        timeline.put(end, timeline.getOrDefault(end, 0) - 1);
//
//        int maxOverlap = 0;
//        int currentOverlap = 0;
//        for (int count : timeline.values()) {
//            currentOverlap += count;
//            maxOverlap = Math.max(maxOverlap, currentOverlap);
//        }
//        return maxOverlap;
//    }
//
//    public static void main(String[] args) {
//        MyCalendarThree myCalendarThree = new MyCalendarThree();
//        myCalendarThree.book(10, 20);
//        myCalendarThree.book(50, 60);
//        myCalendarThree.book(10, 40);
//        myCalendarThree.book(5, 15);
//        myCalendarThree.book(5, 10);
//        myCalendarThree.book(25, 55);
//
//        System.out.println("Maximum number of overlapping events: " + myCalendarThree.getMaxOverlap());
//    }
//
//    private String getMaxOverlap() {
//        return "Maximum number of overlapping events: " + book(0, 0); // This is a placeholder, you would need to store the max overlap value
//    }
//}


import java.util.TreeMap;

class MyCalendarThree {

    private TreeMap<Integer, Integer> map;

    public MyCalendarThree() {
        map = new TreeMap<>();
    }

    public int book(int start, int end) {

        // Meeting starts
        map.put(start, map.getOrDefault(start, 0) + 1);

        // Meeting ends
        map.put(end, map.getOrDefault(end, 0) - 1);

        int current = 0;
        int maxBooking = 0;

        // Sweep Line
        for (int value : map.values()) {

            current += value;

            maxBooking = Math.max(maxBooking, current);
        }

        return maxBooking;
    }

    public static void main(String[] args) {

        MyCalendarThree cal = new MyCalendarThree();

        System.out.println(cal.book(10, 20)); // 1
        System.out.println(cal.book(50, 60)); // 1
        System.out.println(cal.book(10, 40)); // 2
        System.out.println(cal.book(5, 15));  // 3
        System.out.println(cal.book(5, 10));  // 3
        System.out.println(cal.book(25, 55)); // 3
    }
}