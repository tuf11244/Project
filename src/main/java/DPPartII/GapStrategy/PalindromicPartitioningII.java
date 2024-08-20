/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII.GapStrategy;

/**
 *Date: 08/14/2024
 *https://leetcode.com/problems/palindrome-partitioning-ii/
 * @author parth
 */
public class PalindromicPartitioningII {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    
    //Brute force O(n^3)
    public static int minCut(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        
        for(int g = 0; g < s.length();g++){
            for(int i = 0, j = g; j < s.length();i++,j++){
                    if(g == 0){ //single character 
                       dp[i][j] = true;   
                    }
                    else if(g == 1){ //two characters 
                        dp[i][j] = s.charAt(i) == s.charAt(j);
                        //above condition means if both the characters are same than its palindrome if they are not same 
                        //than its not a palindrom      
                    }else{
                        if(s.charAt(i) != s.charAt(j)){
                            dp[i][j] = false;
                        }else{
                            //Entering in this loop means the first and last characters are same
                            dp[i][j] = dp[i+1][j-1];
                        }
                    }
            }
        }
        
        int storage[][] = new int[s.length()][s.length()];
        
        for(int g = 0; g < s.length();g++){
            for(int i = 0,j = g; j < s.length();i++,j++){
                if(g == 0){
                    storage[i][j] = 0;
                }
                else if(g == 1){
                    
                    if(dp[i][j]){
                        storage[i][j] = 0; //i.e. the characters are same
                    }else{
                        storage[i][j] = 1; //character are different
                    }
                }else{
                    if(dp[i][j]){
                        storage[i][j] = 0;
                    }else{
                        int min = Integer.MAX_VALUE;
                         //K = is index where we cut 
                        for(int k = i; k < j;k++){
                            int left = storage[i][k];
                            int right = storage[k+1][j];
                            
                            min = Math.min(min,left+right+1); //+1 because of our own cut
                        }
                        
                        storage[i][j] = min;
                    }
                    
                }
            }
        }
        return storage[0][s.length()-1];
    }
    
    
    //Optimized Approach O(N^2) 
    
    public static int minCuts(String s){
        boolean dp[][] = new boolean[s.length()][s.length()];
        
        for(int g = 0; g < s.length();g++){
            for(int i = 0, j = g; j < s.length();i++,j++){
                    if(g == 0){ //single character 
                       dp[i][j] = true;   
                    }
                    else if(g == 1){ //two characters 
                        dp[i][j] = s.charAt(i) == s.charAt(j);
                        //above condition means if both the characters are same than its palindrome if they are not same 
                        //than its not a palindrom      
                    }else{
                        if(s.charAt(i) != s.charAt(j)){
                            dp[i][j] = false;
                        }else{
                            //Entering in this loop means the first and last characters are same
                            dp[i][j] = dp[i+1][j-1];
                        }
                    }
            }
        }
        
        int[] storage = new int[s.length()];
       storage[0] = 0;
       
       for(int j = 1; j < storage.length;j++){
           
           if(dp[0][j]){ //if the whole string is palindrome than enter 0 in our storage
               storage[j] = 0;
           }
           else
           {
           int min = Integer.MAX_VALUE;
           for(int i = j; i >=1 ; i--){
     
               if(dp[i][j]){ //Only call we dp[i][j] is true that is the String from index i t index j is palindrome
                   min = Math.min(min,storage[i-1]);
               }
           }
           storage[j] = min+1;
        }
        
       } 
     return storage[s.length() -1];  
    }
}
