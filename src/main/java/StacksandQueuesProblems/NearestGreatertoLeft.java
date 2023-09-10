/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StacksandQueuesProblems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author parth
 */
public class NearestGreatertoLeft {

    /**
     * Date: 09/09/2023
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println("Hello World");
        int[] arr = {1, 8,0,0,1, 2, 4};
        NearestLargestElementToLeft(arr);
        // TODO code application logic here
    }
    public static void NearestLargestElementToLeft(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
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
        System.out.println(Arrays.toString(arr));
        System.out.println(queue);
    }
}
