/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP;

/**
 *Date:07/17/2024
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * @author parth
 */
public class BestTimetoBuyandSellStocksTwoTransactions {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int maxProfit(int[] prices){
        
        int leastPrice = prices[0];
        int maxProfit = 0;
        int[] dpleft = new int[prices.length];
        
        for(int i = 1; i < prices.length;i++){
            leastPrice = Math.min(leastPrice,prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - leastPrice);
            
            dpleft[i] = Math.max(maxProfit, dpleft[i-1]);   
        }
        
        int maxSellPrice = prices[prices.length-1]; //last element
        int profit = 0;
        int[] dpright = new int[prices.length];
        for(int i = prices.length - 2; i >=0 ; i--){
            maxSellPrice = Math.max(maxSellPrice, prices[i]);
            profit = Math.max(profit,maxSellPrice - prices[i]);
            
            dpright[i] = Math.max(profit,dpright[i+1]);
        }
        
        int overallProfit = 0;
        
        for(int i = 0; i < prices.length;i++){
            overallProfit = Math.max(overallProfit, dpleft[i] + dpright[i]);
        }
        return overallProfit;
    }
}
