/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StacksandQueuesProblems;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
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
}
