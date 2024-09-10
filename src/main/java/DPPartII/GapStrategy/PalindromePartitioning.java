/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.GapStrategy;
import java.util.*;
/**
 *Date: 09/09/2024
 *https://leetcode.com/problems/palindrome-partitioning/
 * @author parth
 */
public class PalindromePartitioning {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int g = 0; g < dp.length;g++){
            for(int i = 0, j = g; j < dp.length;i++,j++){
                if(g == 0){
                    dp[i][j] = true;
                }else if(g == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }else{
                    char ch1 = s.charAt(i);
                    char ch2 = s.charAt(j);

                    if(ch1 == ch2){
                        dp[i][j] = dp[i+1][j-1];
                    }else{
                        dp[i][j] = false;
                    }
                }
            }
        }
        // Start DFS to explore all possible partitions
        dfs(0, s, dp, new ArrayList<>(), result);
        return result;

    }

    private void dfs(int start, String s, boolean[][] dp, List<String> currentPartition, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(currentPartition)); // Found a valid partition, add to result
            return;
        }
        
        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) { // If substring s[start:end+1] is a palindrome
                currentPartition.add(s.substring(start, end + 1)); // Choose the partition
                dfs(end + 1, s, dp, currentPartition, result); // Explore further partitions
                currentPartition.remove(currentPartition.size() - 1); // Backtrack
            }
        }
    }
}
