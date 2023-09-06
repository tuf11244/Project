/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListProblems;

/**
 *
 * @author parth
 */
public class ReverseLinkedList {

    /**
     * Date: 09/05/2023
     * https://leetcode.com/problems/reverse-linked-list/
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        LinkedList1 list = new LinkedList1();
        list.insertFirst(0);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);
        
        list.display();
        list.reversewithIteration();
        System.out.println("");
        list.display();
        // TODO code application logic here
    }
}

class LinkedList1{
    private Node head;
    private Node tail;
    private int size;
    
    //Reverse a Linked List recursive way 
    private void reversewithRecursion(Node node){
        if(node == tail){
            head = tail;
            return;
        }
        reversewithRecursion(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }
    public void reversewithIteration(){
        if(size < 2){
            return;
        }
        Node previous = null;
        Node present = head;
        Node next = present.next;
        
        while(present!=null){
            present.next = previous;
            previous = present;
            present = next;
            if(next!=null){
                next = next.next;
            }
        }
        head = previous;
    }
    public Node reverseBetween(Node head, int left, int right){
        if(left == right){
            return head;
        }
        Node present = head;
        Node previous = null;
        
        //Skip the first left-1 nodes
        for(int i = 0; present!=null && i < left - 1;i++){
            previous = present;
            present = present.next;
        }
        
        Node last = previous;
        Node newEnd = present;
        //Reverse between left and right
        Node next = present.next;
        for(int i = 0; present!=null && i < right -left + 1;i++){
            present.next = previous;
            previous = present;
            present = next;
            if(next!=null){
                next = next.next;
            }
        }
        if(last!=null){
            last.next = previous;
        }else{
            head = previous;
        }
        newEnd.next = present;
        return head;
    }
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head; 
        head = node; 
        
        if(tail == null){
            tail = head;
        }
        size = size + 1;
    }
    public void display(){
        Node temp = head; 
        while(temp != null){
            System.out.print(temp.value + "-->");
            temp = temp.next;
        }
        System.out.print("END");
    }

    private class Node{
        private int value;
        private Node next;
        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }       
    }
}
