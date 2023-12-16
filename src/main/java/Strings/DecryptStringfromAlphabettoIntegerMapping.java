/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Strings;

/**
 *https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
 * https://leetcode.com/problems/to-lower-case/
 * Date: 12/15/2023
 * @author parth
 */
public class DecryptStringfromAlphabettoIntegerMapping {

   
    public static void main(String args[]) {
        System.out.println(decrypt("10#11#12"));
        System.out.println(toLowerCase("Hello"));
    }
    public static String decrypt(String s){
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i < s.length()){
            
            //condition to check if i+2 is within the range
            // and the character at i+2 index is #
            if((i+2) < s.length() && s.charAt(i+2) == '#'){
                String str = s.substring(i,i+2);
                int temp = Integer.parseInt(str);
                //ASCII and typec casting knowledge required
                char ch = (char)(temp+96);
                sb.append(ch);
                //move the index 3 points ahead
                i = i+3;
            }else{
                char ch = s.charAt(i);
                sb.append((char)(ch+48));
                i++;
            }
        }
        return sb.toString();
    }
    
    public static String toLowerCase(String s){
        return s.toLowerCase();
    }
    
}
