/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Strings;

/**
 *https://leetcode.com/problems/shuffle-string/
 * Date: 12/15/2023
 * @author parth
 */
public class ShuffleString {

    
    public static void main(String args[]) {
        int[] indices = {4,5,6,7,0,2,1,3};
        String s = "codeleet";
        System.out.println(restoreString(s,indices));  
    }
    public static String restoreString(String s, int[] indices){
        char[] ch = new char[s.length()];
        for(int i = 0; i < s.length();i++){
           ch[indices[i]] = s.charAt(i);
        }
        return new String(ch);
    }
}
