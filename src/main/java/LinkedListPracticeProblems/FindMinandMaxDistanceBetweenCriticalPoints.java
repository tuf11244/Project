/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 *Date: 07/04/2024
 * https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/
 * @author parth
 */


public class FindMinandMaxDistanceBetweenCriticalPoints
{   



 // Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int count = 2; // The minimum index of local maximum and local minimum could be 2
        ListNode prev = head;
        ListNode current = prev.next;
        ListNode future = current.next;
        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        while (future != null) {
            if ((current.val > prev.val && current.val > future.val) || (current.val < prev.val && current.val < future.val)) {
                if (list.size() > 0) {
                    min = Math.min(min, count - list.get(list.size() - 1));
                }
                list.add(count);
            }

            prev = prev.next;
            current = current.next;
            future = future.next;
            count++;
        }

        if (list.size() < 2) {
            return new int[]{-1, -1};
        }

        int max = list.get(list.size() - 1) - list.get(0); // last element - first element

        return new int[]{min, max};
    }
}


