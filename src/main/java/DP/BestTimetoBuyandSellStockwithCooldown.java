/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP;

/**
 *Date: 07/18/2024
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * @author parth
 */
public class BestTimetoBuyandSellStockwithCooldown {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static  int maxProfit(int[] prices) {
        
        int obsp = - prices[0];
        int ossp = 0;
        int ocsp = 0;
        
        for(int i = 1;i < prices.length;i++){
            int nbsp = Math.max(obsp, ocsp - prices[i]);
            int nssp = Math.max(ossp,obsp + prices[i]);
            int ncsp = Math.max(ocsp,ossp);
            
            obsp = nbsp;
            ossp = nssp;
            ocsp = ncsp;
        }
        
        return ossp;
        
    }
}
