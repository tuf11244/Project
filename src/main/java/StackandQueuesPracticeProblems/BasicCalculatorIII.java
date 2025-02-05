/*
 * This program implements a basic calculator that can evaluate arithmetic expressions 
 * with addition, subtraction, multiplication, division, and parentheses.
 * Date: 02/04/2025

 * It follows the standard order of operations (PEMDAS/BODMAS) using stacks.
 */

package StackandQueuesPracticeProblems;
import java.util.*;

public class BasicCalculatorIII {

    public static void main(String args[]) {
        // Test case to evaluate the expression "(2+6* 3+5- (3*14/7+2)*5)+3"
        System.out.println(calculate("(2+6* 3+5- (3*14/7+2)*5)+3")); // Expected output: -12
    }

    /**
     * Evaluates the given arithmetic expression as a string.
     * Supports '+', '-', '*', '/', and nested parentheses.
     * @param s The arithmetic expression to evaluate.
     * @return The evaluated integer result.
     */
    public static int calculate(String s) {
        Stack<Pair> brackets = new Stack<>(); // Stack to store previous states when encountering '('
        Stack<Integer> st = new Stack<>();    // Stack to store numbers and intermediate results
        char sign = '+'; // Tracks the current operation to be applied

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) { // If current character is a digit, form the full number
                int val = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + (s.charAt(i) - '0'); // Build the integer value
                    i++;
                }
                i--; // Adjust the index after exiting the loop
                
                helper(st, val, sign); // Process the number with the current sign
            } 
            else if (ch == '(') { 
                // Push the current state (stack and sign) onto the brackets stack
                brackets.push(new Pair(st, sign)); 
                
                // Reset stack and sign for the new sub-expression
                st = new Stack<>();
                sign = '+';
            } 
            else if (ch == ')') { 
                // Compute the value of the sub-expression within parentheses
                int val = 0;
                while (!st.isEmpty()) {
                    val += st.pop();
                }
                
                // Retrieve previous state
                Pair p = brackets.pop();
                st = p.st;
                sign = p.sign;
                
                // Process the computed value of the sub-expression with the previous sign
                helper(st, val, sign); 
            } 
            else if (ch != ' ') { // If it's an operator, update the sign
                sign = ch;
            }
        }

        // Sum up all values left in the stack to get the final result
        int sum = 0;
        while (!st.isEmpty()) {
            sum += st.pop();
        }
        return sum;
    }

    /**
     * Processes the current number based on the given operator and updates the stack.
     * @param st The stack storing intermediate results.
     * @param val The number to be processed.
     * @param sign The operator to apply.
     */
    public static void helper(Stack<Integer> st, int val, char sign) {
        if (sign == '+') {
            st.push(val);
        } else if (sign == '-') {
            st.push(-val);
        } else if (sign == '*') {
            int a = st.pop();
            st.push(a * val);
        } else if (sign == '/') {
            int a = st.pop();
            st.push(a / val);
        }
    }
}

/**
 * Helper class to store the state of computation when encountering parentheses.
 */
class Pair {
    Stack<Integer> st; // Stack storing intermediate results before encountering '('
    char sign; // Operator before '('

    public Pair(Stack<Integer> st, char sign) {
        this.st = st;
        this.sign = sign;
    }
}
