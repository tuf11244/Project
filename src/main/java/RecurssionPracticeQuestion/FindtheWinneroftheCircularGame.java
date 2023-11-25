/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

/**
 *https://leetcode.com/problems/find-the-winner-of-the-circular-game/
 * Date: 11/24/2023
 * @author parth
 */
public class FindtheWinneroftheCircularGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        CircularLinkedList LL = new CircularLinkedList();
        for(int i = 1; i <= 5; i++){
            LL.insert(i);
        }
        LL.display();
       LL.findtheWinner(6, 5);
        
        
        
    }
}

class CircularLinkedList{
    private Node head;
    private Node tail;
    private int size;
    
    public CircularLinkedList(){
        this.head = null;
        this.tail = null;
        size = 0;
    }
        
    public void insert(int val){
        Node node = new Node(val);
        
        if(head == null){
            head = node;
            tail = node;
            size = size + 1;
            return;
        }
        tail.next = node; 
        node.next = head; 
        tail = node;
        size = size + 1;
    }
    public void display(){
        Node temp = head; 
       do{
           System.out.print(temp.value + "-->");
           temp = temp.next;
       }while(temp!=head);
        System.out.print("END");
    }
    
    public void findtheWinner(int n, int k){
        findtheWinner(head,n,k);
    }
    private void findtheWinner(Node node, int n, int k){
        Node temp = node;

        
        do{
            Node delete = findNode(temp,k);
            temp.next = delete.next;
            size = size - 1;
            temp = delete.next;
            
        }while(size>2);
        
        System.out.println("The winner is " + temp.value);
    }
    private Node findNode(Node node, int k){
        Node temp = node;
        for(int i = 0; i < k-1;i++){
            temp = temp.next;
        }
        return temp;
    }
        
        
    
    private class Node{
        Node next;
        int value;
        
        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}
