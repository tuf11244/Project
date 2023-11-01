/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;

/**
 *Date: 10/31/2023
 * https://leetcode.com/problems/remove-linked-list-elements/
 * @author parth
 */
public class RemoveLinkedListElements {
    private Node head;
    private int size;
    public RemoveLinkedListElements(){
        this.head = null;
        this.size= 0;
    }
    
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        if(head == null){
            head = node;
        }
        size = size + 1;
    }
    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value + "--->");
            temp = temp.next;
        }
        System.out.print("END");
    }
   public Node removeElements(int val) {
    Node dummy = new Node(0);
    dummy.next = head;
    Node current = dummy;

    while (current.next != null) {
        if (current.next.value == val) {
            current.next = current.next.next;
        } else {
            current = current.next;
        }
    }
    head = dummy.next;
    return head;
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
        RemoveLinkedListElements listNode = new RemoveLinkedListElements();
        listNode.insertFirst(6);
        listNode.insertFirst(6);
        listNode.insertFirst(6);
        listNode.insertFirst(6);
        listNode.insertFirst(6);
        listNode.insertFirst(6);
        listNode.insertFirst(6);
        
        listNode.display();
        
        int valueToRemove = 6;
        listNode.removeElements(valueToRemove);
        System.out.println("");
        System.out.println("LinkedList after removal");
        listNode.display();
        
    }
}
