/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;
//https://www.geeksforgeeks.org/sort-a-stack-using-recursion/
import java.util.Stack;
public class SortStackUsingRecursion {

    
    public static void main(String args[]) {
        System.out.println("Hello World");
	    Stack<Integer> stack = new Stack<>();
	    stack.push(30);
	    stack.push(-5);
	    stack.push(18);
	    stack.push(14);
	    stack.push(-3);
	    
	    System.out.println("Original Stack: " + stack);
        System.out.println("Sorted Stack: " + sortStack(stack));
        // TODO code application logic here
    }
    public static Stack<Integer> sortStack(Stack<Integer> stack){
	    if(stack.size() == 0  || stack.size() ==1){
	        return stack;
	    }
	    if(!stack.isEmpty()){
	        int temp = stack.pop();
	        sortStack(stack);
	        insert(stack,temp);
	    }
	    return stack;
	}
	public static void insert(Stack<Integer> stack, int temp){
	//Solves it in Ascending Order
	    if(stack.size() == 0 || stack.peek() <= temp){
	        stack.push(temp);
	        return;
	    }
	    int LastElement = stack.pop();
	    insert(stack,temp);
	    stack.push(LastElement);
	    return;
	}
	public static void insertdescending(Stack<Integer> stack, int temp){
	//Solves it in Descending Order
	    if(stack.size() == 0 || stack.peek() >= temp){
	        stack.push(temp);
	        return;
	    }
	    int LastElement = stack.pop();
	    insert(stack,temp);
	    stack.push(LastElement);
	    return;
	}
}
