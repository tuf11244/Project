/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;

/**
 * Date: 11/10/2023
 *https://leetcode.com/problems/insertion-sort-list/
 * @author parth
 */
public class InsertionSortList {
    private Node head;
    private int size;
    public InsertionSortList(){
        this.head = null;
        size = 0;
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
   public void insertionSort(){
       insertionSort(head);
   }
   public void insertionSort(Node node){
      if(node == null || node.next == null){
          return;    
      }
      Node temp = node;
      while(temp!=null){
          Node next = temp.next;
          Node start = node;
          Node previous = node;
          
          while(start!=next){
              if(start.value > temp.value){
                  temp.next = start;
                 if(start == head){
                     head = temp;
                 } else{
                     previous.next = temp;
                 }
                 
                 while(start.next!=temp){
                     start = start.next;
                 }
                 start.next = next;
          }
              previous = start;
              start = start.next;
      }
          temp = next;
   }
   }
   private Node getNode(int index){
       Node temp = head;
       for(int i = 0; i < index;i++){
           temp = temp.next;
       }
       return temp;
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
        InsertionSortList LL = new InsertionSortList();
        LL.insertFirst(0);
        LL.insertFirst(4);
        LL.insertFirst(3);
        LL.insertFirst(5);
        LL.insertFirst(-1);
        
        LL.display();
        
        System.out.println("");
        LL.insertionSort();
        LL.display();
    }
}
