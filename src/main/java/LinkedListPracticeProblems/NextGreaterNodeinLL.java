/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 *Date: 11/09/2023
 * https://leetcode.com/problems/next-greater-node-in-linked-list/
 * @author parth
 */
public class NextGreaterNodeinLL {
    private Node head;
    private int size;
    
    public NextGreaterNodeinLL(){
        this.head = null;
        size = 0;
    }
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        
        size = size+1;
    }
    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }
    public void nextGreaterElement(){
            nextGreaterElement(head);
    }
    private void nextGreaterElement(Node node){
        ArrayList<Integer> nodeValues = new ArrayList<>();
        
        Stack<Integer> stack = new Stack<>();
        Node current = node;
        
        while(current!=null){
        nodeValues.add(current.value);
        current = current.next;
        }
        
        int[] outputArray = new int[nodeValues.size()];
        
        for(int i = 0; i < nodeValues.size();i++){
            while(!stack.isEmpty() && nodeValues.get(stack.peek()) < nodeValues.get(i)){
                outputArray[stack.pop()] = nodeValues.get(i);
            }
            stack.push(i);
        }
        
        System.out.println(Arrays.toString(outputArray));
             
    }
    
    private class Node{
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String args[]) {
        NextGreaterNodeinLL LL = new NextGreaterNodeinLL();
        LL.insertFirst(5);
        LL.insertFirst(1);
        LL.insertFirst(2);
        
        LL.display();
        
        System.out.println("");
        
        LL.nextGreaterElement();
    }
}
