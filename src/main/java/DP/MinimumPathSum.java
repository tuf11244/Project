/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP;

/**
 *Date 06/27/2024
 *https://leetcode.com/problems/minimum-path-sum/
 * @author parth
 */
public class MinimumPathSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[][] grid = {
            {1,2,3},
            {4,5,6}
        };
        System.out.println(minPathSum(grid));
    }
    
    public static int minPathSum(int[][] grid){
        int[][] dp = new int[grid.length][grid[0].length];
        
        dp[0][0] = grid[0][0];
        
        for(int i = 0; i < dp.length;i++){
            for(int j =0; j < dp[0].length;j++){
                //both of them are valid
                if(i-1 >= 0 && j-1 >= 0){
                    dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
                }else if(i-1 >=0 && j-1 < 0){
                    dp[i][j] = grid[i][j] + dp[i-1][j];
                }else if(j-1 >= 0 && i-1 < 0){
                    dp[i][j] = grid[i][j] + dp[i][j-1];
                }else{
                    dp[i][j] = grid[i][j];
                }
                
            }
        }
        return dp[grid.length -1][grid[0].length -1];
            
        
    }
}
