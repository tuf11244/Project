/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP;

/**
 *Date: 07/04/2024
 * https://leetcode.com/problems/paint-house-ii/
 * 
 * There are a row of n houses, each house can be painted with one of the k colors. 
 * The cost of painting each house with a certain color is different. 
 * You have to paint all the houses such that no two adjacent houses have the same color.
 * The cost of painting each house with a certain color is represented by a n x k cost matrix. 
 * For example, costs[0][0] is the cost of painting house 0 with color 0; 
 * costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.
 * @author parth
 */
public class PaintHouseII {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[][] cost = {
            {1,5,7,2,1,4},
            {5,8,4,3,6,1},
            {3,2,9,7,2,3},
            {1,2,4,9,1,7}
        };
        
        int answer = paintHouseOptimized(cost);
        System.out.println(answer);
    }
    
    
    //Time Complexity : O(N^3)
    public static int paintHouse(int[][] cost){
        int[][] dp = new int[cost.length][cost[0].length];
        
        //The first row would be the same in our dp also 
        for(int j = 0; j < cost[0].length;j++){
         dp[0][j] = cost[0][j];   
        }
        
        //We start filling our dp from the 1st row 
        //i = house number 
        //j =  color number
        for(int i = 1; i < dp.length;i++){
            for(int j = 0; j < dp[0].length;j++){
                int min = Integer.MAX_VALUE;
                
                for(int k = 0; k < dp[0].length;k++){
                    if(k!=j){
                      min = Math.min(dp[i-1][k],min);
                    }
                }
              dp[i][j] = cost[i][j] + min;
            }
        }
        
        int answer = Integer.MAX_VALUE;
        
        for(int j = 0;  j < cost[0].length;j++){
            answer = Math.min(answer,dp[cost.length-1][j]); //as our answer would be present in the last row
        }
        return answer;
    }
    
    //Optimized Version O(N^2)
   public static int paintHouseOptimized(int[][] cost){
         int[][] dp = new int[cost.length][cost[0].length];
         
         int least = Integer.MAX_VALUE;
         int sleast = Integer.MAX_VALUE;
        //The first row would be the same in our dp also 
        for(int j = 0; j < cost[0].length;j++){
            dp[0][j] = cost[0][j];   
            
            if(cost[0][j] <= least){
                sleast = least;
                least = cost[0][j];
                
            }else if(cost[0][j] < sleast){
                sleast = cost[0][j];
            }
        }
        
        for(int i = 1; i < dp.length;i++){
            int nleast = Integer.MAX_VALUE; //new least
            int nsleast = Integer.MAX_VALUE; //new second least
            for(int j = 0; j < dp[0].length;j++){
                if(least == dp[i-1][j]){
                    dp[i][j] = cost[i][j] + sleast;
                }else{
                    dp[i][j] = cost[i][j] + least;
                }
                
                if(dp[i][j] <= nleast){
                    nsleast = nleast;
                    nleast = dp[i][j];  
                }else if(dp[i][j] < nsleast){
                    nsleast = dp[i][j];     
                }
            }
            
            least = nleast;
            sleast = nsleast;
        }
        
       return least;
       
   }
}
