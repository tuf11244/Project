/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;

/**
 *
 * @author parth
 */
//https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
public class DeleteMiddleofaLinkedList
{
    private Node head;
    private int size;
    
    public DeleteMiddleofaLinkedList(){
        this.head = null;
        this.size = 0;
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
    
    public void middle(){
        middle(head);
    }
    private void middle(Node node){
        Node fast = node;
        Node slow = node;
        
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
    //    System.out.println(slow.value);
        int index = getIndex(slow);
    //    System.out.println(index);
        
        Node previous = getNode(index-1);
        
    //    System.out.println(previous.value);
        
        if(previous.next!=null){
            previous.next = slow.next;
        }
        previous = head;
    }
    private int getIndex(Node node){
        Node temp = head;
        int index = 0;
        while(temp!=node){
            index = index + 1;
            temp = temp.next;
            
        }
        return index;
    }
    private Node getNode(int index){
        Node node = head;
        for(int i = 0; i < index;i++){
            node = node.next;
        }
        return node;
    }
    private class Node{
        int value; 
        Node next;
        public Node(int value){
            this.value = value;
        }
        public Node (int value, Node next){
            this.value = value;
            this.next= next;
        }
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		DeleteMiddleofaLinkedList LL = new DeleteMiddleofaLinkedList();
		LL.insertFirst(6);
                LL.insertFirst(2);
		LL.insertFirst(1);
		LL.insertFirst(7);
                LL.insertFirst(4);
		LL.insertFirst(3);
		LL.insertFirst(2);
		LL.insertFirst(1);
		LL.insertFirst(2);
		
		LL.display();
		
		System.out.println();
		
		LL.middle();
		System.out.println();
		LL.display();
	}
}
