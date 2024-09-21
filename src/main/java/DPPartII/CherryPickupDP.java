/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;

/**
 *Date: 09/18/2024
 *https://leetcode.com/problems/cherry-pickup/
 * @author parth
 */
public class CherryPickupDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
     public static int cherryPickup(int[][] grid) {
         int n = grid.length;
         int[][][][] dp = new int[n][n][n][n];
         
         //We took 4D dp because r1, c1, r2, c2 are all variable
         
         // Initialize the dp array to -1 (indicating uncalculated states)
       for (int i = 0; i < n; i++) {
           for (int j = 0; j < n; j++) {
               for (int k = 0; k < n; k++) {
                   for (int l = 0; l < n; l++) {
                       dp[i][j][k][l] = -1;
                   }
               }
           }
       }
        int result = helper(0,0,0,0,grid,dp);
        
        // If the result is negative, it means no valid path exists
        return Math.max(0,result) ;

    }
     public static int helper(int r1, int c1, int r2, int c2, int[][] grid, int[][][][] dp){
         //Base cases
         if(r1 >= grid.length || r2 >= grid.length || c1 >= grid[0].length || c2 >= grid[0].length || grid[r1][c1] == -1
                 || grid[r2][c2] == -1){
             return Integer.MIN_VALUE; //These paths don;t exist so instead we return negative infinity
         }
         
         if(r1 == grid.length- 1 && c1 == grid[0].length - 1){
             // Only one person can be at the destination at a time
            return grid[r1][c1];
         }
         
         // If this state has already been calculated
         if(dp[r1][c1][r2][c2] != -1){
             return dp[r1][c1][r2][c2];
         }
         int cherry = 0;
         // Collect cherries at the current positions, avoid double-counting
         if(r1 == r2 && c1 == c2){ //if they are on the same spots
             cherry = cherry + grid[r1][c1];
         }else { //if they are different spots 
             cherry = cherry + grid[r1][c1] + grid[r2][c2];
         }
         
         // Explore all 4 possible moves
         int f1 = helper(r1, c1 + 1, r2, c2 + 1, grid, dp); // Both go right
         int f2 = helper(r1 + 1, c1, r2, c2 + 1, grid, dp); // First goes down, second goes right
         int f3 = helper(r1 + 1, c1, r2 + 1, c2, grid, dp); // Both go down
         int f4 = helper(r1, c1 + 1, r2 + 1, c2, grid, dp); // First goes right, second goes down
         
         // Take the maximum valid move
         int maxCherries = Math.max(Math.max(f1, f2), Math.max(f3, f4));
         
         // If all moves return Integer.MIN_VALUE, it means no valid path is available
         if (maxCherries == Integer.MIN_VALUE) {
             dp[r1][c1][r2][c2] = Integer.MIN_VALUE;
             return Integer.MIN_VALUE;
         }
         
         // Update dp array and return the total cherries collected
         dp[r1][c1][r2][c2] = cherry + maxCherries;
         return dp[r1][c1][r2][c2];
     }
     
     
     
     //We can also do this in 3D dp 
     //You don't need to explicitly track c2 because it can be computed as c2 = r1 + c1 - r2.
     public static int helper(int r1, int c1, int r2, int[][] grid, int[][][] dp) {
        int c2 = r1 + c1 - r2; // Calculate c2 based on r1, c1, and r2
        
        // Base cases: Out of bounds or hitting a thorn (-1)
        if (r1 >= grid.length || r2 >= grid.length || c1 >= grid[0].length || c2 >= grid[0].length || 
            grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE; // Invalid path
        }
        
        // If both persons reach the bottom-right corner
        if (r1 == grid.length - 1 && c1 == grid[0].length - 1) {
            return grid[r1][c1]; // Only one person can be at the destination at a time
        }
        
        // If this state has already been calculated
        if (dp[r1][c1][r2] != -1) {
            return dp[r1][c1][r2];
        }
        
        int cherry = 0;
        
        // Collect cherries at the current positions, avoid double-counting
        if (r1 == r2 && c1 == c2) {
            cherry += grid[r1][c1];
        } else {
            cherry += grid[r1][c1] + grid[r2][c2];
        }
        
        // Explore all 4 possible moves
        int f1 = helper(r1, c1 + 1, r2, grid, dp);      // Both go right
        int f2 = helper(r1 + 1, c1, r2, grid, dp);      // First goes down, second stays
        int f3 = helper(r1, c1 + 1, r2 + 1, grid, dp);  // First goes right, second goes down
        int f4 = helper(r1 + 1, c1, r2 + 1, grid, dp);  // Both go down
        
        // Take the maximum valid move
        int maxCherries = Math.max(Math.max(f1, f2), Math.max(f3, f4));
        
        // If all moves return Integer.MIN_VALUE, it means no valid path is available
        if (maxCherries == Integer.MIN_VALUE) {
            dp[r1][c1][r2] = Integer.MIN_VALUE;
            return Integer.MIN_VALUE;
        }
        
        // Update dp array and return the total cherries collected
        dp[r1][c1][r2] = cherry + maxCherries;
        return dp[r1][c1][r2];
    }
}
