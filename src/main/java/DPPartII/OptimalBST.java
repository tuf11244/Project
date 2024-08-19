/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;

import java.util.Arrays;

/**
 *Date: 08/19/2024
 * https://www.geeksforgeeks.org/optimal-binary-search-tree-dp-24/
 * @author parth
 */
public class OptimalBST {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[] nodes = {10,20,30,40};
        int[] frequency = {3,1,2,1};
        
        System.out.println(optimalBST(nodes,frequency));
    }
    
    public static int optimalBST(int[] nodes, int[] frequency){
        int[][] dp = new int[nodes.length][nodes.length];
        
        //Prefix Sum Array 
        int[] prefixSum = new int[frequency.length];
        
        prefixSum[0] = frequency[0];
        
        for(int i = 1; i < prefixSum.length;i++){
            prefixSum[i] = prefixSum[i-1] + frequency[i];
        }
        for(int g = 0; g < dp.length;g++){
            for(int i = 0, j = g; j < dp.length;i++,j++){
                if(g == 0){
                    dp[i][j] = frequency[i];
                }else if(g == 1){
                    int option1 = frequency[i] + 2 * frequency[j];
                    int option2 = 2 * frequency[i] + frequency[j];
                    
                    dp[i][j] = Math.min(option1,option2);
                }else{
                    
                      // Sum of frequencies from i to j
                      int fs = prefixSum[j] - (i == 0 ? 0 : prefixSum[i-1]); //We can alos use a normal loop from i to j 
                                                                             //to calculate the sum of frequencies 
                      int min = Integer.MAX_VALUE;
                    for(int k = i;k <= j;k++){
                        int left = k == i ? 0 : dp[i][k-1];
                        int right = k == j ? 0 : dp[k+1][j];
                        int tc = left + right + fs;
                        
                        min = Math.min(min,tc);             
                    }
                    dp[i][j] = min;
                    
                }
            }
        }
        
        for(int[] arr : dp){
            System.out.println(Arrays.toString(arr));
    }
        return dp[0][dp.length - 1];
    }
}
