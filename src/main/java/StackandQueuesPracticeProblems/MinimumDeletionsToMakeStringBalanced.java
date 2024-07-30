/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;
import java.util.*;
/**
 *Date: 07/29/2024
 * https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/
 * @author parth
 */
public class MinimumDeletionsToMakeStringBalanced {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    //You can also do this in constant space 
    // You don't need to have stack ...you can just use variable to increase the count whenever there is b 
    //and use the same variable to decrease the count when ch == 'a'
    public static int minimumDeletions(String s){
        Stack<Character> st = new Stack<>();
        int count = 0;
        for(char ch : s.toCharArray()){
            if(ch == 'b'){
                st.add(ch);
            }else if(st.size() > 0 && ch == 'a'){
                st.pop();
                count++;
            }
        }
        return count;
    }
    
    //O(1) space
     public static int minimumDeletionsOptimized(String s) {
        int stack = 0;
        int res = 0;

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                stack++;
            } else if (stack > 0 && c == 'a') {
                stack--;
                res++;
            }
        }

        return res; 
    }
    
}
