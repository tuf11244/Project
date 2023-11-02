/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;

/**
 *
 * @author parth
 */
public class Hello {
    private Node head;
    private Node tail;
    private int size;
    
    public Hello(){
        this.head = null;
        this.size = 0;
    }
    
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        size = size + 1;
    }
    public void dispaly(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value + "-->");
            temp = temp.next;
        }
        System.out.print("END");
    }
    public void reverse(){
        reverse(head);
    }
    private void reverse(Node node){
       if(node.next == null){
           head = node;
           return;
       }
       reverse(node.next);
       
        
        dispaly();
        
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
        Hello LL = new Hello();
        LL.insertFirst(1);
        LL.insertFirst(2);
        
        LL.dispaly();
        System.out.println("");
        System.out.println(LL.size);
        
        LL.reverse();
        
        
    }
}
