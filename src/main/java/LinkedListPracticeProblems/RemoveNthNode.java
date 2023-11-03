/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;

/**
 *https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Date: 11/02/2023
 * @author parth
 */
public class RemoveNthNode {
    private Node head;
    private int size;
    public RemoveNthNode(){
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
    public void removeNthNode(int n){
          removeNthNode(head,n);
    }
    private void removeNthNode(Node node, int n){
        
        //When n is less than equal to 0 or  is greater than the size 
        if(n <= 0 || n > size){
            return;
        }
        //When there is only 1 element to delete
        if(n == 1 && size == 1){
            head = null;
            size = size - 1;
            return;
        }
        //When we want the delete the  first element
        if(n == size){
            head = head.next;
            size = size - 1;
        }
        //When we want to delete the last element
        if(n == 1){
         Node temp = get(size-2);
         temp.next = null;
         size = size - 1;
         return;
        }
        //Other case i.e we want to delete element in the middle
        Node previous = get(size - n -1 );
        Node temp = get(size - n);
//        System.out.println(temp.value);
//        System.out.println(previous.value);
        
        previous.next = temp.next;
        size = size - 1;
        
    }
    private Node get(int index){
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
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
    public static void main(String args[]) {
        RemoveNthNode LL = new RemoveNthNode();
        LL.insertFirst(20);
        LL.insertFirst(40);
        LL.insertFirst(60);
        LL.insertFirst(80);
        LL.insertFirst(120);
        LL.insertFirst(100);
        
  
        System.out.println("");
        System.out.println(LL.size);
        
       
        
        LL.display();
        
        LL.removeNthNode(3);
        System.out.println("");
        
        LL.display();
        //LL.display();
    }
}
