/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

import java.util.ArrayList;

/**
 *https://leetcode.com/problems/generate-parentheses/
 * Date: 11/26/2023
 * @author parth
 */
public class GenerateAllBalancedParentheses {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println(generateParentheses(10));
    }
    public static ArrayList<String> generateParentheses(int n){
        ArrayList<String> answer = new ArrayList<>();
        
        int open = n;
        int close = n;
        String processed = " ";
        helper(open,close,answer,processed);
        
        return answer;
    }
    public static void helper(int open, int close, ArrayList<String> answer, String processed){
        if(open == 0 && close == 0){
            answer.add(processed);
            return;
        }
        if(open!=0){
            String first = processed + '(';
            helper(open-1,close,answer,first);
        }
        if(close > open){
            String second = processed + ')';
            helper(open,close-1,answer,second);
        }
    }
}
