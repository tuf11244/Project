/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;
import java.util.*;
/**
 *Date: 09/18/2024
 *https://leetcode.com/problems/different-ways-to-add-parentheses/
 * @author parth
 */
public class DifferentWaystoAddParentheses {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
     // Memoization map to store previously computed results for expressions
    private Map<String, List<Integer>> memo = new HashMap<>();
    
    public List<Integer> diffWaysToCompute(String expression) {
      // If we already computed the result for this expression, return it from memo
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }
        
        List<Integer> result = new ArrayList<>();
        
        // Traverse through each character in the expression
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            
            // If the character is an operator, split the expression into two parts
            if (ch == '+' || ch == '-' || ch == '*') {
                // Recursively solve for the left and right parts of the expression
                List<Integer> leftResults = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightResults = diffWaysToCompute(expression.substring(i + 1));

                // Combine the results of the left and right subproblems based on the current operator
                for (int left : leftResults) {
                    for (int right : rightResults) {
                        if (ch == '+') {
                            result.add(left + right);
                        } else if (ch == '-') {
                            result.add(left - right);
                        } else if (ch == '*') {
                            result.add(left * right);
                        }
                    }
                }
            }
        }
        
        // If the expression contains no operators, it's a single number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }
        
        // Store the computed result in the memo map for future use
        memo.put(expression, result);
        return result;
    }
}
