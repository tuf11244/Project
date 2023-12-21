/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;

/**
 * Date: 12/20/2023
 * https://leetcode.com/problems/count-number-of-homogenous-substrings/
 * @author parth
 */
public class CountNumberofHomogeneusSubstrings {
     public static long MOD = 1000_000_007;
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(countHomogenues("abbcccaa"));
    }
    public static int countHomogenues(String s){
        int index = 0;
        int count = 0;
        int result = 0;
        while(index < s.length()){
            
            if(index > 0 && s.charAt(index-1) == s.charAt(index)){
                count++;
            }else{
                //Found a new Character
                count = 1;
            }
            index++;
            result = (int) ((result + count) % MOD);
            
        }
        // Consider the last character
        //result = (int) ((result + (count * (count + 1)) / 2) % MOD);
         return result;
    }
}
