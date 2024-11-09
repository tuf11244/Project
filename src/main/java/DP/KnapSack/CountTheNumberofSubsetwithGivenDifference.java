/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP.KnapSack;
import java.util.*;
/**
 *Date: 11/08/2024
 * https://www.geeksforgeeks.org/count-of-subsets-with-given-difference/
 * Let sum of subset 1 be s1 and subset 2 with s2
    s1 - s2 = diff (given)
    s1 + s2=sum of array (logical)
    Therefore adding both eq we get :
    2s1= diff + sum of array
    s1= (diff + sum of array)/2;
    Problem reduces to find no of subsets with given sum**
 * @author parth
 */
public class CountTheNumberofSubsetwithGivenDifference {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[] arr = {1,1,2,3};
        int difference = 1;
        
        int answer = subsetWithGivenDifference(arr, difference);
        
        System.out.println(answer);
    }
    
    public static int subsetWithGivenDifference(int[] arr, int difference){
        int sum = 0;
        
        for(int num : arr){
            sum = sum + num;
        }
        int target = (difference + sum)/2;
        
        return helper(arr,target);
    }
    
    public static int helper(int[] arr, int target){
        int[][] dp = new int[arr.length +1][target + 1];
        
        for(int i = 0; i < dp.length;i++){
            for(int j = 0; j < dp[0].length;j++){
                
                //First cell 
                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                }
                //First Row
                else if(i == 0){
                    dp[i][j] = 0;
                }
                //First Column 
                else if(j == 0){
                    dp[i][j] = 1;
                }else{
                        int value = arr[i -1];
                        if(j >= value){
                           dp[i][j] = dp[i-1][j-value]  + dp[i-1][j];
                        }else{
                            // Exclude the current element
                            dp[i][j] = dp[i - 1][j];
                        }
                        
                    }
                }
            
        }
        
        for(int[] d : dp){
            System.out.println(Arrays.toString(d));
        }
        
        
        return dp[arr.length][target];
    }
}
