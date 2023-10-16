/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TreePracticeProblems;

/**
 *
 * @author parth
 */
//https://leetcode.com/problems/linked-list-in-binary-tree/
public class LinkedListinBinaryTree{   
   private ListNode head;
   private Node root;
   
    public static boolean isSubPath(ListNode head, Node node){
        if(node == null){
            return false; //Reached a leaf node in the binary tree
        }
        if(head == null){
            return true;    //Empty list is always a subpath
        }
        // Check if the current node matches the linked list node
        if(node.value == head.value){
            // If there's a match, continue searching in left or right subtree
            return isSubPath(head.next,node.left) || isSubPath(head.next,node.right);
        }       
        // If there's no match, start over from the root of the binary tree
       return isSubPath(head,node.left) || isSubPath(head,node.right);
     
    }
    private class ListNode{
        int value;
        ListNode next;
        public ListNode(int value){
            this.value = value;
        }
        
    }
    private class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value = value;
        }
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
}
