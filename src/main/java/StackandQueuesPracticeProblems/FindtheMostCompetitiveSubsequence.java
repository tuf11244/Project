/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;
import java.util.*;
/**
 *Date: 02/11/2025
 * https://leetcode.com/problems/find-the-most-competitive-subsequence
 * @author parth
 */
public class FindtheMostCompetitiveSubsequence {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>(); // Use Deque instead of Stack for efficiency
        
        for (int i = 0; i < n; i++) {
            int remaining = n - i;  // Fix: Correct remaining count
            
            // Pop elements from stack if a smaller element is available and we still have enough elements left
            while (!stack.isEmpty() && nums[i] < stack.peekLast() && stack.size() + remaining > k) {
                stack.pollLast();
            }
            
            if (stack.size() < k) {
                stack.offerLast(nums[i]); // Push element
            }
        }
        
        // Convert deque to array
        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = stack.pollFirst();
        }
        
        return answer;
    }
}
