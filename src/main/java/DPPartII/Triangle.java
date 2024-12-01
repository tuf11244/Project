/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;
import java.util.*;
/**
 *Date: 11/30/2024
 *https://leetcode.com/problems/triangle/
 * @author parth
 */
public class Triangle {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        // Initialize the base case (top of the triangle)
        dp[0][0] = triangle.get(0).get(0);

        // Fill the dp array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int value = triangle.get(i).get(j);

                if (j == 0) {
                    // Leftmost edge
                    dp[i][j] = dp[i - 1][j] + value;
                } else if (j == i) {
                    // Rightmost edge
                    dp[i][j] = dp[i - 1][j - 1] + value;
                } else {
                    // Middle elements
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + value;
                }
            }
        }

        // Find the minimum in the last row
        int answer = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            answer = Math.min(answer, dp[n - 1][j]);
        }

        return answer;
    }
    
   
}
