/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package LinkedListPracticeProblems;

import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author parth
 */
public class TwoSumII {

    /**
     * Date: 11/02/2023
     * https://leetcode.com/problems/add-two-numbers-ii/
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        LinkedList<Integer> L1 = new LinkedList<>();
        LinkedList<Integer> L2 = new LinkedList<>();
        
      //  L1.add(7);
        L1.add(2);
        L1.add(4);
        L1.add(3);
        
        L2.add(5);
        L2.add(6);
        L2.add(4);
        System.out.println(L1);
        System.out.println(L2);
        
       Collections.reverse(L1);
       Collections.reverse(L2);
        
        
        LinkedList<Integer> answer = addTwoLinkedList(L1,L2);
        System.out.println(answer);
    }
    public static LinkedList<Integer> addTwoLinkedList(LinkedList<Integer> L1, LinkedList<Integer> L2){
        LinkedList<Integer> answer = new LinkedList<Integer>();
        int carry = 0; //Initialize carry variable 
   
        
        int maxSize = Math.max(L1.size(),L2.size());
        
        for(int i = 0; i < maxSize; i++){
            int digit1 = 0;
            if(i < L1.size()){
                digit1 = L1.get(i);
            }
            int digit2 = 0;
            if(i < L2.size()){
                digit2 = L2.get(i);
            }
            int sum = digit1 + digit2 + carry;
            carry = sum/10;
            
            if(carry > 0){
                answer.add(sum%10);
            }else{
                answer.add(sum);
            }
         
        }
        if(carry > 0){
            answer.add(carry);
        }
        
        Collections.reverse(answer);
        
        return answer;
        
    }
}
