/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedList;

/**
 *
 * @author parth
 */
public class CustomDoubleLinkedList {
    
    private Node head;
    private Node tail;
    private int size;

    public CustomDoubleLinkedList() {
        this.size = size;
    }
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.previous = null;
        if(head != null){
             head.previous = node;
        }
        head = node;
        
        if(head == null){
            tail = null;
        }
        size = size + 1;
    }
    public void display(){
        Node temp = head;
        Node last = null;
        while(temp != null){
            System.out.print(temp.value + "-->");
            last = temp;
            temp = temp.next;
        }
        System.out.print("END");
        System.out.println("");
        while(last!=null){
            System.out.print(last.value + "-->");
            last = last.previous;
        }
        System.out.print("START");
    }
//    public void reverseDisplay(){
//        Node temp = tail; 
//        while(temp!=null){
//            System.out.println(temp.value + "-->");
//            temp = temp.previous;
//        }
//        System.out.print("START");
//    }
    public void insertLast(int val){
        if(tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        node.previous = tail;
        tail = node;
    }
    public void insertLastPart2(int val){
        //This method is for the part without the tail
        Node node = new Node(val);
        Node temp = head; 
        
        if(head == null){
            node.previous = null;
            head = node; 
            return;
        }
        while(temp.next!=null){
            temp = temp.next;
        }
        if(temp.next == null){
            temp.next = node;
            node.previous = temp;
            node.next = null;
        }
    }
    
    public void insert(int val,int value){
        Node p = find(value);
        Node node = new Node(val);
       
        if(p == null){
            System.out.println("Node doesn't exist");
            return;
        }
        node.next = p.next;
        p.next = node;
        node.previous = p;
        if(node.next != null){
            node.next.previous = node;
        }
        size = size + 1;
    }
     public Node find(int value){
        Node node = head;
        while(node != null){
            if(node.value == value){
                return node;
            }
            node = node.next;
        }
        return null;
    }
    
    private class Node {
        private int value; 
        private Node next;
        private Node previous;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
        
        
        
    }
    public static void main(String args[]) {
        CustomDoubleLinkedList list = new CustomDoubleLinkedList();
        list.insertFirst(4);
        list.insertFirst(8);
        list.insertFirst(12);
       // list.insertLast(3);
        
      //  list.display();
        System.out.println("");
      //  list.insertLast(20);
      list.insertLastPart2(20);
        list.insert(0, 20);
        list.display();
        
       // list.insertLast(3);
       // list.display();
      
        
        // TODO code application logic here
    }
}

