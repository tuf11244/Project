/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;
import java.util.*;
/**
 *Date: 08/01/2024
 *https://leetcode.com/problems/maximal-square/
 * @author parth
 */
public class MaximalSquare {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int maximalSquare(char[][] matrix) {
         if (matrix.length == 0 || matrix[0].length == 0) return 0;

        int[][] dp = new int[matrix.length][matrix[0].length];
        int maxSide = 0;

        // Iterate from bottom-right to top-left
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                // Initialize the last row and last column
                if (i == matrix.length - 1 || j == matrix[0].length - 1) {
                    dp[i][j] = matrix[i][j] - '0'; // Convert char to int
                } else {
                    if (matrix[i][j] == '1') {
                        //Horizontal = dp[i][j+1]
                        //Vertical = dp[i+1][j]
                        //Diagonal = dp[i+1][j+1]
                        int min = Math.min(dp[i][j + 1], Math.min(dp[i + 1][j], dp[i + 1][j + 1]));
                        dp[i][j] = min + 1;
                    }
                }
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }

        // Debugging: print the dp matrix
        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }
        
        return maxSide * maxSide;
        
    }
}
