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
       List<List<Integer>> answer = kSmallestPairs(nums1,nums2,2);
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

