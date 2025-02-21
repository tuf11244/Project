/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedListPracticeProblems;
import java.util.*;
/**
 *Date: 02/20/2025
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * @author parth
 */

public class ReverseNodesinKGroups {
    
    // Instance variables for managing the final reversed list
    private ListNode answer; // Stores the head of the final reversed linked list
    private boolean toggle;  // Used to track whether this is the first reversed group
    private ListNode EndNode; // Stores the last node of the reversed portion

    // Constructor to initialize the class variables
    public ReverseNodesinKGroups() {
        this.answer = null;
        this.toggle = true;
        this.EndNode = null;
    }

    /**
     * Reverses nodes in k-sized groups in a linked list.
     * @param head The head of the linked list.
     * @param k The group size for reversal.
     * @return The modified linked list after reversing every k nodes.
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head; // Pointer to traverse the linked list
        int count = 0; // Counts the number of nodes in the current group
        ListNode startNode = head; // Pointer to the start of the current k-group
        toggle = true; // Track the first k-group

        while (temp != null) { // Traverse through the linked list
            count++; // Increment count for the current group

            if (count == k) { // When k nodes are found
                ListNode newNode = temp.next; // Store the next node after k-group
                temp.next = null; // Break the link to isolate the k-group

                addNode(startNode); // Reverse the k-group and attach it

                temp = newNode; // Move to the next k-group
                startNode = newNode; // Update the start of the next group
                count = 0; // Reset count for the new group
            } else {
                temp = temp.next; // Move to the next node in the current group
            }
        }

        // If there are remaining nodes (less than k), attach them as is
        if (startNode != null) {
            if (toggle) { // If no reversal happened, return original head
                answer = startNode;
            } else { // Attach remaining nodes to the already reversed list
                EndNode.next = startNode;
            }
        }

        return answer; // Return the modified linked list
    }

    /**
     * Reverses the k-sized group and appends it to the result.
     * @param node The starting node of the k-group.
     */
    public void addNode(ListNode node) {
        ListNode reverseNode = reverse(node); // Reverse the k-group
        ListNode endNode = getEndNode(reverseNode); // Get the last node of the reversed k-group

        if (toggle) { // If this is the first reversed group, set the answer
            answer = reverseNode;
            EndNode = endNode;
        } else { // Otherwise, attach the reversed group to the already reversed list
            EndNode.next = reverseNode;
            EndNode = endNode;
        }
        toggle = false; // Toggle off after the first group is processed
    }

    /**
     * Reverses a linked list and returns the new head.
     * @param head The head of the list to be reversed.
     * @return The new head after reversal.
     */
    public ListNode reverse(ListNode head) {
        ListNode prev = null; // Stores the previous node
        ListNode present = head; // Current node pointer

        while (present != null) { // Traverse through the list
            ListNode next = present.next; // Store next node
            present.next = prev; // Reverse the link
            prev = present; // Move prev forward
            present = next; // Move present forward
        }

        return prev; // Return the new head after reversal
    }

    /**
     * Finds the last node of a given linked list.
     * @param head The head of the list.
     * @return The last node.
     */
    public ListNode getEndNode(ListNode head) {
        ListNode temp = head; // Pointer to traverse the list

        while (temp.next != null) { // Traverse until the last node
            temp = temp.next;
        }

        return temp; // Return the last node
    }
}

/**
 * Definition for singly-linked list nodes.
 */
class ListNode {
    int val;
    ListNode next;

    // Constructor for a single node
    public ListNode(int val) {
        this.val = val;
    }

    // Constructor for a node with a next pointer
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
