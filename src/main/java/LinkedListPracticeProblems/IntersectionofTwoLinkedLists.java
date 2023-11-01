/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;

/**
 *10/31/2023
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * @author parth
 */
public class IntersectionofTwoLinkedLists {
    private Node head;
    public IntersectionofTwoLinkedLists(){
        this.head = null;
    }
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
    }
    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value + "-->");
            temp = temp.next;
        }
        System.out.print("END");
    }
    public Node getIntersectionNode(Node node1, Node node2){
        int node1Length = findLength(node1);
        int node2Length = findLength(node2);
        
        while(node1Length > node2Length){
            node1 = node1.next;
            node1Length = node1Length - 1;
        }
        while(node2Length > node1Length){
            node2 = node2.next;
            node2Length = node2Length - 1;
        }
        while(node1 != node2){
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }
    private int findLength(Node node){
        Node temp = node;
        int length = 0;
        while(temp!=null){
            length = length + 1;
             temp = temp.next;
        }
        return length;
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
        // TODO code application logic here
    }
}
