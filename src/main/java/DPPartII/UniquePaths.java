/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;
import java.util.*;
/**
 *Date: 11/29/2024
 * https://leetcode.com/problems/unique-paths/
 * @author parth
 */
public class UniquePaths {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
     public int [][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m+1][n+1];

        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return helper(0,0,m,n);
    }
     public int helper(int row, int column, int m, int n){
        if(row == m -1 && column == n -1){
            return 1;
        }
        int right =0;
        int down = 0;
       if(dp[row][column] != -1){
           return dp[row][column];
       }
       if(row < m-1){
           down = helper(row+1,column,m,n);
       } 
        if(column < n-1){
           right = helper(row,column+1,m,n);
       }    

       dp[row][column] = right + down;   
        return right + down;
    }
}
