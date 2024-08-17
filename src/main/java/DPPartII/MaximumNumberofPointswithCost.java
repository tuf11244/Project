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
        int rows = points.length;
        int cols = points[0].length;
        long[] dp = new long[cols]; // To store the max points for the previous row
        long[] leftMax = new long[cols];
        long[] rightMax = new long[cols];

        // Initialize dp with the first row values
        for (int j = 0; j < cols; j++) {
            dp[j] = points[0][j];
        }

        // Iterate over each row starting from the second one
        for (int i = 1; i < rows; i++) {
            // Calculate leftMax array
            leftMax[0] = dp[0]; // First element remains the same
            for (int j = 1; j < cols; j++) {
                leftMax[j] = Math.max(leftMax[j - 1], dp[j] + j);
            }

            // Calculate rightMax array
            rightMax[cols - 1] = dp[cols - 1] - (cols - 1); // Last element remains the same
            for (int j = cols - 2; j >= 0; j--) {
                rightMax[j] = Math.max(rightMax[j + 1], dp[j] - j);
            }

            // Update dp for the current row
            for (int j = 0; j < cols; j++) {
                dp[j] = points[i][j] + Math.max(leftMax[j] - j, rightMax[j] + j);
            }
        }

        // The answer will be the maximum value in dp array after processing all rows
        long answer = 0;
        for (int j = 0; j < cols; j++) {
            answer = Math.max(answer, dp[j]);
        }

        return answer; 

    }
}
