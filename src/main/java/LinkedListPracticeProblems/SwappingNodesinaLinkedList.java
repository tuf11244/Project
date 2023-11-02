/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;

import java.util.Arrays;

/**
 *11/01/2023
 * https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 * @author parth
 */
public class SwappingNodesinaLinkedList {
    private Node head;
    private int size;
    public SwappingNodesinaLinkedList(){
        this.head = null;
        this.size = 0;
    }
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        size = size + 1;
    }
    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value + "-->");
            temp = temp.next;
        }
        System.out.print("END");
    }
    public void hello(int k){
         hello(head,k);
    }
    private void hello(Node node, int k){
      Node temp = node;
      int[] element = new int[size];
      while(temp!=null){
          for(int i = 0; i < element.length;i++){
              element[i] = temp.value;
              temp = temp.next;
          }         
      }
      System.out.println(Arrays.toString(element));
       int x = element[k];
       element[k] = element[element.length-k-1];
       element[element.length-k-1] = x;
       
        System.out.println(Arrays.toString(element));
       
        buildLinkedList(element);
    }
    private void buildLinkedList(int[] element){
    head = new Node(element[0]); // Create the head node separately
    Node temp = head;
    for(int i = 1; i < element.length; i++){
        Node newNode = new Node(element[i]);
        temp.next = newNode;
        temp = newNode; // Update temp to the new node
    }
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
        SwappingNodesinaLinkedList LL = new SwappingNodesinaLinkedList();
        LL.insertFirst(5);
        LL.insertFirst(9);
        LL.insertFirst(0);
        LL.insertFirst(3);
        LL.insertFirst(8);
        LL.insertFirst(7);
        LL.insertFirst(6);
        LL.insertFirst(6);
        LL.insertFirst(9);
        LL.insertFirst(7);
        
        LL.display();
        System.out.println("");
        LL.hello(7);
        
        LL.display();
    }
}
