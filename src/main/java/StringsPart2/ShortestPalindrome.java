/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StringsPart2;

/**
 *Date: 09/25/2024
 *https://leetcode.com/problems/shortest-palindrome/
 * @author parth
 */
public class ShortestPalindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public String shortestPalindrome(String s) {
        //Find the Reverse String First 
        StringBuilder sb = new StringBuilder();

        for(int i = s.length() -1; i >=0;i--){
            sb.append(s.charAt(i));
        }
        String rev = sb.toString();

        for(int i = 0; i < s.length();i++){

            if(s.substring(0,s.length()-i).equals(rev.substring(i))){
                return rev.substring(0,i) + s;
            }
        }

        return "";
    }
}
