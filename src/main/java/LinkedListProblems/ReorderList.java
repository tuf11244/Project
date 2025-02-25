/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListProblems;

/**
 *
 * @author parth
 */
public class ReorderList {

    /**
     * Date: 09/06/2023
     * https://leetcode.com/problems/reorder-list/
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
}
class LinkedList3{
    private Node head;
    private Node tail;
    private int size;
    
    public LinkedList3(){
        this.size = 0;
    }
    
    public void reorderList(Node head){
        if(head==null || head.next == null){
            return;
        }
        Node middle = middleNode(head); //Find the middle of the LinkedList 
        
        Node headSecond = reversewithIteration(middle); //The head of the reverse half of the LinkedList
        Node headfirst = head;
        
        //Re-order the List
        while(headfirst != null && headSecond != null){
            Node temp = headfirst.next;
            headfirst.next = headSecond;
            headfirst = temp;
            temp = headSecond.next;
            headSecond.next = headfirst;
            headSecond = temp;
        }
        
        //Setting tail to null
        if(headfirst!=null){
            headfirst.next = null;
        }    
    }
     public Node middleNode(Node head){
        Node fast = head;
        Node second = head;
        
        while(fast!= null && fast.next != null){
            fast = fast.next.next;
            second = second.next;
        }
        return second;
    }
    public Node reversewithIteration(Node head){
        Node previous = null;
        Node present = head;
        Node next = present.next;
        
        while(present!=null){
            present.next = previous;
            previous = present;
            present = next;
            if(next!=null){
                next = next.next;
            }
        }
        head = previous;
        return head;
    }
     private class Node{
        private int value;
        private Node next;
        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }       
    }
}

/*
public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Step 1: Find the middle of the LinkedList
        ListNode middle = findMiddle(head);
        
        // Step 2: Reverse the Second half
        ListNode reverseSecondHalf = reverse(middle.next);
        middle.next = null; // Split the list into two halves
        
        // Step 3: Join them
        merge(head, reverseSecondHalf);  // Pass head, NOT middle
    }

    public void merge(ListNode first, ListNode second) {
        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1; // Move forward
            second = temp2;
        }
    }
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next; // Store next node
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
    

    public ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
*/
