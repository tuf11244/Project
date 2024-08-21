/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.GapStrategy;
import java.util.*;
/**
 *Date: 08/20/2024
 *https://leetcode.com/problems/strange-printer/
 * @author parth
 */
public class StrangePrinter {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        System.out.println(strangePrinter("aaabbb"));
    }
    public static int strangePrinter(String s) {
        int[][] dp = new int[s.length()][s.length()];
        
        for(int g = 0; g < dp.length;g++){
            for(int i = 0, j = g; j < dp.length;i++,j++){
                if(g == 0){ //singe character
                  dp[i][j] = 1;  
                }else if(g == 1){ //two character
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = 1;
                    }else{
                        dp[i][j] = 2;
                    }
                    
                }else {
                    int min = Integer.MAX_VALUE;
                    for(int k = i; k < j;k++){
                        int left = dp[i][k];
                        int right = dp[k+1][j];
                        min = Math.min(min,left + right);
                    }
                    dp[i][j] = min;
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = dp[i][j] - 1;
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
