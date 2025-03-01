/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StacksandQueuesProblems;
import java.util.Stack;


/**
 * Date: 09/08/2023
 *https://leetcode.com/problems/implement-queue-using-stacks/
 * @author parth
 */
public class ImplementQueueUsingStacks {

    public static void main(String args[]) {
        QueueUsingStacks queue = new QueueUsingStacks();
        
        
        
        
      
   
}
}
class QueueUsingStacks{
    
     Stack<Integer> st1; // Main stack for push
    Stack<Integer> st2; // Stack for pop and peek

    public QueueUsingStacks(){
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    public void push(int x) {
        st1.push(x); // Simply push to st1
    }
    
    public int pop() {
        if (st2.isEmpty()){
            while (!st1.isEmpty()) {
                st2.push(st1.pop()); // Transfer elements only when needed
            }
        }
        return st2.pop();
    }
    
    public int peek() {
        if (st2.isEmpty()) {
            while (!st1.isEmpty()) {
                st2.push(st1.pop()); // Transfer elements only when needed
            }
        }
        return st2.peek();
    }
    
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }
    
}

