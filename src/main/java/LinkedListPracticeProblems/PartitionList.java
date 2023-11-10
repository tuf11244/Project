/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;

/**
 *Date: 11/09/2023
 * https://leetcode.com/problems/partition-list/
 * @author parth
 */
public class PartitionList {
    private Node head;
    private int size;
    public PartitionList(){
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
    public void PartitionList(int x){
         PartitionList(head,x);
    }
    private void PartitionList(Node node, int x){
        Node small = new Node(-1001);
        Node smallPointer = small;
        Node large = new Node(1001);
        Node largePointer = large;
        
        Node current = node;
        while(current!=null){
            if(current.value < x){
                smallPointer.next = current;
                smallPointer = smallPointer.next;
            }
            if(current.value >= x){
                largePointer.next = current;
                largePointer = largePointer.next;
            }
            current = current.next;
        }
        smallPointer.next = large.next;
        largePointer.next = null;
        
        //update the head;
        head = small.next;
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
        PartitionList LL = new PartitionList();
        LL.insertFirst(2);
        LL.insertFirst(5);
        LL.insertFirst(2);
        LL.insertFirst(3);
        LL.insertFirst(4);
        LL.insertFirst(1);
        
        
        LL.display();
        
        System.out.println("");
        
        LL.PartitionList(3);
        System.out.println("");
        LL.display();
        
    }
}
