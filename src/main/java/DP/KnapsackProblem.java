/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP;
import java.util.*;
/**
 *Date: 07/02/2024
 * @author parth
 */
public class KnapsackProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[] values = {15,14,10,45,30};
        int[] weight = {2,5,1,3,4};
        
        System.out.println(knapSackProblem(values,weight,7));
     //  System.out.println(unboundedKnapSack(values,weight,13));
    }
    
    public static int  knapSackProblem(int[] values, int[] weight, int capacity){
        int[][] dp = new int[values.length + 1][capacity+1];
        
        /*In simple terms, the dp array in the knapsack problem represents a table where each cell 
            dp[i][j] holds the maximum value you can achieve using the first i items with a knapsack capacity of j.
        
        Rows (i): Each row represents the inclusion of items. The row index i indicates how many items are being considered.
        Row 2 represents considering the first two items, and so on.
        
        Columns (j): Each column represents different capacities of the knapsack. 
        The column index j indicates the capacity of the knapsack.
        Column 2 represents a capacity of 2 units, and so on, up to the maximum capacity of the knapsack.
        
        Cell dp[i][j]: The value in each cell represents the maximum value that 
                       can be achieved with the first i items and a knapsack capacity of j.
        
        */
        
        for(int i = 1; i < dp.length;i++){
            //We run the loops from i and j = 1 because 0th row and 0th column would be 
            //automatically zero
            for(int j = 1; j < dp[0].length;j++){
                if(j >= weight[i-1]){ // Case 2 : When we include the item in our knapsack
                    int remainingWeight = j - weight[i-1];
                    dp[i][j] = Math.max(dp[i-1][remainingWeight] + values[i-1],dp[i-1][j]);
   
                }else{
                     dp[i][j] = dp[i-1][j]; //Case 1: When we don't include the item in our knapsack 
                }
            }
        }
        
        for(int[] arr : dp){
            System.out.println(Arrays.toString(arr));
        }
        return dp[values.length][capacity];
    }
    
    
    //Unbounded KnapSack 
    public static int unboundedKnapSack(int[] values, int[] weight, int capacity){
        int[] dp = new int[capacity+1];
        
        
        for(int i = 0; i < dp.length;i++){
            for(int j = 0; j < weight.length;j++){
                if(weight[j] <= i){
                  //  System.out.println(i + "  " + j);
                    int remainingWgt = i - weight[j];
                    dp[i] = Math.max(dp[i],dp[remainingWgt]+values[j]);
                }
            }
        }
        
        System.out.println(Arrays.toString(dp));
        
        return dp[capacity];
    }
}
