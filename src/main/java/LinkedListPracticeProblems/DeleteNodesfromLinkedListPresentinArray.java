/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;
import java.util.*;
/**
 *Date: 09/05/2024
 * https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/
 * @author parth
 */
public class DeleteNodesfromLinkedListPresentinArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public Node modifiedList(int[] nums, Node head) {
        HashSet<Integer> set = new HashSet<>();
        
        // Add all nums to the set
        for (int n : nums) {
            set.add(n);
        }
        
        // Use a dummy node to simplify edge case handling
        Node dummy = new Node(-1);
        dummy.next = head;
        Node prev = dummy;
        Node current = head;
        
        // Traverse the linked list
        while (current != null) {
            if (set.contains(current.val)) {
                // Skip the node by updating the next pointer of prev
                prev.next = current.next;
            } else {
                // Move prev to the current node
                prev = current;
            }
            // Move current to the next node
            current = current.next;
        }
        
        return dummy.next;
    }
}

 // Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
