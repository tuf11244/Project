/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;

import java.util.PriorityQueue;

/**
 *
 * @author parth
 */
//https://leetcode.com/problems/merge-k-sorted-lists/
//Date: 11/13/2023
public class MergeKSortedList{   
    private Node head;
    private int size;
    
    public MergeKSortedList(){
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
    public void mergeKSortedList(){
        Node[] result = new Node[4];
        //Fill the Array with the Nodes 
        result[0] = new Node(1, new Node(21, new Node(5)));
        result[1] = new Node(1, new Node(29, new Node(4)));
        result[2] = new Node(2, new Node(6));
        result[3] = new Node(-23, new Node(86));
        mergeKSortedList(result);
    }
    private void mergeKSortedList(Node[] result){
        Node dummy = new Node(10001);
        Node temp = dummy;
        //Based on the Array given make it into 1 single LinkedList
        for(int i = 0; i < result.length;i++){
            Node current = result[i];
            while(current.next!=null){
                temp.next = current;
                temp = temp.next;
                current = current.next;
            }
            if(current.next==null){
                temp = current;
            }
        }
        //Assign the head to dummy.next 
        head = dummy.next;
        //Pass the head in function and sort it however you like insertionSort, MergeSort, BubbleSort 
        mergeKSortedList(head);
    }
     private void mergeKSortedList(Node node){
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
	public static void main(String[] args) {
		System.out.println("Hello World");
		MergeKSortedList LL = new MergeKSortedList();
		LL.mergeKSortedList();
		
		System.out.println();
		
		LL.display();
		
	}
}


//Solution Based on PriorityQueue 
class Solution {
    private class ListNode{
        int value; 
        ListNode next;
        public ListNode(int value){
            this.value = value;
        }
        public ListNode(int value, ListNode next){
            this.value = value;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // Create a priority queue with a custom comparator to compare ListNode objects
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.value - b.value);

        // Add the heads of all lists to the priority queue
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Process the nodes from the priority queue
        while (!pq.isEmpty()) {
            // Pop the smallest node from the priority queue
            ListNode smallest = pq.poll();
            // Append the smallest node to the result list
            tail.next = smallest;
            tail = tail.next;
            // Move to the next node of the popped node in its list
            if (smallest.next != null) {
                pq.add(smallest.next);
            }
        }

        return dummy.next;
}
}