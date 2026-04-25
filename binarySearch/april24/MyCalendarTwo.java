package binarySearch.april24;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarTwo {

    private List<int[]> bookings;
    private List<int[]> overlaps;

    public MyCalendarTwo(){
        bookings = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime){
        for (int[] overlap : overlaps){
            if (startTime < overlap[1] && endTime > overlap[0]) return false;
        }

        for (int[] booking : bookings){
            if (startTime < booking[1] && endTime > booking[0]){
                overlaps.add(new int[]{
                    Math.max(startTime,booking[0]),
                Math.min(endTime,booking[1])
                });
            }
        }

        bookings.add(new int[]{startTime,endTime});
        return true;
    }

    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();

        System.out.println(myCalendarTwo.book(10, 20)); // true
        System.out.println(myCalendarTwo.book(50, 60)); // true
        System.out.println(myCalendarTwo.book(10, 40)); // true
        System.out.println(myCalendarTwo.book(5, 15));  // false
        System.out.println(myCalendarTwo.book(5, 10));  // true
        System.out.println(myCalendarTwo.book(25, 55)); // true
    }


}
