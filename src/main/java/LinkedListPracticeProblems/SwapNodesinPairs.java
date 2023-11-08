/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;

/**
 *https://leetcode.com/problems/swap-nodes-in-pairs/
 * Date: 11/03/2024
 * @author parth
 */
public class SwapNodesinPairs {
    
    private Node head;
    private int size = 0;
    public SwapNodesinPairs(){
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
    public void reverse(){
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
    public void swapinPairs() {
    head = swapinPairs(head);
    }

    private Node swapinPairs(Node node) {
    if (node == null || node.next == null) {
        return node;
    }

    Node newHead = node.next;
    Node prev = null;

    while (node != null && node.next != null) {
        Node nextPair = node.next.next;
        if (prev != null) {
            prev.next = node.next;
        }
        node.next.next = node;
        node.next = nextPair;
        prev = node;
        node = nextPair;
    }
    return newHead;
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
        SwapNodesinPairs LL = new SwapNodesinPairs();
        LL.insertFirst(1);
        LL.insertFirst(2);
        LL.insertFirst(3);
        LL.insertFirst(4);
        
        LL.display();
        
        LL.swapinPairs();
        
        System.out.println("");
        
        LL.display();
    }
}
