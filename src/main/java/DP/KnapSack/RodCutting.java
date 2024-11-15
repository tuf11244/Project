/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP.KnapSack;

/**
 *Date: 08/14/2024
 * @author parth
 */
public class RodCutting {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    //Optimized Strategy or Left and Right Strategy
    public static int rodCutting(int[] prices){
        //We are just shifting the prices array to 1-based indexing
        int[] np = new int[prices.length + 1];
        
        for(int i = 0; i < np.length;i++){
            np[i+1] = prices[i];
        }
        
        int[] dp = new int[np.length];
        
        dp[0] = 0;
        dp[1] = np[1];
        
        for(int i = 2; i < dp.length;i++){
            dp[i] = np[i]; //Start with the profit by selling the rod as a whole
            
            int left = 1;
            int right = i-1;
            
            /*
            You can also use below code if you don't want to use left and right pointers 
            
            for (int j = 1; j <= i / 2; j++) {
            dp[i] = Math.max(dp[i], dp[j] + dp[i - j]);
            }
            */
            
            while(left <= right){
                dp[i] = Math.max(dp[i],dp[left] + dp[right]);
                left++;
                right--;
            }
        
    }
        return dp[dp.length - 1];
        
    }
    
    //O(n^2) time and Cut Strategy
    public static int rodCuttingCutStrategy(int[] prices) {
    int n = prices.length;
    int[] dp = new int[n + 1];

    dp[0] = 0; // No profit for rod of length 0

    // Fill dp array with maximum profit values
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= i; j++) {
            dp[i] = Math.max(dp[i], prices[j - 1] + dp[i - j]);
        }
    }

    return dp[n];
}

}
