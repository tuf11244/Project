/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;

//https://leetcode.com/problems/design-a-stack-with-increment-operation/
public class DesignStackWithIncrementOperation{
	public static void main(String[] args) {
		System.out.println("Hello World");
		CustomStack stack = new CustomStack(10);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		stack.push(70);
		stack.push(80);
		stack.push(90);
		stack.display();
		System.out.println(stack.pop());
		stack.increment(10,100);
		System.out.println();
		stack.display();
		
	}
}

class CustomStack{
    private int[] data;
    private int maxSize;
    private int pointer;
    
    public CustomStack(int maxSize){
        this.maxSize = maxSize;
        data = new int[maxSize];
        pointer = 0;
    }
    private boolean isFull(){
        return pointer == data.length;
    }
    private boolean isEmpty(){
        return pointer == -1;
    }
    public void push(int x){
       if(isFull()){
           System.out.println("The Stack is Full");
       }
       pointer = pointer + 1;
       data[pointer] = x;
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("The stack is Empty");
            return -1;
        }
        int removed = data[pointer];
        pointer--;
        return removed;
    }
     public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, pointer + 1); i++) {
            data[i] += val;
        }
    }
    public void display(){
         if(isEmpty()){
            System.out.println("The stack is Empty");
            return;
        }
        for(int i = 0; i < data.length;i++){
            System.out.print(data[i] + " ");
        }
    }
}
