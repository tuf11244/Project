/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP;

/**
 *Date: 07/18/2024
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * @author parth
 */
public class BestTimetoBuyandSellStockwithTransactionFees {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int maxProfit(int[] prices, int fee){
        //Buy State indicates that you have one extra share ...can be bought on any day 
        //Sell State indicates that everything is setteled
        
        int obsp = -prices[0]; // Old buy state profit
        int ossp = 0; // Old sell state profit
        
        for(int i = 1; i < prices.length;i++){
            int nbsp = Math.max(ossp - prices[i],obsp); // New buy state profit
            int nssp = Math.max(obsp + prices[i] - fee, ossp); // New sell state profit
            
            obsp = nbsp;
            ossp = nssp;
        }
        
        return ossp;
    }
}
