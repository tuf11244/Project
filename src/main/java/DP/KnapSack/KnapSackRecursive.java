/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP.KnapSack;
import java.util.*;
/**
 *
 * @author parth
 */
public class KnapSackRecursive {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[] values = {15,14,10,45,30};
        int[] weight = {2,5,1,3,4};
        int capacity = 7;
        
        int[][] dp = new int[capacity+1][weight.length];
        
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        int answer = knapSack(values,weight,capacity,0,dp);
        System.out.println(answer);
    }
    
    //0-1 knapSack 
    public static int knapSack(int[] values, int[] weight, int capacity, int index,int[][] dp){
        if(index >= weight.length){
            return 0;
        }
        if(dp[capacity][index] !=-1){
            return dp[capacity][index];
        }
        int pick = 0;
        int skip = 0;
        
        if(weight[index] <= capacity){
            pick = values[index] + knapSack(values,weight,capacity - weight[index],index+1,dp);
        }
        skip = knapSack(values,weight,capacity,index +1,dp);
        
        return dp[capacity][index] = Math.max(pick, skip);
    }
    
    
    
}
