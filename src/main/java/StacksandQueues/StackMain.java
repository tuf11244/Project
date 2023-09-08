/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StacksandQueues;

/**
 *Date: 09/07/2023
 * @author parth
 */
public class StackMain {

   
    public static void main(String args[]) throws StackException {
        DynamicCustomStack<Integer> stack  = new DynamicCustomStack<>();
        for(int i = 1; i <= 20; i++){
            stack.push(5*i);
        }
//        stack.push(5);
//        stack.push(10);
//        stack.push(15);
//        stack.push(20);
//        stack.push(25);
//        stack.push(30);
//        stack.push(35);
//        stack.push(40);
//        stack.push(45);
//        stack.push(50);

        for(int i = 1 ; i <= 20;i++){
            System.out.print(stack.pop()+ " ");
        }
        System.out.println(stack.peek());
       
        
        // TODO code application logic here
    }
}
