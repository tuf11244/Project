/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package BinarySearchPracticeQuestions;
import java.util.*;
/**
 *Date: 12/10/2024
 * https://leetcode.com/problems/two-best-non-overlapping-events/
 * @author parth
 */
public class TwoBestNonOverlappingEvents {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int maxTwoEvents(int[][] events) {
        // Sort events by end time
        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));

        int n = events.length;
        int[] maxValues = new int[n];
        maxValues[0] = events[0][2];

        // Precompute max values up to each event
        for (int i = 1; i < n; i++) {
            maxValues[i] = Math.max(maxValues[i - 1], events[i][2]);
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            // Include the current event
            int currentValue = events[i][2];

            // Find the latest non-overlapping event using binary search
            int idx = binarySearch(events, i);
            if (idx != -1) {
                currentValue += maxValues[idx];
            }
            
            answer = Math.max(answer, currentValue);
        }

        return answer;
    }

    // Binary search to find the latest non-overlapping event
    private int binarySearch(int[][] events, int index) {
        int low = 0, high = events.length;
        int answer = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (events[mid][1] < events[index][0]) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer; // No non-overlapping event found
    }
}
