/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearch;
import java.util.*;
/**
 *Date:09/25/2024
 * https://leetcode.com/problems/my-calendar-i/
 * @author parth
 */
public class MyCalendarI {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
}

class MyCalendar {
    List<Pair> list;

    public MyCalendar() {
        list = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        // Binary search to find the position to insert the new event
        int low = 0;
        int high = list.size();
        
        while (low < high) {
            int mid = (low + high) / 2;
            Pair p = list.get(mid);
            if (p.start >= end) {
                high = mid;
            } else if (p.end <= start) {
                low = mid + 1;
            } else {
                return false; // overlap found
            }
        }
        
        // No overlap found, insert the event in the correct position
        list.add(low, new Pair(start, end));
        return true;
    }
}

class Pair {
    int start;
    int end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

