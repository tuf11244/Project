/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StacksandQueuesProblems;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.*;
/**
 * Date: 09/11/2023
 *https://www.geeksforgeeks.org/the-stock-span-problem/
 * @author parth
 */
public class StockSpan {

    
    public static void main(String args[]) {
        System.out.println("Hello World");
        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        stockSpan(arr);
        // TODO code application logic here
    }
    public static void stockSpan(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] >= stack.peek()) {
                stack.pop();
                indexStack.pop();
            }

            if (stack.isEmpty()) {
                queue.add(-1);
            } else {
                queue.add(indexStack.peek());
            }

            stack.push(arr[i]);
            indexStack.push(i);
        }
        

        // Calculate the span by subtracting indices
        for (int i = 0; i < queue.size(); i++) {
            queue.set(i, i - queue.get(i));
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(queue);
    }
    
    
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // write code here
        
        ArrayList<Integer> answer = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        
        answer.add(1);
        st.push(0); //we are storing indexes
        
        for(int i = 1; i < arr.length;i++){
            
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                answer.add(i + 1); // If stack is empty, entire range contributes to span
            } else {
                answer.add(i - st.peek()); // Span is current index - last higher index
            }

            st.push(i); // Push current index
        }
        
        return answer;
    }
    
}
