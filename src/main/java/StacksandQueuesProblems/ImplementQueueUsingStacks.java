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
        queue.add(3);
        queue.add(2);
        queue.add(1);
        
        System.out.println("Peek " + queue.peek());
        System.out.println("Remove " + queue.remove());
        System.out.println("Peek " + queue.peek());
        
      
   
}
}
class QueueUsingStacks{
    private Stack<Integer> first;
    private Stack<Integer> second;
    
    QueueUsingStacks(){
        first = new Stack<>();
        second = new Stack<>();
    }
    public void add(int item){
        first.push(item);
    }
    public int remove(){
        while(!first.empty()){
            second.push(first.pop());
        }
        int removed = second.pop();
        while(!second.empty()){
          first.push(second.pop());
    }
        return removed;
    }
    public int peek(){
        while(!first.empty()){
            second.push(first.pop());
        }
        return second.peek();
    }
    
}

