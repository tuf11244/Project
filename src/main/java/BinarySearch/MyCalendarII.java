/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearch;
import java.util.*;
/**
 *Date: 09/26/2024
 * https://leetcode.com/problems/my-calendar-ii/
 * @author parth
 */
public class MyCalendarII {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
}
class MyCalendarTwo {
    List<int[]> bookings;
    List<int[]> overlaps;
    
    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlaps = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        // Check for overlap in the already double-booked intervals
        for (int[] overlap : overlaps) {
            if (overlap[0] < end && start < overlap[1]) {
                return false; // A triple booking occurs, reject the booking
            }
        }
        
        // Check for overlap with the single-booked intervals
        for (int[] booking : bookings) {
            if (booking[0] < end && start < booking[1]) {
                // Overlapping intervals found, store the overlap in the `overlaps` list
                overlaps.add(new int[]{Math.max(start, booking[0]), Math.min(end, booking[1])});
            }
        }
        
        // Add the new booking to the list of bookings
        bookings.add(new int[]{start, end});
        return true;
    }
}
