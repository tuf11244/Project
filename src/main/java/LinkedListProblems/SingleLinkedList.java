/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListProblems;

import java.util.List;

/**
 * Date : 09/01/2023
 * @author parth
 */
public class SingleLinkedList {
    private Node head;
    private Node tail;
    private int size;

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
        if(tail == null){
           insertFirst(val);
       }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size = size+1;
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
    //Remove Duplicates from a sorted List; //Date: 09/01/2023
    public void removeDuplicates(){
        Node temp = head;
        while(temp.next!=null){
            if(temp.value == temp.next.value){
                temp.next = temp.next.next;             
                size = size -1;     
            }else{
                temp = temp.next;
            }
            tail = temp;
            tail.next = null;
    }
    }
    //Merge two Sorted List Date: 09/01/2023
    public SingleLinkedList MergeSortedList(SingleLinkedList first, SingleLinkedList second){
        SingleLinkedList answer = new SingleLinkedList();
        Node f = first.head;
        Node s = second.head;
        while(f != null && s!= null){
            if(f.value < s.value){
                answer.insertLast(f.value);
                f = f.next;
            }else{
                answer.insertLast(s.value);
                s = s.next;
            }
        }
        while(f != null){
            answer.insertLast(f.value);
            f = f.next;
        }
        while(s != null){
            answer.insertLast(s.value);
            s = s.next;
        }   
        return answer;
              
    }
    //If the linkedList has cycle or not
    public boolean hasCycle(SingleLinkedList list){
        Node fast = head;
        Node slow = head;
        while(fast !=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;      
    }
    //Find out the length of cycle
    public int lengthofCycle(Node node){
        Node fast = head; 
        Node slow = head;
        int length = 0;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                Node temp = slow;
                do{
                    temp = temp.next;
                    length = length + 1;
                }while(temp!= slow);
                return length;
            }
        }
        return 0;
    }
    //Node from which the cycle has started
    public Node detectCycle(SingleLinkedList list){
        int length = 0; 
        Node fast = head;
        Node slow = head;
        while(fast !=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                length = lengthofCycle(slow);
            }
        }
        
        //find the start node;
        Node first = head;
        Node second = head;
        
        //move the second node length times
        while(length > 0){
            second = second.next;
            length = length - 1;
        }
        
        //keep moving forward until they will meet at cycle start
        while(first != second){
            first = first.next;
            second = second.next;
        }
        return second;
    }
    
    //Find the middle of LinkedList 
    public Node middleNode(Node head){
        Node fast = head;
        Node second = head;
        
        while(fast!= null && fast.next != null){
            fast = fast.next.next;
            second = second.next;
        }
        return second;
    }
    
    //Sort the LinkedList
    public void bubbleSort(){
        bubbleSort(size-1,0);
    }
    public void bubbleSort(int row, int column){
        if(row == 0){
            return;
        }
        if(column < row){
            Node first = get(column);
            Node second = get(column+1);
        }
        if(){
            
        }
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
    /**
     * Date: 09/01/2023
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        // TODO code application logic here
    }
}
