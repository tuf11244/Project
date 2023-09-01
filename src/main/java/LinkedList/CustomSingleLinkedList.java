/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedList;

/**
 *Date: 08/30/2023
 * @author parth
 */
public class CustomSingleLinkedList {
    
    private Node head; 
    private Node tail; 
    private int size;
    
    CustomSingleLinkedList(){
        this.size = 0;
    }
    
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head; 
        head = node; 
        
        if(tail == null){
            tail = head;
        }
        size = size + 1;
    }
    public void display(){
        Node temp = head; 
        while(temp != null){
            System.out.print(temp.value + "-->");
            temp = temp.next;
        }
        System.out.print("END");
    }
    public void insertLast(int val){
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size = size+1;
       if(tail == null){
           insertFirst(val);
       }
    }
    public void insert(int val, int index){
       if(index == 0){
           insertFirst(val);
           return;
       }
       if(index == size){
           insertLast(val);
           return;
       }
       Node temp = head;
       for(int i = 1; i < index;i++){
           temp = temp.next;
       }
       Node node = new Node(56,temp.next);
       temp.next = node;
       size = size + 1;
    }
    
    public int deleteFirst(){
        int val = head.value;
        head= head.next;
        if(head == null){
            tail = null;
        }
        size = size - 1;
        return val;
    }
    public int deleteLast(){
        if(size<=1){
            return deleteFirst();
        }
        int val = tail.value;
        tail = get(size-2);
        tail.next = null;
        return val;
    }
    public int delete(int index){
        if(index == 0){
            return deleteFirst();
        }
        if (index == size - 1){
            return deleteLast();          
        }
        Node previous = get(index-1);
        int val = previous.next.value;
        
        previous.next = previous.next.next;
        
        return val;
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
    
    public Node get(int index){
        Node node = head; 
        for(int i = 0; i < index;i++){
           node = node.next;
        }
        return node;
    }

    /**
     * @param args the command line arguments
     */
    private class Node{
      private int value; 
      private Node next;
      
      public Node(int value){
          this.value = value;
      }
      public Node(int value, Node next){
          this.value = value;
          this.next = next;
      }
      
    }
    
    public static void main(String[] args){
        CustomSingleLinkedList list = new CustomSingleLinkedList();
        list.insertFirst(14);
        list.insertFirst(28);
        list.insertFirst(42);
       // list.insert(100,3);
        //list.display()
       list.insertLast(9);
       //list.insert(100, 3);
       // System.out.println(list.deleteFirst());
        System.out.println(list.deleteLast());
        System.out.println(list.delete(1));
        list.display();
        
    }
    
}
