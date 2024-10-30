/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;
import java.util.*;
/**
 *Date: 10/27/2024
 * https://leetcode.com/problems/maximum-number-of-moves-in-a-grid/
 * @author parth
 */
public class MaximumNumberofMovesinaGrid {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int maxMoves(int[][] grid) {
        
        int result = 0;
        int[][] dp = new int[grid.length][grid[0].length];
        
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        for(int i = 0; i < grid.length;i++){
            int x = dfs(grid,-1,i,0,dp);
            result = Math.max(result,x);
        }
        
        return result - 1;
    }
    
    public static int dfs(int[][] grid, int prev, int row, int col,int[][] dp){
        if(!isValid(grid,row,col)){
            return 0;
        }
        if(prev >= grid[row][col]){
            return 0;
        }
        
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        
        int horizontal = dfs(grid,grid[row][col],row,col+1,dp);
        int upDiagonal = dfs(grid,grid[row][col],row-1,col+1,dp);
        int Diagonal = dfs(grid,grid[row][col],row+1,col+1,dp);
        
        dp[row][col] = 1 + Math.max(horizontal,Math.max(upDiagonal, Diagonal));
        return  dp[row][col];
    }
    
    public static boolean isValid(int[][] grid, int row, int col){
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}
