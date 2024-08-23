/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.GapStrategy;
import java.util.*;
/**
 *Date: 08/22/2024
 *https://www.geeksforgeeks.org/count-palindromic-subsequence-given-string/
 * @author parth
 */
public class CountAllPalindromicSubsequences {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        System.out.println(palindromicSubsequences("abcd"));
    }
    
    public static int palindromicSubsequences(String s){
        int[][] dp = new int[s.length()][s.length()];
        
        for(int g = 0; g < dp.length;g++){
            for(int i = 0, j = g; j < dp.length;i++,j++){
                if(g == 0){
                    dp[i][j] = 1;
                }else if(g == 1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 3;
                    }else{
                        dp[i][j] = 2;
                    }
                    
                }else{
                    /*
                    If s[i] == s[j], then dp[i][j] = dp[i+1][j] + dp[i][j-1] + 1 
                    because you add one new palindrome formed by the characters at positions i and j
                    */
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = dp[i][j-1] + dp[i+1][j] + 1;
                     /*
                    If s[i] != s[j], then dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1] 
                    because you exclude the overlapping middle part to avoid counting it twice.   
                     */
                    }else{
                        dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
                    }
                    
                }
            }
        }
        
        for(int[] arr : dp){
            System.out.println(Arrays.toString(arr));
        }
        return dp[0][dp.length -1];
    }
}
