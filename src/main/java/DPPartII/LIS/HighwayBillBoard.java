/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.LIS;
import java.util.*;
/**
 *Date: 07/24/2024
 * https://www.geeksforgeeks.org/highway-billboard-problem/
 * @author parth
 */
public class HighwayBillBoard {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        
          // Example usage
        int X = 20;
        int[] positions = {6, 7, 12, 14};
        int[] revenue = {5, 6, 5, 1};
        int d = 5;

        int result = maxRevenueOptimized(X, positions, revenue, d);
        System.out.println("Max Revenue: " + result);
    }
    
    
    
    //Brute Force Complexity O(N^2)
    public static int maxRevenue(int X, int[] positions, int[] revenue, int d){
        int[] dp = new int[positions.length];
        dp[0] = revenue[0];
        
        int answer = 0;
        
        for(int i = 1; i < dp.length;i++){
            int max = 0;
            
            for(int j = 0; j < i;j++){
                int distance = positions[i] - positions[j];
                
                if(distance > d){
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + revenue[i];
            answer = Math.max(answer,dp[i]);
        }
        
        return answer;
    }
    
    //Optimized O(N)
    public static int maxRevenueOptimized(int X, int[] positions, int[] revenue, int d){
       int[] dp = new int[X + 1];
        HashMap<Integer, Integer> hm = new HashMap<>(); // map of positions vs revenue

        // Fill the hash map with positions and their corresponding revenues
        for (int i = 0; i < positions.length; i++) {
            hm.put(positions[i], revenue[i]);
        }

        // Initialize dp array
        dp[0] = 0;

        // Fill dp array
        for (int i = 1; i <= X; i++) {
            if (!hm.containsKey(i)) {
                // If there's no billboard at position i, take the value from the previous position
                dp[i] = dp[i - 1];
            } else {
                // If there's a billboard at position i
                int boardNotInstalled = dp[i - 1];
                int boardInstalled = hm.get(i);

                // If the current position is greater than d, consider the case of installing the billboard
                if (i >= d + 1) {
                    boardInstalled += dp[i - d - 1];
                }

                // Take the maximum of installing or not installing the billboard at position i
                dp[i] = Math.max(boardNotInstalled, boardInstalled);
            }
        }

        // The maximum revenue is found at the end of the highway
        return dp[X];
    }
}
