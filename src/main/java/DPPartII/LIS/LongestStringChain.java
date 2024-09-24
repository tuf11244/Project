/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.LIS;
import java.util.*;
/**
 *https://leetcode.com/problems/longest-string-chain/
 * @author parth
 */
public class LongestStringChain {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        String[] words = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        
        System.out.println(longestStrChain(words));
    }
    
    public static int longestStrChain(String[] words) {
         
        Arrays.sort(words,(a,b)-> a.length() - b.length()); //sort the array by the lengths
        //Also this the first lambda expression that I wrote by myself
        System.out.println(Arrays.toString(words));
        
        int[] dp = new int[words.length];
        int answer = 0;
        if(words.length == 1){
            return 1;
        }
        
        for(int i = 0; i < dp.length;i++){
            int max = 0;
            for(int j = 0; j < i;j++){
                if(isPredecessor(words[j],words[i])){
                    
                    max = Math.max(dp[j],max);
                }
            }
            dp[i] = max + 1;
            answer = Math.max(answer,dp[i]);
        }
        return answer;
    }
    
    
    public static boolean isPredecessor(String pred, String s){
        // Check if lengths differ by 1
    if (pred.length() + 1 != s.length()) {
        return false;
    }

    int i = 0, j = 0;
    boolean foundDifference = false;

    // Compare characters in both strings
    while (i < pred.length() && j < s.length()) {
        if (pred.charAt(i) != s.charAt(j)) {
            // If we found a difference and it's already found before, return false
            if (foundDifference) {
                return false;
            }
            foundDifference = true; // Mark that we found a difference
            j++; // Move j to skip one character in s
        } else {
            i++; // Move i in pred
            j++; // Move j in s
        }
    }

    return true; // If we exit the loop, it means pred is a predecessor of s
    }
    
    /*//This is my code is also passed
    public static boolean isPredecessor(String pred, String s){
        if (pred.length() + 1 != s.length()) {
        return false;
     }

        for(int i = s.length() - 1; i >= 0; i--){
            String temp = s.substring(0,i) + s.substring(i+1); //we are deleting the ith character;
            if(pred.equals(temp)){
                return true;
            }
        }
        return false;
        
    }
    */
}
