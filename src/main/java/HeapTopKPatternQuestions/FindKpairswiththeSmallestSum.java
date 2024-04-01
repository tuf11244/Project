/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapTopKPatternQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Date: 04/01/2024
 *https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 * @author parth
 */
public class FindKpairswiththeSmallestSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       int[] nums1 = {1,1,2};
       int[] nums2 = {1,2,3};
       List<List<Integer>> answer = kPairsOptimized(nums1,nums2,2);
       for(List<Integer> element : answer){
           System.out.println(element);
       }
    }
    
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
      //Max Priority Queue based on the sums 
      PriorityQueue<Pair10> pq = new PriorityQueue<>(Collections.reverseOrder());
      for(int i = 0; i < nums1.length;i++){
          for(int j = 0; j < nums2.length;j++){
              if(pq.size() < k){
                  pq.add(new Pair10(nums1[i], nums2[j], nums1[i] + nums2[j]));
              }
              else if(pq.peek().sum > nums1[i] + nums2[j]){
                  pq.poll();
                  pq.add(new Pair10(nums1[i], nums2[j], nums1[i]+nums2[j]));
              }else{
                  break;
              }
          }
      }
     
      List<List<Integer>> answer = new ArrayList<>();
      while(k > 0){
          Pair10 p = pq.poll();
          List<Integer> temp = new ArrayList<>();
          temp.add(p.x);
          temp.add(p.y);
          answer.add(temp);
          k--;
      }
        return answer;
      
    }
    
    
  public static List<List<Integer>> kPairsOptimized(int nums1[], int nums2[], int k){
       //Min Heap Priority
       //Pair11 is class that would contains sum and index of nums1 and index of nums2
       PriorityQueue<Pair11> pq = new PriorityQueue<>();
       
       //Element11 is class that woudl just contains index of nums1 and index of nums2
       Set<Element11> set = new HashSet<>();
       int i = 0;
       int j = 0;
       pq.add(new Pair11(nums1[i]+nums2[j],i,j));
       set.add(new Element11(i,j));
       
       List<List<Integer>> answer = new ArrayList<>();
       
       while(k > 0 && !pq.isEmpty()){
           //Remove pair from our priority Queue 
           Pair11 p = pq.poll();
           List<Integer> temp = new ArrayList<>();
           temp.add(nums1[p.x]);
           temp.add(nums2[p.y]);
           answer.add(temp);
           
           //Push Pair (i,j+1) if possible
           if(j+1 < nums2.length && !set.contains(new Element11(i,j+1))){
               pq.add(new Pair11(nums1[i] + nums2[j+1], i,j+1));
               //Also add it in our set 
               set.add(new Element11(i,j+1));
           }
           
           //Push Pair (i+1,j) if possible
           if(i+1 < nums1.length && !set.contains(new Element11(i+1,j))){
               pq.add(new Pair11(nums1[i+1] + nums2[j], i+1,j));
               //Also add it in our set 
               set.add(new Element11(i+1,j));
           }
           k--;
           
       }
       
      
      return answer;
}
}

class Pair10 implements Comparable<Pair10> {
    int x;
    int y;
    int sum;
    public Pair10(int x, int y, int sum){
        this.x = x;
        this.y = y;
        this.sum = sum;
    }

    @Override
    public int compareTo(Pair10 o) {
        return this.sum - o.sum;
    }
    
    
}
//--------------------------------------------------------------------------------------------------------------------------------



class Pair11 implements Comparable<Pair11> {
    int x;
    int y;
    int sum;
    public Pair11(int x, int y, int sum){
        this.x = x;
        this.y = y;
        this.sum = sum;
    }

    @Override
    public int compareTo(Pair11 o) {
        return this.sum - o.sum;
    }
     
}

class Element11 {
    int i; 
    int j;
    
    public Element11(int i, int j){
        this.i = i;
        this.j = j;
    }
}

