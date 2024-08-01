/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP;
import java.util.*;
/**
 *Date: 06/29/2024
 * https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
 * @author parth
 */
public class SubsetSumProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
         int[] arr = {4,2,7,1,3};
        System.out.println(subsetSum(arr,10));
    }
    
    public static boolean subsetSum(int[] arr, int target){
        
        boolean[][] dp = new boolean[arr.length + 1][target+1];
        
        for(int i = 0; i < dp.length;i++){
            for(int j = 0; j < dp[0].length;j++){
                
                //First cell 
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                }
                //First Row
                else if(i == 0){
                    dp[i][j] = false;
                }
                //First Column 
                else if(j == 0){
                    dp[i][j] = true;
                }else{
                    
                    if(dp[i-1][j] == true){
                        dp[i][j] = true;
                    }else{
                        int value = arr[i -1];
                        if(j >= value){
                            if(dp[i-1][j - value] == true){
                                dp[i][j] = true;
                            }
                        }
                        
                    }
                }
            }
        }
        
        for(boolean[] row : dp){
            System.out.println(Arrays.toString(row));
        }
        return dp[arr.length][target];
    }
}
