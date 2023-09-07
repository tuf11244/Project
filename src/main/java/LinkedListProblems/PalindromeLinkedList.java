/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListProblems;

/**
 *
 * @author parth
 */
public class PalindromeLinkedList {

    /**
     * Date: 09/06/2023
     * https://leetcode.com/problems/palindrome-linked-list/
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
}
class LinkedList2{
    private Node head;
    private Node tail;
    private int size;
    
    public LinkedList2(){
        this.size = 0;
    }
    public boolean  isPalindrome(Node head){
        Node middle = middleNode(head);
        Node secondhead = reversewithIteration(middle);
        Node rereversehead = secondhead;
        
        //compare both the halves 
        while(head!=null && secondhead!=null){
            if(head.value!=secondhead.value){
                break;
            }
            head = head.next;
            secondhead = secondhead.next;
        }
        reversewithIteration(rereversehead);
         return head == null || secondhead == null;    
    }
     public Node middleNode(Node head){
        Node fast = head;
        Node second = head;
        
        while(fast!= null && fast.next != null){
            fast = fast.next.next;
            second = second.next;
        }
        return second;
    }
    public Node reversewithIteration(Node head){
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
        return head;
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
