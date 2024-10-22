package StackandQueuesPracticeProblems;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
import java.util.*;

/**
 * Date: 10/19/2024
 * https://leetcode.com/problems/parsing-a-boolean-expression/
 * @author parth
 */
public class ParsingaBooleanExpression {

    public static void main(String[] args) {
        System.out.println(parseBoolExpr("|(&(t,f,t),!(t))"));  // Example test case
    }

    public static boolean parseBoolExpr(String expression) {
        Stack<Character> st = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '(') {
                st.add('(');
            } else if (ch == '!' || ch == '|' || ch == '&') {
                operator.add(ch);
            } else if (ch == 't' || ch == 'f') {
                st.add(ch);
            } else if (ch == ')') {
                // Closing bracket: perform the corresponding operation
                char operation = operator.pop();
                
                if (operation == '|') {
                    parseOr(st);
                } else if (operation == '&') {
                    parseAnd(st);
                } else if (operation == '!') {
                    parseNot(st);
                }
            }
        }

        return st.pop() == 't';
    }

    public static void parseAnd(Stack<Character> st) {
        boolean result = true; // Assume true for AND operation
        while (!st.isEmpty() && st.peek() != '(') {
            result &= (st.pop() == 't');
        }
        st.pop(); // Remove '('
        st.push(result ? 't' : 'f');
    }

    public static void parseOr(Stack<Character> st) {
        boolean result = false; // Assume false for OR operation
        while (!st.isEmpty() && st.peek() != '(') {
            result |= (st.pop() == 't');
        }
        st.pop(); // Remove '('
        st.push(result ? 't' : 'f');
    }

    public static void parseNot(Stack<Character> st) {
        char top = st.pop();
        st.pop(); // Remove '('
        st.push(top == 't' ? 'f' : 't');
    }
}
