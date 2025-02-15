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
            
        if(node == null){
            return null;
        }
        
        Node current = node;
        
        while(current != null){
            
            if(current.child != null){
                Node nextCurrent = current.next ; //next pointer for current so that we don;t loose the pointer 
                
                //Step 1  : flatten the child Linkedlist
                Node temp = flatten(current.child);
                
                //Step 2 : Connect the front part 
                current.next = temp;
                temp.previous = current;
                current.child = null; //make the child pointer null
                
                //Step 3 : Find the tail in temp node 
                while(temp.next != null){
                    temp = temp.next;
                }
                
                //Step 4 : Connect the back part
                
                if(nextCurrent != null){
                    temp.next= nextCurrent;
                    nextCurrent.previous = temp;
                }
                
                
            }else{
                
                current = current.next; //move to the next pointer if no child;
            }
            
        }
        
        
        
        return node;
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
