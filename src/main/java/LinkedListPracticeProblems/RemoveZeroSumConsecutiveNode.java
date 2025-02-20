/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;

/**
 *
 * @author parth
 */
//https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
public class RemoveZeroSumConsecutiveNode{
    
	public static void main(String[] args) {
		System.out.println("Hello World");
		
	}
}

/*

import java.util.HashMap;

class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        HashMap<Integer, ListNode> hm = new HashMap<>();
        int prefix = 0;
        
        // First pass to store prefix sum positions
        for (ListNode curr = dummy; curr != null; curr = curr.next) {
            prefix += curr.val;
            hm.put(prefix, curr);
        }
        
        // Second pass to remove zero sum sublists
        prefix = 0;
        for (ListNode curr = dummy; curr != null; curr = curr.next) {
            prefix += curr.val;
            curr.next = hm.get(prefix).next; // Skip nodes that formed zero-sum
        }
        
        return dummy.next;
    }
}
*/