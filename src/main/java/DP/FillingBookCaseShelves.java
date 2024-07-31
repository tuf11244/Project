/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DP;
import java.util.*;
/**
 *Date: 07/30/2024
 * https://leetcode.com/problems/filling-bookcase-shelves/
 * @author parth
 */
public class FillingBookCaseShelves {
 public int WIDTH;
 public int[][] dp;
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    
    public int minHeightShelves(int[][] books, int shelfWidth) {
            int n = books.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int width = 0;
            int height = 0;
            for (int j = i; j > 0; j--) {
                width += books[j - 1][0];
                if (width > shelfWidth) {
                    break;
                }
                height = Math.max(height, books[j - 1][1]);
                dp[i] = Math.min(dp[i], dp[j - 1] + height);
            }
        }

        return dp[n];
    }
    
    public int MinHeightShelvesMemo(int[][] books, int shelfWidth){
        WIDTH = shelfWidth;
        dp = new int[1001][1001];
        
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return  memo(books,0,shelfWidth,0);
    }
    
    public int memo(int[][] books,int index, int remainingWidth, int height){
        if(index >= books.length){
            return height;
        }
        
        if(dp[index][remainingWidth] != -1){
            return dp[index][remainingWidth];
        }
        
        int currentWidth = books[index][0];
        int currentHeight = books[index][1];
        
        int keep  = Integer.MAX_VALUE;
        int skip = Integer.MAX_VALUE;
        
        //Keep in the current shelf 
        if(currentWidth <= remainingWidth){
            keep = memo(books,index+1,remainingWidth - currentWidth,Math.max(height,currentHeight));
        }
        
        //skip and put it in the next shelf 
          skip = height + memo(books,index+1,WIDTH - currentWidth,currentHeight);
          
          dp[index][remainingWidth] = Math.min(keep, skip);
          
          return Math.min(keep, skip);
    }
}
