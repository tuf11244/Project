/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;

import java.util.Arrays;

/**
 *https://leetcode.com/problems/split-linked-list-in-parts/
 * Date: 11/08/2023
 * @author parth
 */
public class SplitLinkedListinParts {
    private Node head;
    private int size;
    public SplitLinkedListinParts(){
        this.head = null;
        size = 0;
    }
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        
        size = size+1;
    }
    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }
    
    public Node[] splitListtoParts(int k){
         return splitListtoParts(head,k);
    }
    private Node[] splitListtoParts(Node node, int k){
        int eachBucketNodes = size/k;
        int remaniningNodes = size % k;
        
        
        Node current = node;
        Node previous = null;
        
        Node[] result = new Node[k];
        for(int i = 0; i < k ; i++){
            result[i] = current;
            
            for(int count = 1; count <= eachBucketNodes + (remaniningNodes > 0 ? 1 : 0) ; count++){
                
                previous = current;
                current = current.next;
            }
            if(previous!=null){
                previous.next = null;
            }
            remaniningNodes = remaniningNodes - 1;
        }
        return result;
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
    public static void main(String args[]) {
        SplitLinkedListinParts LL = new SplitLinkedListinParts();
        LL.insertFirst(5);
        LL.insertFirst(4);
        LL.insertFirst(3);
        LL.insertFirst(2);
        LL.insertFirst(1);
        
        LL.display();
        
        System.out.println("");
        Node[] result = LL.splitListtoParts(3);
        for (Node node : result) {
        if (node != null) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    }
    }
}
