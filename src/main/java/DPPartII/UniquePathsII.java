/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;
import java.util.*;
/**
 *Date: 11/29/2024
 * https://leetcode.com/problems/unique-paths-ii/
 * @author parth
 */
public class UniquePathsII {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
           if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length - 1] == 1){
               return 0;
           }
           dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];

           for(int[] arr : dp){
              Arrays.fill(arr,-1);
           }
            return uniquePathsII(obstacleGrid,0,0);
    }
      public int uniquePathsII(int[][] board,int row, int column){
        if(row == board.length-1 && column == board[0].length-1){
            return 1;
        }
        if(board[row][column] == 1){
            return 0;
        }

        if(dp[row][column] != -1){
            return dp[row][column];
        }
        int right = 0;
        int down = 0;
        if(row < board.length-1){
            down = uniquePathsII(board,row+1,column);
        }
        if(column < board[0].length-1){
            right = uniquePathsII(board,row,column+1);
        }
        dp[row][column] = right + down;
        return right+down;
    }
}
