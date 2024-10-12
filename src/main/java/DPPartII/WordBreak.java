/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;
import java.util.*;
/**
 *Date: 11/21/2024
 * https://leetcode.com/problems/word-break/
 * @author parth
 */
public class WordBreak {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    
    //Bottom up approach
    public boolean wordBreak(String s, List<String> wordDict) {
        
        HashSet<String> set = new HashSet<>();

        for(String str : wordDict){
            set.add(str);
        }
        int[] dp = new int[s.length()];
       
        helper(dp,s,set);

        return dp[s.length()-1] > 0;
    }

    public void helper(int[] dp, String s, HashSet<String> set){

        for(int i = 0; i < dp.length;i++){
            
            for(int j = 0; j <= i;j++){

                String word = s.substring(j,i+1);

                if(set.contains(word)){
                    if(j > 0){
                    dp[i] = dp[i] + dp[j-1];
                    }else{
                        dp[i] = dp[i] + 1;
                    }
                }
            }
        }
    }
    
    
    //Recursion plus memoization
    public boolean wordBreakRecurssion(String s, List<String> wordDict){
      
        Boolean [] dp = new Boolean[s.length()];
        
        return helperII(0,s,wordDict,dp);
      
    }
    
    public boolean helperII(int idx, String s, List<String> wordDict, Boolean[] dp){
        if(idx == s.length()){
            return true;
        }
        
        if(dp[idx] != null){
            return dp[idx];
        }
        
        for(int j = idx + 1; j <= s.length();j++){
            String split = s.substring(idx,j);
            
            if(wordDict.contains(split) && helperII(j,s,wordDict,dp)){
                
                dp[idx] = true;
                return true;
            }
        }
        
        dp[idx] = false;
        
        return false;
    }
            
}
