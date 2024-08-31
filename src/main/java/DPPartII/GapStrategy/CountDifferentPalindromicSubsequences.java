/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.GapStrategy;
import java.util.*;
/**
 *Date: 08/30/2024
 * https://leetcode.com/problems/count-different-palindromic-subsequences/
 * @author parth
 */
public class CountDifferentPalindromicSubsequences {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
     public int MOD = 1000000007;
     public int countPalindromicSubsequences(String s) {
        int[][] dp = new int[s.length()][s.length()];
        
        HashMap<Character,Integer> hm = new HashMap<>();
        int[] prev = new int[s.length()]; //stores the previous indexes of the character
        
        for(int i =0; i < s.length();i++){
            char ch = s.charAt(i);
            
            if(hm.containsKey(ch) == false){ //The means the character is not seen before 
                prev[i] = -1;
            }else{ //The means the character was seen before 
                prev[i] = hm.get(ch);
            }
            hm.put(ch,i); //update the index of the character 
        }
        
        hm.clear(); //Clear the hashMap 
        int[] next = new int[s.length()]; //stores the next indexes of the character 
        
        for(int i = s.length() - 1; i >= 0; i--){
            char ch = s.charAt(i);
            
            if(hm.containsKey(ch) == false){
                next[i] = -1;
            }else{
                next[i] = hm.get(ch);
            }
            hm.put(ch,i);
        }
        
         // Fill the DP table using a gap strategy
        for (int gap = 0; gap < dp.length; gap++) {
            for (int i = 0, j = gap; j < dp.length; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = 1; // Single character
                } else if (gap == 1) {
                    dp[i][j] = 2; // Two characters
                } else {
                    if (s.charAt(i) != s.charAt(j)) {
                        dp[i][j] = (int)((dp[i + 1][j] + dp[i][j - 1] - (long)dp[i + 1][j - 1] + MOD) % MOD);
                    } else {
                        int nextInd = next[i];
                        int prevInd = prev[j];

                        if (nextInd > prevInd) {
                            dp[i][j] = (int)((2L * dp[i + 1][j - 1] + 2) % MOD); //Case 1 : When no same character is present inside the middle part
                        } else if (nextInd == prevInd) {
                            dp[i][j] = (int)((2L * dp[i + 1][j - 1] + 1) % MOD); //Case 2 : When 1 same character is present inside the middle part 
                        } else {
                            dp[i][j] = (int)((2L * dp[i + 1][j - 1] - dp[nextInd + 1][prevInd - 1] + MOD) % MOD); //Case 3 : When more than 1 same character is present inside the middle part
                        }
                    }
                }
            }
        }

        // The result is the number of distinct palindromic subsequences in the entire string
        return dp[0][dp.length - 1];
    }
}
