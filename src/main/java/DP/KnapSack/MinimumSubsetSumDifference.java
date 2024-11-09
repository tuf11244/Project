/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP.KnapSack;
import java.util.*;
/**
 *Date: 11/08/2024
 * Aditya Verma PlayList 
 * All the numbers in array are positive
 * @author parth
 */
public class MinimumSubsetSumDifference {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[] arr = {1,2,7};
        int answer = minSubsetSum(arr);
        System.out.println(answer);
    }
    
    public static int minSubsetSum(int[] arr){
        
        int sum = 0;
        for(int num : arr){
             sum = sum + num;
        }
        
        boolean [][] dp = new boolean[arr.length + 1][sum+1];
        
        fillTheDp(dp,arr);
        
        for(boolean[] ar : dp){
            System.out.println(Arrays.toString(ar));
        }
        
        int answer = Integer.MAX_VALUE;
        
        for(int i = 0; i <= sum/2;i++){
            if(dp[arr.length][i] == true){
                answer = Math.min(answer, sum - 2 * i);
            }
        }
        return answer;
    }
    public static void fillTheDp(boolean [][] dp, int[] arr){
        
        for(int i = 0; i < dp.length;i++){
            for(int j = 0; j < dp[0].length;j++){
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                }else if(i == 0){
                    dp[i][j] = false;
                }else if(j == 0){
                    dp[i][j] = true;
                }else{
                    
                    if(dp[i-1][j] == true){
                        dp[i][j] = true;
                    }else{
                        int value = arr[i-1];
                        
                        if(value <= j){
                           if(dp[i-1][j-value] == true){
                               dp[i][j] = true;
                           }
                        }
                    }
                }
            }
        }
    }
}
