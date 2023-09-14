/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StacksandQueuesProblems;
import java.util.Stack;

/**
 *
 * @author parth
 */
public class Gameof2Stacks {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Stack<Integer> andy = new Stack<>();
        Stack<Integer> nick = new Stack<>();
        andy.push(1);
        andy.push(6);
        andy.push(4);
        andy.push(2);
        andy.push(4);
        
        nick.push(5);
        nick.push(8);
        nick.push(1);
        nick.push(2);
        
        System.out.println(andy);
        System.out.println(nick);
        
        int maxSum = 10;
        int sum = 0;
        int count = 0;
        System.out.println(gameOfTwoStack(maxSum,andy,nick,sum,count));
                
        // TODO code application logic here
    }
    public static int gameOfTwoStack(int maxSum, Stack<Integer> andy, Stack<Integer> nick, int sum, int count){
        if(sum > maxSum){
            return count;
        }
        if(andy.empty() || nick.empty()){
            return count;
        }
        int a = andy.pop();
        int b = nick.pop();
        return Math.max(gameOfTwoStack(maxSum,andy,nick,sum+a,count+1),gameOfTwoStack(maxSum,andy,nick,sum+b,count+1));
    }
}

