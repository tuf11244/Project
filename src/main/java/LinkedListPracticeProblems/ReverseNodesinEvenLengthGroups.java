/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;

/**
 *https://leetcode.com/problems/reverse-nodes-in-even-length-groups/
 * Date: 11/14/2023
 * @author parth
 */
public class ReverseNodesinEvenLengthGroups {
    private Node head;
    private int size;
    public ReverseNodesinEvenLengthGroups(){
        this.head = null;
        size = 0;
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
    public Node reverseEvenLengthGroups(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node temp = head;
        Node prevNode = null; // Tracks the last node of the previous group
        int group = 1; // Group sizes start at 1
        
        while (temp != null) {
            int count = 0;
            Node groupStart = temp; // Start of the current group

            // Count the nodes in this group
            Node node = temp;
            while (node != null && count < group) {
                count++;
                node = node.next;
            }

            // If group size is even, reverse it
            if (count % 2 == 0) {
                Node nextGroupStart = node; // Save start of next group
                Node reversedGroup = reverse(groupStart, count); // Reverse groupStart for count nodes

                // Connect previous group with reversed group
                if (prevNode != null) {
                    prevNode.next = reversedGroup;
                } else {
                    head = reversedGroup; // If it's the first group, update head
                }

                // Move `groupStart` to its new position
                groupStart.next = nextGroupStart;
                prevNode = groupStart;
                temp = nextGroupStart;
            } else {
                // If not reversed, just move prevNode
                prevNode = temp;
                for (int i = 0; i < count; i++) {
                    prevNode = temp;
                    temp = temp.next;
                }
            }

            group++; // Move to the next group
        }

        return head;
    }

    // Reverse a linked list for a given length
    private Node reverse(Node head, int k) {
        Node prev = null;
        Node present = head;
        while (k-- > 0 && present != null) {
            Node next = present.next;
            present.next = prev;
            prev = present;
            present = next;
        }
        return prev; // New head of the reversed group
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
       ReverseNodesinEvenLengthGroups LL = new ReverseNodesinEvenLengthGroups();
       LL.insertFirst(4);
       LL.insertFirst(8);
       LL.insertFirst(3);
       LL.insertFirst(7);
       LL.insertFirst(1);
       LL.insertFirst(9);
       LL.insertFirst(3);
       LL.insertFirst(6);
       LL.insertFirst(2);
       LL.insertFirst(5);
       
       LL.display();
        System.out.println(" ");
        //LL.reverseNodes();
        LL.display();
    }
}
