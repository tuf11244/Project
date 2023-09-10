/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StacksandQueuesProblems;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Arrays;
/**
 *Date: 09/10/2023
 * @author parth
 * https://leetcode.com/problems/next-greater-element-ii/
 */
public class NearestGreatertoRight {

    
    public static void main(String args[]) {
       System.out.println("Hello World");
        int[] arr = {1, 8,0,0,1, 2, 4};
        NearestLargestElementToRight(arr);
    }
    public static void NearestLargestElementToRight(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                queue.add(-1);
            } else if (!stack.isEmpty() && stack.peek() > arr[i]) {
                queue.add(stack.peek());
            } else if (!stack.isEmpty() && stack.peek() <= arr[i]) {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    queue.add(-1);
                } else {
                    queue.add(stack.peek());
                }
            }
            stack.push(arr[i]);
        }
        
        // Reverse the queue to get the correct order
        LinkedList<Integer> reversedQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            reversedQueue.add(queue.removeLast());
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(reversedQueue);
    }
}
