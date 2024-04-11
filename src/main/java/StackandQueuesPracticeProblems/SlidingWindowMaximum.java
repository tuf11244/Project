/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.PriorityQueue;

/**
 *Date: 04/09/2024
 * https://leetcode.com/problems/sliding-window-maximum/
 * Learned from pepCoding 
 * @author parth
 */
public class SlidingWindowMaximum {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int[] answer = slidingWindowMaximum(arr,3);
        System.out.println(answer);
    }
    public static int[] maxSlidingWindow(int[] arr, int k) {
       //The logic is based on the Next greater Element to the Right covered in Stack and Questions Question 
       Stack<Integer> stack = new Stack<>();
       stack.push(arr.length-1);
       int[] nge = new int[arr.length];
       
       nge[nge.length-1] = arr.length;
       
       for(int i = arr.length - 2; i >= 0; i--){
           //First Pop 
           //Second answer 
           //Third Pushes 
            while(stack.size() > 0 && arr[i] >= arr[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nge[i] = arr.length;
            }else{
                nge[i] = stack.peek();
            }
            
            stack.push(i);
       }
       
        System.out.println(Arrays.toString(nge));
        
        List<Integer> list = new ArrayList<>();
        int j = 0;
        for(int i = 0; i <= arr.length - k;i++){
            if(j < i){
                j = i;
            }
            
            while(nge[j] < i + k){
                j = nge[j];
            }
            list.add(arr[j]);
        }
        
        System.out.println(list);
        
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size();i++){
            result[i] = list.get(i);
        }
        return result;
        
    }
    //Using Deque
    public static int[] slidingWindowMaximum(int[] arr, int k){
        int[] ans = new int[arr.length - k + 1];
        int i = 0;
        int j = 0;
        Deque<Integer> dq = new LinkedList<>();
        
        while(i < arr.length){
            if(dq.isEmpty()){
                dq.add(arr[i]);
            }else{
                while(!dq.isEmpty() && dq.peekLast() < arr[i]){
                    dq.removeLast();
                }
                dq.add(arr[i]);
            }
            
            if(i-j+1 < k){
                i++;
            }else if(i-j+1 == k){
                ans[j] = dq.peek();
                if(arr[j] == dq.peek()){
                    dq.removeFirst();
                }
                
                //Slide the Window 
                i++;
                j++;
            }
        }
        return ans;
        
        
    }
}
