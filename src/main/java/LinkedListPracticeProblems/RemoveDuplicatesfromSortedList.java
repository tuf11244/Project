/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * Date: 11/02/2023
 * @author parth
 */
public class RemoveDuplicatesfromSortedList {
    private Node head;
    private int size;
    public RemoveDuplicatesfromSortedList(){
        this.head = null;
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
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }
    public void removeElement(){
         removeElement(head);
    }
    private void removeElement(Node node){
      Node dummy = new Node(101);
      dummy.next = head;
      Node previous = dummy;
      while(previous.next!=null && previous.next.next!=null){
          if(previous.next.value == previous.next.next.value){
              int duplicate = previous.next.value;
              while(previous.next != null && previous.next.value == duplicate){
                  previous.next = previous.next.next;
              }
          } else {
              previous = previous.next;
          }
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
        RemoveDuplicatesfromSortedList LL = new RemoveDuplicatesfromSortedList();
        LL.insertFirst(3);
        LL.insertFirst(3);
        LL.insertFirst(3);
        LL.insertFirst(3);
        LL.insertFirst(3);
        LL.insertFirst(2);
        LL.insertFirst(1);
        
        LL.display();
        
        LL.removeElement();
        System.out.println("");
        LL.display();
    }
}
