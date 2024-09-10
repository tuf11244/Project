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
        
        // Check if there's a matching subpath starting at this node
        return dfs(head, node) || isSubPath(head, node.left) || isSubPath(head, node.right);
     
    }
    private static  boolean dfs(ListNode head, Node node) {
        if (head == null) {
            // We've matched the entire linked list
            return true;
        }
        if (node == null) {
            // Reached a leaf in the tree but still have nodes left in the list
            return false;
        }
        
        // Check if current node matches and continue recursively
        if (head.value == node.value) {
            return dfs(head.next, node.left) || dfs(head.next, node.right);
        }
        
        // No match at the current node
        return false;
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
