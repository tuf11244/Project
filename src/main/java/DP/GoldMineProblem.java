/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP;

/**
 *Date: 06/28/2024
 * https://www.geeksforgeeks.org/problems/gold-mine-problem2608/1?i
 * @author parth
 */
public class GoldMineProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int maxGold(int rows, int cols, int[][] goldMine){
        int[][] dp = new int[rows][cols];
        
        
        for(int j = goldMine[0].length - 1; j >= 0;j--){
            for(int i = goldMine.length - 1; i >= 0;i--){
                //Last Column 
                if(j == goldMine[0].length - 1){
                    dp[i][j] = goldMine[i][j];
                }
                //First Row
                else if(i == 0){
                    dp[i][j] = goldMine[i][j] + Math.max(dp[i][j+1],dp[i+1][j+1]);
                    
                }
                //Last Row
                else if(i == goldMine.length - 1){
                    dp[i][j] = goldMine[i][j] + Math.max(dp[i][j+1], dp[i-1][j+1]);
                }else{
                    dp[i][j] = goldMine[i][j] + Math.max(dp[i][j+1], Math.max(dp[i+1][j+1], dp[i-1][j+1]));
                }
            }
        }
        
        int maxGold = 0;
        
        for(int i = 0; i < rows;i++){
            maxGold = Math.max(maxGold,dp[i][0]);
        }
        return maxGold;
    }
}
