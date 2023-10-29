/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package StackandQueuesPracticeProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *https://practice.geeksforgeeks.org/problems/card-rotation5834/1
 * Date: 10/29/2023
 * @author parth
 */
public class CardRotation {

    public static void main(String args[]) {
       List<Integer> answer = cardRotation(5);
        System.out.println(answer);
           
    
    }
    public static List<Integer> cardRotation(int N){
         int arr[] = new int[N];
         int n =N;
         
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=1;i<=n;i++){
            queue.add(i);
        }
        int k=1;
        while(!queue.isEmpty()){
            for(int i=0;i<k;i++){
                int x=queue.poll();
                queue.add(x);
            }
            arr[queue.peek()-1]=k;
            queue.poll();
            k++;
        }
         ArrayList<Integer> answer = new ArrayList<Integer>();
        for(int i=0;i<n;i++){ 
                answer.add(arr[i]);
            }
        return answer;
    }
   
}
