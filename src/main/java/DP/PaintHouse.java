/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP;

/**
 *Date: 07/03/2024
 * https://leetcode.com/problems/paint-house/
 * 
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. 
 * The cost of painting each house with a certain color is different. 
 * You have to paint all the houses such that no two adjacent houses have the same color.
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix. 
 * For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, 
 * and so on... Find the minimum cost to paint all houses.
 * @author parth
 */
public class PaintHouse {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int cost[][] = {
            {17,2,17},
            {16,16,5},
            {14,3,19}
        };
        
        System.out.println(minCost(cost));
    }
    
    public static int minCost(int[][] cost){
        
        long [][] dp = new long[cost.length][3];
        
        dp[0][0] = cost[0][0]; //applied red color on the 0th house
        dp[0][1] = cost[0][1]; //applied blue color on the 0th house
        dp[0][2] = cost[0][2]; //applied green color on the 0th house
        
        for(int i = 1; i < cost.length;i++){
            dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]); //Chose to paint it red 
            dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]); //Chose to paint it blue
            dp[i][2] = cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]); //Chose to paint it green
        }
        
        long answer = Math.min(dp[cost.length - 1][0], Math.min(dp[cost.length - 1][1], dp[cost.length -1][2]));
        
        return (int) answer;
    }
}
