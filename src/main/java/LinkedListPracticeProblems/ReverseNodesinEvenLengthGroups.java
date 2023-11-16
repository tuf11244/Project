/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;

/**
 *https://leetcode.com/problems/reverse-nodes-in-even-length-groups/
 * Date: 11/14/2023
 * @author parth
 */
public class ReverseNodesinEvenLengthGroups {
    private Node head;
    private int size;
    public ReverseNodesinEvenLengthGroups(){
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
    public void reverseNodes(){
        reverseNodes(head);
    }
    private void reverseNodes(Node node){
        //Intitialize Dummy Node
        Node dummy = new Node(0);
        dummy.next = head;
        
        //Pointer to the end of previous revered group
        Node previousGroupEnd = dummy;
        
        Node current = node;
        
        int groupLength = 1;
        
        while(current!=null){
             // Check if the current group has even length
            if (groupLength % 2 == 0) {
                // Reverse the current even-length group
                previousGroupEnd.next = reverse(previousGroupEnd.next, current.next);
                
                // Update the pointer to the end of the reversed group
                previousGroupEnd = current;
            }

            // Move to the next node
            current = current.next;
            
            // Increment the length of the current group
            groupLength++;
        }
        head = dummy.next;
        
    }
    private Node reverse(Node start, Node end){
        Node previous = null;
        Node current = start;
        Node next = current.next;
        
        while(current!=end){
            current.next = previous;
            previous = current;
            current = next;
            if(next!=null){
                next = next.next;
            }
        }
        return previous;
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
       ReverseNodesinEvenLengthGroups LL = new ReverseNodesinEvenLengthGroups();
       LL.insertFirst(4);
       LL.insertFirst(8);
       LL.insertFirst(3);
       LL.insertFirst(7);
       LL.insertFirst(1);
       LL.insertFirst(9);
       LL.insertFirst(3);
       LL.insertFirst(6);
       LL.insertFirst(2);
       LL.insertFirst(5);
       
       LL.display();
        System.out.println(" ");
        LL.reverseNodes();
        LL.display();
    }
}
