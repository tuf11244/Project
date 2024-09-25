/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.LIS;
import java.util.*;
/**
 *Date: 09/24/2024
 * https://leetcode.com/problems/maximum-length-of-pair-chain/
 * @author parth
 */
public class MaximumLengthofPairChain {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public int findLongestChain(int[][] pairs) {
        
        // Sort by the second element of each pair
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int answer = 0;
        int[] dp = new int[pairs.length];

        for(int i = 0; i < dp.length;i++){
            int max = 0;
            for(int j = 0; j < i;j++){
                if(pairs[j][1] < pairs[i][0]){
                    max = Math.max(dp[j],max);
                }
            }
            dp[i] = max +1;
            answer = Math.max(answer,dp[i]);
        }
       
       return answer;
    }
    
     public int findLongestChainGreedy(int[][] pairs) {
        // Sort by the second element of each pair
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);

        int answer = 0;
        int currentEnd = Integer.MIN_VALUE;

        // Use greedy approach to count the longest chain
        for (int[] pair : pairs) {
            if (pair[0] > currentEnd) {
                answer++;
                currentEnd = pair[1]; // Update current end to the end of the selected pair
            }
        }

        return answer;
    }
}
