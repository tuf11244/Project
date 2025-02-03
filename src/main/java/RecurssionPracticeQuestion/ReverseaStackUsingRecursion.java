 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;
import java.util.Stack;
/**
 *https://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
 * Date: 11/19/2023
 * @author parth
 */
public class ReverseaStackUsingRecursion {

    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 1; i<=4;i++){
            stack.push(i);
        }
        System.out.println(stack);
        System.out.println(reverse(stack));
    }
    public static Stack<Integer> reverse(Stack<Integer> stack){
        if(stack.isEmpty() || stack.size() == 1){
            return stack;
        }
            int temp = stack.pop(); //Statement 1
             reverse(stack); //statement 2 
            insertBottom(stack,temp); //statement 3
        
        return stack;
        }
    public static void insertBottom(Stack<Integer> stack, int temp){
        if(stack.isEmpty()){
            stack.push(temp);
        }else{
        int top = stack.pop();
        insertBottom(stack,temp);
        stack.push(top);       
    }
    }
    
}
