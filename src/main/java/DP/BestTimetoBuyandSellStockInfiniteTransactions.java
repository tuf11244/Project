/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP;

/**
 *Date: 07/17/2024
 * https://www.geeksforgeeks.org/stock-buy-sell/
 * @author parth
 */
public class BestTimetoBuyandSellStockInfiniteTransactions {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[] prices = {100,180,260,310,40,535,695};
        System.out.println(infiniteTrasactions(prices));
    }
    
    public static int infiniteTrasactions(int[] prices){
        
        int buy = 0;
        int sell = 0;
        int profit = 0;
        
        for(int i = 1; i < prices.length;i++){
            if(prices[i] >= prices[i-1]){
                sell++; //because the rates of the stock are increasing
            }else{
               profit = profit + (prices[sell] - prices[buy]);
               buy = i; //update the buy date
               sell = i; //update the sell date
            }
        }
        
        profit = profit + (prices[sell] - prices[buy]); //for the last increase 
        
        return profit;
    }
}
