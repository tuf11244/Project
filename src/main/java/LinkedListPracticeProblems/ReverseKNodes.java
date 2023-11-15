/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;

import java.util.Arrays;


/**
 * Date: 11/14/2023
 *https://leetcode.com/problems/reverse-nodes-in-k-group/
 * https://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/
 * @author parth
 */
public class ReverseKNodes {
    private Node head;
    private int size;
    public ReverseKNodes(){
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
    private Node temporaryHead = null;
    private Node temporaryTail = null;
    public void addFirstNode(Node node){
        if(temporaryHead == null){
            temporaryHead = node;
            temporaryTail = node;
        }
        node.next = temporaryHead;
        temporaryHead = node;
    }
    
    public void reverseKNodes(int k){
        reverseKNodes(head,k);
    }
    private void reverseKNodes(Node node, int k){
        if(node == null || node.next == null || k <= 1){
            return;
        }
        Node current = node;
        
        Node originalHead = null;
        Node originalTail = null;
        
        while(size >= k){
            int tempk = k;
            while(tempk > 0){
                Node forward = current.next;
                current.next = null;
                addFirstNode(current);
                current = forward;
                tempk = tempk -1;
            }
            if(originalHead == null){
                originalHead = temporaryHead;
                originalTail = temporaryTail;
            }
            originalTail.next = temporaryHead;
            originalTail = temporaryTail;
            
            //Assign temporaryHead and temporaryTail to null 
            //Substract k from the size
            temporaryHead = null;
            temporaryTail = null;
            size = size - k;
        }
        //if there are remaining elements, attach it to the originalTail 
        //For example 1 -> 2 -> 3 -> 4 -> 5 
        // After the program the runs LinkedList will looksomething like below 
        // 2->1->4->3   and 5 is current because while loop condition is violating 
        //3 is originalTail and 5 is current 
        //so we are attaching originalTail.next = current
        originalTail.next = current;
        head = originalHead;
    }
    
    //Alternate K Nodes
    public void reverseAlternateKNodes(int k) {
    reverseAlternateKNodes(head, k, true);
}

    private void reverseAlternateKNodes(Node node, int k, boolean reverse) {
    if (node == null || node.next == null || k <= 1) {
        return;
    }

    Node current = node;
    Node originalHead = null;
    Node originalTail = null;

    while (size >= k) {
        int tempk = k;
        while (tempk > 0) {
            Node forward = current.next;
            current.next = null;

            if (reverse) {
                addFirstNode(current);
            } else {
                if (originalTail == null) {
                    originalHead = current;
                    originalTail = current;
                } else {
                    originalTail.next = current;
                    originalTail = originalTail.next;
                }
            }

            current = forward;
            tempk = tempk -1;
        }

        if (reverse) {
            if (originalHead == null) {
                originalHead = temporaryHead;
                originalTail = temporaryTail;
            }
            originalTail.next = temporaryHead;
            originalTail = temporaryTail;

            temporaryHead = null;
            temporaryTail = null;
        }

        size = size - k;
        reverse = !reverse;
    }

    originalTail.next = current;
    head = originalHead;
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
        ReverseKNodes LL = new ReverseKNodes();
        LL.insertFirst(6);
        LL.insertFirst(5);
        LL.insertFirst(4);
        LL.insertFirst(3);
        LL.insertFirst(2);
        LL.insertFirst(1);
        
        System.out.println("Original List");
        LL.display();
        System.out.println("");
        LL.reverseAlternateKNodes(2);
        System.out.println("List after reversing in K groups " );
        LL.display();
    }
}
