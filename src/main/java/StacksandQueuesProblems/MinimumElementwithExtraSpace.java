/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StacksandQueuesProblems;
import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author parth
 */
public class MinimumElementwithExtraSpace {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        MinStack object = new MinStack();
        object.push(5);
        object.push(11);
        object.push(2);
        object.push(10);
        object.display(); 
        object.pop();
        object.display();
        System.out.println(object.getMin());
        // TODO code application logic here
    }
}
class MinStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int pointer = -1;
    private Stack<Integer> minStack; // Separate stack to track minimum elements

    public MinStack() {
        data = new int[DEFAULT_SIZE];
        minStack = new Stack<>();
    }

    public boolean isEmpty() {
        return pointer == -1;
    }

    public boolean isFull() {
        return pointer == data.length - 1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("The stack is Full...try again");
            return;
        }
        pointer = pointer + 1;
        data[pointer] = value;

        // Update the minStack with the minimum value
        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        }
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("The stack is empty ---nothing to pop");
            return;
        }
        int poppedValue = data[pointer];
        pointer = pointer - 1;

        // Update the minStack if the popped element was the minimum
        if (poppedValue == minStack.peek()) {
            minStack.pop();
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("The stack is empty");
            return -1; // You can return a default value or throw an exception here.
        }
        return data[pointer];
    }

    public void display() {
        System.out.println(Arrays.toString(data));
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            System.out.println("The stack is empty");
            return -1; // You can return a default value or throw an exception here.
        }
        return minStack.peek();
    }
}





