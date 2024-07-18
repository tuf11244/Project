/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP;

/**
 *https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *Date: 07/17/2024
 * @author parth
 */
public class BestITimetoBuyandSellStock {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int buy = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            buy = Math.min(buy, prices[i]);
            profit = Math.max(profit, prices[i] - buy);
        }

        return profit;
    }
}
