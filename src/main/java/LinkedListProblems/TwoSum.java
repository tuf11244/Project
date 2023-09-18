/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListProblems;
import java.util.LinkedList;
/**
 *Date: 09/17/2023
 * https://leetcode.com/problems/add-two-numbers/
 * @author parth
 */
public class TwoSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println("Hello World");
		LinkedList<Integer> L1 = new LinkedList<>();
		LinkedList<Integer> L2 = new LinkedList<>();
		for(int i = 0; i < 7;i++){
		    L1.add(9);
		}
		for(int i = 0; i < 4;i++){
		    L2.add(9);
		}
		System.out.println(L1);
		System.out.println(L2);
		System.out.println(L1.getFirst());
		System.out.println(add2Lists(L1,L2));
        // TODO code application logic here
    }
    public static LinkedList<Integer> add2Lists(LinkedList<Integer> L1, LinkedList<Integer> L2) {
    LinkedList<Integer> answer = new LinkedList<>();
    int carry = 0; // Initialize carry to 0
    
    // Determine the maximum size of the two lists
    int maxSize = Math.max(L1.size(), L2.size());
    
    for (int i = 0; i < maxSize; i++) {
        int digit1 = 0;
        if (i < L1.size()) {
            digit1 = L1.get(i);
        }
        
        int digit2 = 0;
        if (i < L2.size()) {
            digit2 = L2.get(i);
        }
        
        int sum = digit1 + digit2 + carry; // Calculate the sum
        carry = sum / 10; // Update carry
        
        if (carry > 0) {
            answer.add(sum % 10); // Add the current digit to the answer list
        } else {
            answer.add(sum); // Add the current digit to the answer list without carry
        }
    }
    
    // If there's a remaining carry after the loop, add it to the answer
    if (carry > 0) {
        answer.add(carry);
    }
    
    return answer;
}
}
