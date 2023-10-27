/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StacksandQueuesProblems;
import java.util.Stack;

/**
 *Date: 09/13/2023
 * https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
 * https://leetcode.com/problems/min-stack/
 * @author parth
 */
public class MinimumElementwithConstantSpace {

    public static void main(String args[]) {
        MinStack object = new MinStack();
        object.push(5);
        object.push(7);
        object.push(0);
        object.push(1);
        object.display();
        System.out.println(object.getMin());
        //object.pop();
        object.display();
        System.out.println(object.peek());
        
        // TODO code application logic here
    }
}
class MinStack{
    Stack<Integer> stack;
    int minimumElement; 
    
    public MinStack(){
        stack = new Stack<>();
    }
    public int getMin(){
        if(stack.empty()){
            return -1;
        }
        return minimumElement;
    }
    public void push(int value){
        if(stack.empty()){
            stack.push(value);
            minimumElement = value;
        }
        else{
            if(value >= minimumElement){
                stack.push(value);
            }
            else if(value < minimumElement){
                    stack.push(2*value - minimumElement);  //Acts as flag 
                    minimumElement = value;
            }
            }
        }
    public void pop(){
        if(stack.empty()){
            System.out.println("The Stack is empty");
        }
        else{
            if(stack.peek() >= minimumElement){
                stack.pop();
            }
            else if(stack.peek() < minimumElement){
                minimumElement = 2 * minimumElement - stack.peek();
                stack.pop();
            }
        }
    }
    public int peek(){
        if(stack.empty()){
            return -1;
        }
        else{
            if(stack.peek() >= minimumElement){
                return stack.peek();
            }
            if(stack.peek() < minimumElement){
                return minimumElement;
            }
        }
        return -1;
    }
    public void display(){
        System.out.println(stack);
    }
    }

