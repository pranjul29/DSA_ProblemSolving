/*
Source: https://leetcode.com/problems/my-calendar-i/
You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a double booking.

A double booking happens when two events have some non-empty intersection (i.e., some moment is common to both events.).

The event can be represented as a pair of integers start and end that represents a booking on the half-open interval [start, end), the range of real numbers x such that start <= x < end.

Implement the MyCalendar class:

1) MyCalendar() Initializes the calendar object.
2) boolean book(int start, int end) Returns true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.

Example 1:

Input
["MyCalendar", "book", "book", "book"]
[[], [10, 20], [15, 25], [20, 30]]
Output
[null, true, false, true]

Explanation
MyCalendar myCalendar = new MyCalendar();
myCalendar.book(10, 20); // return True
myCalendar.book(15, 25); // return False, It can not be booked because time 15 is already booked by another event.
myCalendar.book(20, 30); // return True, The event can be booked, as the first event takes every time less than 20, but not including 20.

Example 2:
Input:
["MyCalendar","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book"]
[[],[97,100],[33,51],[89,100],[83,100],[75,92],[76,95],[19,30],[53,63],[8,23],[18,37],[87,100],[83,100],[54,67],[35,48],[58,75],[70,89],[13,32],[44,63],[51,62],[2,15]]
Output:
[null,true,true,false,false,true,false,true,true,false,false,false,false,false,false,false,false,false,false,false,true]

Example 3:
Input:
["MyCalendar","book","book","book","book","book"]
[[],[37,50],[33,50],[4,17],[35,48],[8,25]]
Output:
[null,true,false,true,false,false]

Example 4:
Input:
["MyCalendar","book","book","book","book","book","book","book","book","book","book"]
[[],[47,50],[33,41],[39,45],[33,42],[25,32],[26,35],[19,25],[3,8],[8,13],[18,27]]
Output:
[null,true,true,false,false,true,false,true,true,true,false]

Constraints:

1) 0 <= start < end <= 10^9
2) At most 1000 calls will be made to book
*/
import java.util.*;
class MyCalendar {
    ArrayList<ArrayList<Integer>> bookings;
    public MyCalendar() {
        bookings = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int i = 0;i<bookings.size();i++)
        {
            int start_time = bookings.get(i).get(0);
            int end_time = bookings.get(i).get(1);
            if(start < end_time && start>=start_time)
                return false;
            else if(end < end_time && end>=start_time)
                return false;
        }
        ArrayList<Integer> booking = new ArrayList<Integer>();
        booking.add(start);
        booking.add(end);
        bookings.add(booking);
        return true;
    }
}
public class MyCalendarI {
    public static void main(String[] args)
    {
        MyCalendar calendar = new MyCalendar();
        System.out.println(calendar.book(10,20));
        System.out.println(calendar.book(15,25));
        System.out.println(calendar.book(20,30));
    }
}
