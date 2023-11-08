/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;

/**
 *
 * @author parth
 */
//https://leetcode.com/problems/odd-even-linked-list/
public class OddEvenLinkedList
{   
    private Node head;
    private int size = 0;
    
    public OddEvenLinkedList(){
        this.head = null;
    }
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        
        size = size+1;
    }
    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }
    public void oddEven(){
        oddEven(head);
    }
    public void oddEven(Node node){
       Node odd = node;
       Node even = node.next;
       Node evenHead = node.next;
       
       while(even!=null && even.next!=null){
           //Move the odd pointers
           odd.next = odd.next.next;
           odd = odd.next;
           
           //Move the even pointers
           even.next = even.next.next;
           even = even.next;
       }
       odd.next = evenHead;
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
		OddEvenLinkedList LL = new OddEvenLinkedList();
		LL.insertFirst(5);
		LL.insertFirst(4);
		LL.insertFirst(3);
		LL.insertFirst(2);
		LL.insertFirst(1);
		
		LL.display();
		
		LL.oddEven();
		
		System.out.println();
		
		LL.display();
	}
}
