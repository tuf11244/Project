/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;
import java.util.*;
/**
 *https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/
 * @author parth
 */
public class MinimumNumberofSwapstoMakeStringBalanced {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int minSwaps(String s) {
        
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) == '['){
                st.add(s.charAt(i));
            }else if(!st.isEmpty() && s.charAt(i) == ']'){
                st.pop();
            }
        }
        
        return (st.size() + 1)/2;
    }
}
