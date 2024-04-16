/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HashMapsSlidingWindow;

import java.util.HashMap;

/**
 *Date: 04/16/2024
 * https://leetcode.com/problems/find-the-longest-semi-repetitive-substring/
 * @author parth
 */
public class FindtheLongestRepetitiveSubstring {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(longestSemiRepetitiveSubstring("555"));
    }
    public static int longestSemiRepetitiveSubstring(String s){
      int j=0,maxLength = 1,pairs=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                pairs++;
            }
            if(pairs>=2){
                while(j<i && pairs>1){
                    if(s.charAt(j)==s.charAt(j+1)){
                        pairs--;
                    }
                    j++;
                }
            }
            maxLength=Math.max(maxLength,i-j+1);
        }
        return maxLength;        
    }
}
