/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.Kadane;

/**
 *Date: 10/05/2024
 * https://www.geeksforgeeks.org/max-sum-of-m-non-overlapping-subarrays-of-size-k/
 * @author parth
 */
public class MaximumSumofMNonOverlappingArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    //Recursion + Memoization
    public static int maxSum(int[] arr, int m, int k){
        
        int[] pSum = new int[arr.length];//This array would work like prefix sum array 
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum = sum + arr[i];
        }
        
        pSum[0] = sum; //Oth index would contain the sum of the first k elements 
        
        for(int i = k, j = 0; i < arr.length;i++,j++){
            sum = sum + arr[i] - arr[j];
            pSum[i-k+1] = sum;
        }
        
        return helperMaxSum(arr,0,m,k,pSum,new int[arr.length][m+1]);
    }
    
    public static int helperMaxSum(int[] arr, int index, int m, int k, int[] pSum, int[][] dp){
        if(m == 0){
            return 0;
        }
        if(index >= arr.length){
            return 0;
        }
        
        if(dp[index][m] != 0){
            return dp[index][m];
        }
        
        int exclude = 0 + helperMaxSum(arr,index+1,m,k,pSum,dp);
        int include = pSum[index] + helperMaxSum(arr,index+k,m-1,k,pSum,dp);
        
        dp[index][m] = Math.max(exclude,include);
        return Math.max(exclude,include);
    }
}
