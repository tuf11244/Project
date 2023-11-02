/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;

/**
 *https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 * Date: 11/01/2023
 * @author parth
 */
public class FlattenaMultiLevelDoublyLL {
    private Node head;
    
    public FlattenaMultiLevelDoublyLL(){
        
    }
    public Node flatten(Node node) {
    if (node == null) {
        return null;
    }

    Node temp = node;
    Node tail = node;
    while (temp != null) {
        Node child = temp.child;
        Node next = temp.next;

        if (child != null) {
            Node childTail = flatten(child);
            temp.child = null;
            temp.next = child;
            child.previous = temp;

            if (next != null) {
                tail.next = next;
                next.previous = tail;
            }

            tail = childTail;
        } else {
            tail = temp;
        }

        temp = next;
    }

    return tail;
}



    private class Node{
        int value;
        Node next;
        Node previous;
        Node child;
        
        public Node(int value){
            this.value = value;
        }
    }
    public static void main(String args[]) {
        FlattenaMultiLevelDoublyLL list = new FlattenaMultiLevelDoublyLL();

    // Create nodes for the multi-level doubly linked list
    FlattenaMultiLevelDoublyLL.Node node1 = list.new Node(1);
    FlattenaMultiLevelDoublyLL.Node node2 = list.new Node(2);
    FlattenaMultiLevelDoublyLL.Node node3 = list.new Node(3);
    FlattenaMultiLevelDoublyLL.Node node4 = list.new Node(4);

    // Connect the nodes as a multi-level doubly linked list
    node1.next = node2;
    node2.previous = node1;
    node2.next = node3;
    node3.previous = node2;
    node3.child = node4;

    // Flatten the multi-level doubly linked list
    FlattenaMultiLevelDoublyLL.Node flattenedList = list.flatten(node1);

    // Print the flattened doubly linked list
    FlattenaMultiLevelDoublyLL.Node temp = flattenedList;
    while (temp != null) {
        System.out.print(temp.value + " <-> ");
        temp = temp.next;
    }
    }
}
