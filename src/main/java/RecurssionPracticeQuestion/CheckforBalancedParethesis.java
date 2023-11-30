/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

/**
 * https://www.geeksforgeeks.org/check-for-balanced-parenthesis-without-using-stack/
 *Date: 11/20/2023
 * @author parth
 */
public class CheckforBalancedParethesis {

    public static boolean areBracketsBalanced(String exp) {
        return areBracketsBalancedRecursive(exp, 0, 0);
    }

    private static boolean areBracketsBalancedRecursive(String exp, int index, int balance) {
        // Base case: reach the end of the expression
        if (index == exp.length()) {
            return balance == 0; // Check if all brackets are closed
        }

        char currentChar = exp.charAt(index);

        // Update balance based on the current character
        if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
            balance++;
        } else if (currentChar == ')' || currentChar == '}' || currentChar == ']') {
            balance--;
        }

        // If balance goes negative at any point, brackets are not balanced
        if (balance < 0) {
            return false;
        }

        // Recursive call to process the next character
        return areBracketsBalancedRecursive(exp, index + 1, balance);
    }

    public static void main(String[] args) {
        String expression = "{[()]}";

        if (areBracketsBalanced(expression)) {
            System.out.println("Brackets are balanced.");
        } else {
            System.out.println("Brackets are not balanced.");
        }
    }
}

