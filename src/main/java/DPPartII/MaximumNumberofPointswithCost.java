/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;
import java.util.*;
/**
 *Date: 08/16/2024
 * https://leetcode.com/problems/maximum-number-of-points-with-cost/
 * @author parth
 */
public class MaximumNumberofPointswithCost {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[][] points = {
            {1,2,3},
            {1,5,1},
            {3,1,1}
        };
        System.out.println(maxPoints(points));
    }
    
    public static long maxPoints(int[][] points) {
       int m = points.length, n = points[0].length;
        long[] prev = new long[n];

        // Initialize the first row
        for (int col = 0; col < n; col++) {
            prev[col] = points[0][col];
        }

        // Process each subsequent row
        for (int i = 1; i < m; i++) {
            long[] curr = new long[n];
            long[] left = new long[n];
            long[] right = new long[n];

            // Fill left array
            left[0] = prev[0];
            for (int j = 1; j < n; j++) {
                left[j] = Math.max(prev[j], left[j - 1] - 1);
            }

            // Fill right array
            right[n - 1] = prev[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                right[j] = Math.max(prev[j], right[j + 1] - 1);
            }

            // Calculate current row's maximum points
            for (int j = 0; j < n; j++) {
                curr[j] = points[i][j] + Math.max(left[j], right[j]);
            }

            // Update prev array for the next iteration
            prev = curr;
        }

        // Return the maximum value from the last row
        long max = Long.MIN_VALUE;
        for (long val : prev) {
            max = Math.max(max, val);
        }

        return max;
    }
    
    
   
}
