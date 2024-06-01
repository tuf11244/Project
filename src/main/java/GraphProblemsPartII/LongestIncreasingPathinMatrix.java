/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date: 05/31/2024
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 * @author parth
 */
public class LongestIncreasingPathinMatrix {

    /**
     * @param args the command line arguments
     */
   // public static int maxSteps;
    public static void main(String args[]) {
        // TODO code application logic here
        int[][] matrix = {
            {9,9,9},
            {6,6,8},
            {2,1,1}
        };
        System.out.println(longestIncreasingPath(matrix));
    }
    
    public static int longestIncreasingPath(int[][] matrix){
      int maxSteps = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                int steps = dfs(matrix, Integer.MIN_VALUE, i, j, new int[matrix.length][matrix[0].length]);
                maxSteps = Math.max(maxSteps, steps);
            }
        }
        return maxSteps;
    }
    public static int[][] directions = {
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };
    public static boolean isValid(int[][] matrix, int row, int col){
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
    
    public static int dfs(int[][] matrix, int prev, int row, int col, int[][] memo){
        if (!isValid(matrix, row, col) || matrix[row][col] <= prev) {
            return 0;
        }
        
        if (memo[row][col] != 0) {
            return memo[row][col];
        }
        
        int maxSteps = 1;
        for(int[] direction : directions){
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            
            int steps = 1 + dfs(matrix, matrix[row][col], newRow, newCol, memo);
            maxSteps = Math.max(maxSteps, steps);
        }
        
        memo[row][col] = maxSteps;
        return maxSteps;
    }
}
