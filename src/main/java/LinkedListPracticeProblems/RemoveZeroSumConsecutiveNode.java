/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;

/**
 *
 * @author parth
 */
//https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
public class RemoveZeroSumConsecutiveNode{
    private Node head;
    private int size;
    public RemoveZeroSumConsecutiveNode(){
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
    public void removeZeroSumSublists(){
        removeZeroSumSublists(head);
    }
    private void removeZeroSumSublists(Node node){
    Node dummy = new Node(1001);
    dummy.next = node;
    Node current = dummy;

    while(current != null){
        int sum = 0;
        Node temp = current.next;
        while(temp != null){
            sum += temp.value;
            if(sum == 0){
                current.next = temp.next;
                break;
            }
            temp = temp.next;
        }
        current = current.next;
    }

    head = dummy.next;
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
	public static void main(String[] args) {
		System.out.println("Hello World");
		RemoveZeroSumConsecutiveNode LL = new RemoveZeroSumConsecutiveNode();
		LL.insertFirst(1);
		LL.insertFirst(3);
		LL.insertFirst(-3);
		LL.insertFirst(2);
		LL.insertFirst(1);
		
		
		LL.display();
		
		System.out.println();
		
		LL.removeZeroSumSublists();
		
		LL.display();
	}
}
