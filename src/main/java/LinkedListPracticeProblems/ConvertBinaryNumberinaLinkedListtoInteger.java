/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;

import java.util.ArrayList;
import java.util.List;

/**
 *https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer
 * Date: 10/31/2023
 * @author parth
 */
public class ConvertBinaryNumberinaLinkedListtoInteger {
    private Node head;
    
    public ConvertBinaryNumberinaLinkedListtoInteger(){
        this.head = null;
    }
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        if(head == null){
            head = node;
        }
    }
    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value + "-->");
            temp = temp.next;
        }
        System.out.print("END");
    }
    public void getDecimal(){
        getDecimal(head);
    }
    
    private void getDecimal(Node node){
        Node current = node;
        List<Integer> answer = new ArrayList<>();
        
        while(current!=null){
            answer.add(current.value);
            current = current.next;
        }
        System.out.println(answer);
        
        int sum = 0;
        for(int i = 0; i < answer.size();i++){
            sum = sum + answer.get(i)   * (int)Math.pow(2,answer.size()-i-1);
        }
        System.out.println(sum);
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
       ConvertBinaryNumberinaLinkedListtoInteger listNode = new ConvertBinaryNumberinaLinkedListtoInteger();
       listNode.insertFirst(1);
       listNode.insertFirst(0);
       listNode.insertFirst(1);
       listNode.insertFirst(1);
      // listNode.insertFirst(0);
       
       listNode.display();
        System.out.println();
       listNode.getDecimal();
    }
}
