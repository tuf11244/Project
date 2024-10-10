/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;
import java.util.*;
/**
 *Date: 10/09/2024
 * https://leetcode.com/problems/insert-interval/
 * @author parth
 */
public class InsertInterval {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        // Merge intervals and the new interval into the result list.
        for (int[] interval : intervals) {
            // If the current interval ends before the new interval starts, add it to the result.
            if (interval[1] < newInterval[0]) {
                result.add(interval);
            } 
            // If the current interval starts after the new interval ends, add the new interval first, then replace it with the current interval.
            else if (interval[0] > newInterval[1]) {
                result.add(newInterval);
                newInterval = interval;
            } 
            // Overlapping case: merge the intervals.
            else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        // Add the final merged interval.
        result.add(newInterval);

        // Convert the result list to a 2D array.
        return result.toArray(new int[result.size()][]);
    }
}
