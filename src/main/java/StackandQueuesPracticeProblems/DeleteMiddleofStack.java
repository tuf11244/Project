/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;

import java.util.Stack;

/**
 *https://practice.geeksforgeeks.org/problems/delete-middle-element-of-a-stack/
 * Date: 10/19/2023
 * @author parth
 */
public class DeleteMiddleofStack {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        deleteMiddle();
        // TODO code application logic here
    }
    public static void deleteMiddle(){
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> helper = new Stack<>();
        for(int i = 1; i <= 11; i++){
            stack.push(i*10);
        }
        System.out.println(stack);
        int middle = stack.size()/2;
        while(middle >= 0){
            helper.push(stack.pop());
            middle--;
        }
        stack.pop();
        while(!helper.isEmpty()){
            stack.push(helper.pop());
        }
        System.out.println(stack);
    }
}
