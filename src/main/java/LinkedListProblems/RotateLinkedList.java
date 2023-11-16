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
        LinkedList4 LL = new LinkedList4();
        for(int i = 1; i <=5;i++){
            LL.insertFirst(i);
        }
        LL.display();
        System.out.println("After rotating :");
        LL.rotateRight(2);
        LL.display();
        
    }
}
class LinkedList4{
    private Node head;
    private Node tail;
    private int size;
    
    public LinkedList4(){
        this.size = 0;
        this.head = null;
    }
    public void rotateRight(int k){
        head = rotateRight(head,k);
    }
    private Node rotateRight(Node head, int k){
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
