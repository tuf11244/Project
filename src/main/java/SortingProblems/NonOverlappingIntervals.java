/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package SortingProblems;
import java.util.*;
/**
 *Date: https://leetcode.com/problems/non-overlapping-intervals/
 * @author parth
 */
public class NonOverlappingIntervals {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
     public static int eraseOverlapIntervals(int[][] intervals) {
       if (intervals.length == 0) return 0;
        
        // Sort intervals by end time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        
        int answer = 0;
        int end = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                answer++;
            } else {
                end = intervals[i][1];
            }
        }
        
        return answer;   
}
    
}


