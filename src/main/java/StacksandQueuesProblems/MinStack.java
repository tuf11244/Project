/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StacksandQueuesProblems;
import java.util.*;
/**
 *Date: 02/28/2025
 * https://leetcode.com/problems/min-stack/
 * @author parth
 */
public class MinStack {
    
}


class MinStackwithExtraSpace {
    Stack<Integer> stack;
    Stack<Integer> minStack; // Stores the min at each state
    
    public MinStackwithExtraSpace() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        
        // Update minStack with the new minimum
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) return;
        
        // If we are popping the current min, pop from minStack as well
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}


class MinStackConstantSpace {
    Stack<Long> st;
    long minimum; // Use long to prevent integer overflow issues

    public MinStackConstantSpace() {
        st = new Stack<>();
        minimum = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (st.isEmpty()) {
            st.push((long) val);
            minimum = val;
        } else {
            if (val < minimum) {
                st.push(2L * val - minimum); // Store modified value
                minimum = val;
            } else {
                st.push((long) val);
            }
        }
    }

    public void pop() {
        if (st.isEmpty()) return;

        long top = st.pop();
        if (top < minimum) {  // If it's a special value, update minimum
            minimum = 2 * minimum - top;
        }
    }

    public int top() {
        if (st.isEmpty()) return -1;

        long top = st.peek();
        return (top < minimum) ? (int) minimum : (int) top;
    }

    public int getMin() {
        return st.isEmpty() ? -1 : (int) minimum;
    }
}


