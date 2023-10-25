/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *Date: 10/24/2023
 * https://leetcode.com/problems/find-the-most-competitive-subsequence/
 * @author parth
 */
public class FindtheMostCompetitiveSubsequece {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       int[] arr = {3,5,2,6};
       //mostCompetitiveSubsequence(arr,2);
       System.out.println(Arrays.toString(mostCompetitiveSubsequence(arr,3)));
        }
    
    public static int[] mostCompetitiveSubsequence(int[] arr,int k){
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < arr.length;i++){
            int val = arr[i];
            //Requirement Elements = k - stack.size();
            //Remaining Elements from array = arr.length - i - 1;
            while(stack.size() > 0&& arr[i] < stack.peek() && arr.length-i-1 >= k - stack.size()){
                stack.pop();
            }
            if(stack.size() < k){
                stack.push(val);
            }
        }
       // System.out.println(stack);
        int[] answer = new int[k];
        for(int i = k - 1; i >= 0; i-- ){
            answer[i] = stack.pop();
        }
        return answer;
    }
    }
  

    
