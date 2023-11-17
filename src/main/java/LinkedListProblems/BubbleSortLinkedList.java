/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListProblems;



/**
 *
 * @author parth
 */
public class BubbleSortLinkedList {

    /**https://leetcode.com/problems/sort-list/
     * @param args the command line arguments
     * Date: 09/03/2023
     */
    public static void main(String args[]) {
        LinkedList list = new LinkedList();
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(7);
        list.insertFirst(11);
        list.insertFirst(29);
        list.display();
        list.bubbleSort();
        System.out.println("");
        list.display();
        // TODO code application logic here
    }
}

class LinkedList{
    private Node head;
    private Node tail;
    private int size;
    
    public void insertFirst(int val){
        if(tail == null){
            tail = head;
        }
        Node node = new Node(val);
        node.next = head;
        head = node;
        size = size + 1;
    }
    public void display(){
        Node temp = head;
        while(temp!= null){
            System.out.print(temp.value + "-->");
            temp = temp.next;
        }
        System.out.print("END");
    }
    public int getSize(){
        return size;
    }
    public Node getNode(int index){
        Node current = head;
        for(int i = 1; i < index;i++){
            current = current.next;
        }
        return current;
    }
    public void bubbleSort(){
        bubbleSort(size-1,0);
    }
    public void bubbleSort(int row, int column){
        if(row==0){
            return;
        }
        if(column <= row){
           Node first = getNode(column);
           Node second = getNode(column+1);
           if(first.value > second.value){
               //Swap i.e 3 different case;
               if(first == head){
                   head = second;
                   first.next = second.next;
                   second.next = first;
               }else if(second == tail){
                   Node previous = getNode(column-1);
                   tail = first;
                   first.next = null;
                   second.next = tail;
                   previous.next = second;                 
               }else{
                   Node previous = getNode(column-1);
                   first.next = second.next;
                   second.next = first;
                   previous.next = second;
               }
           }
           bubbleSort(row,column+1);
        }else {
        bubbleSort(row-1,0);
             
    }
    }
    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }        
    }
}
