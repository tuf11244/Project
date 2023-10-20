/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *https://practice.geeksforgeeks.org/problems/reverse-first-k-elements-of-queue/
 * @author parth
 */
public class ReverseFirstKElementsofQueue {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       reverse(2);
    }
    public static void reverse(int k){
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        
        for(int i = 1; i <= 4; i++){
            queue.add(i);
        }
        while(!queue.isEmpty()){
            stack1.push(queue.poll());
        }
        while(stack1.size()-k > 0){
            stack2.push(stack1.pop());
        }
        while(!stack1.isEmpty()){
            queue.offer(stack1.pop());
        }
        while(!stack2.isEmpty()){
            queue.offer(stack2.pop());
        }
        System.out.println(queue);
    }
}
