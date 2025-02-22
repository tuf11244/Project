/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;

/**
 *https://leetcode.com/problems/swap-nodes-in-pairs/
 * Date: 11/03/2024
 * @author parth
 */
public class SwapNodesinPairs {
    
    private Node head;
    private int size = 0;
    public SwapNodesinPairs(){
        this.head = null;
    }
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        size = size + 1;
    }
    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }
   
    
   public ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode even = head;
        ListNode odd = null;
        if(even.next == null){
            return even;
        }else{
            odd = even.next;
        }

        while(even != null && odd != null){

            //Swap 
            int val = odd.val;
            odd.val = even.val;
            even.val = val;

            if(odd.next != null){
                even = odd.next;
            }else{
                break;
            }

            if(even.next != null){
                odd = even.next;
            }else{
                break;
            }
        }
        return head;
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
        SwapNodesinPairs LL = new SwapNodesinPairs();
        LL.insertFirst(1);
        LL.insertFirst(2);
        LL.insertFirst(3);
        LL.insertFirst(4);
        
        LL.display();
        
        LL.swapinPairs();
        
        System.out.println("");
        
        LL.display();
    }
}
