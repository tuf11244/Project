/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListProblems;

/**
 *
 * @author parth
 */
public class RotateLinkedList {

    /**
     * Date: 09/06/2023
     * https://leetcode.com/problems/rotate-list/
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
}
class LinkedList4{
    private Node head;
    private Node tail;
    private int size;
    
    public LinkedList4(){
        this.size = 0;
    }
    
    public Node rotateRight(Node head, int k){
        if(k <= 0 || head == null || head.next == null){
            return head;
        }
        Node temp = head;
        int length = 1;
        
        //Finding the tail
        while(temp.next!=null){
            temp = temp.next;
            length = length + 1;
        }
        
        temp.next = head;
        int rotations = k % length;
        int skip = length - rotations;
        Node newTemp = head;
        for(int i = 0; i < skip-1;i++){
            newTemp = newTemp.next;
        }
        head = newTemp.next;
        newTemp.next = null;
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
