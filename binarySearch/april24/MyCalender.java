package binarySearch.april24;

import java.util.ArrayList;
import java.util.List;

public class MyCalender {

    private List<int[]> bookings;

    public MyCalender(){
        bookings = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime){
        for (int[] booking : bookings){
            int start = booking[0];
            int end = booking[1];

            if (startTime < end && endTime > start) return  false;
        }
        bookings.add(new int[]{startTime,endTime});
        return true;
    }

    public static void main(String[] args) {
        MyCalender myCalendar = new MyCalender();
        System.out.println(myCalendar.book(10, 20)); // true
        System.out.println(myCalendar.book(15, 25)); // false
        System.out.println(myCalendar.book(20, 30)); // true
    }
}
