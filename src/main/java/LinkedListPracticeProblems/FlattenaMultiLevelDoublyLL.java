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
        if (node != null) {
            flattenRecursive(node);
        }
        return node;
    }

    private Node flattenRecursive(Node currentNode) {
        Node tailNode = currentNode;
        while (currentNode != null) {
            Node nextNode = currentNode.next;
            Node childNode = currentNode.child;
            if (childNode != null) {
                Node childTailNode = flattenRecursive(childNode);
                childTailNode.next = nextNode;
                if (nextNode != null) {
                    nextNode.previous = childTailNode;
                }
                currentNode.next = childNode;
                currentNode.child = null;
                childNode.previous = currentNode;
                currentNode = childTailNode;
            } else {
                currentNode = nextNode;
                if (currentNode != null) {
                    tailNode = currentNode;
                }
            }
        }
        return tailNode;
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
        
    }
}
