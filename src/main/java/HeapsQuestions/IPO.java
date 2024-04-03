/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapsQuestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Date: 04/02/2024
 *https://leetcode.com/problems/ipo/
 * @author parth
 */
public class IPO {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        
       //We are creating a 2D arrays projects 
       //which would have the following 
       //projects[i][0]  = profits[i]
       //projects[i][1]  = capital[i]
       int[][] projects = new int[profits.length][2];
       for(int i = 0; i < profits.length;i++){
           projects[i][0] = profits[i];
           projects[i][1] = capital[i];
       }
       
       //Now we are sorting are projects 2D array based on the capital in asceding order
       //i.e. the least capital one would be at first position 
       Arrays.sort(projects,(a,b) -> a[1] - b[1]);
       //Now intializing our  Max PriorityQueue since we want projects with maximum profit top most
       PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
       int i = 0;
       //Since we are allowed to do maximum of k projects
       while(k > 0){
           //If the projects capital is less than what we have initially add the profits in our pq
           while(i < capital.length && projects[i][1] <= w){
               pq.add(projects[i][0]);
               i++;
           }
           
           if(pq.isEmpty()){
               break;
           }
           int profit = pq.poll();
           w = w + profit;
           k--;
       }      
     return w;  
    }
}
