/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapsQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 *Date: 03/25/2024
 * https://leetcode.com/problems/the-skyline-problem/
 * @author parth
 */
public class TheSkylineProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[][] buildings = {
            {2,9,10},
            {3,7,15},
            {5,12,12},
            {15,20,10},
            {19,24,8}    
        };
        
        List<List<Integer>> answer = getSkyline(buildings);
        
//        for(List<Integer> list : answer){
//            System.out.println(list);
//        }
    }
    
    public static List<List<Integer>> getSkyline(int[][] buildings) {
       List<Pair> list = new ArrayList<>();
       
       for(int i = 0; i < buildings.length;i++){
           int startPoint = buildings[i][0];
           int endPoint = buildings[i][1];
           int height = buildings[i][2];
           list.add(new Pair(startPoint,-1 * height));
           list.add(new Pair(endPoint,height));           
       }
       
       Collections.sort(list);
        System.out.println(list);
       List<List<Integer>> answer = new ArrayList<>();
       PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
       
       int currentHeight = 0;
       pq.add(0);
       for(int i = 0; i < list.size();i++){
           int x = list.get(i).x;
           int height = list.get(i).height;
           //meaning its the starting point
           if(height < 0){
               pq.add(-1 * height); //Make the height positive
           }else{
               pq.remove(height);
           }
           
           if(currentHeight != pq.peek()){
               List<Integer> temp = new ArrayList<>();
               temp.add(x);
               temp.add(pq.peek());
               
               answer.add(temp);
               currentHeight = pq.peek();
           }
       }
        return answer;
    }
}

class Pair implements Comparable<Pair>{
    int x;
    int height;
    
    public Pair(int x, int height){
        this.x = x;
        this.height = height;
    }
    @Override
    public int compareTo(Pair o) {
        if(this.x != o.x){
            return this.x - o.x;
        }
        return this.height - o.height;
    }

    @Override
    public String toString() {
        return "Pair{" + "x=" + x + ", height=" + height + '}';
    }
    
    
}
