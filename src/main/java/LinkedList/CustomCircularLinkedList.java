/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedList;

/**
 *
 * @author parth
 */
public class CustomCircularLinkedList {
    private Node head; 
    private Node tail; 
    private int size;

    public CustomCircularLinkedList() {
        this.size = size;
    }
    public void insert(int val){
        Node node = new Node(val);
        
        if(head == null){
            head = node;
            tail = node;
            return;
        }
        tail.next = node; 
        node.next = head; 
        tail = node;
    }
    public void display(){
        Node temp = head; 
       do{
           System.out.print(temp.value + "-->");
           temp = temp.next;
       }while(temp!=head);
        System.out.print("END");
    }
    public void delete(int val){
        Node temp = head;
        if(temp == null){
            return;
        }
        if(temp.value == val){
            head = head.next;
            tail.next = head;
            return;
        }
        do{
            Node n = temp.next;
            if(n.value == val){
                temp.next = n.next;
                break;
            }
            n = n.next;
        }while(temp!=head);
    }
    
   

    /**
     * Date: 09/01/2023
     * @param args the command line arguments
     */
    
    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
        public Node(int value,Node next){
            this.value = value; 
            this.next = next;
        }
    
        
    }
    public static void main(String args[]) {
        CustomCircularLinkedList list = new CustomCircularLinkedList();
        list.insert(21);
        list.insert(42);
        list.insert(51);
        list.insert(49);
        list.display();
        list.delete(42);
        System.out.println("");
        list.display();
        // TODO code application logic here
    }
}
