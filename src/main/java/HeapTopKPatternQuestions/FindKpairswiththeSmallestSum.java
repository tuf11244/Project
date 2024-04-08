/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapTopKPatternQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Date: 04/01/2024
 *https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 * https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/
 * @author parth
 */
public class FindKpairswiththeSmallestSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       int[] nums1 = {1,1,2};
       int[] nums2 = {1,2,3};
       List<List<Integer>> answer = kSmallestPairsOptimized(nums1,nums2,2);
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
    
    public static List<List<Integer>> kSmallestPairsOptimized(int[] nums1, int[] nums2, int k){
        //Min Priority Queue
        PriorityQueue<Pair10> pq = new PriorityQueue<>();
        List<List<Integer>> answer = new ArrayList<>();
        for(int i = 0; i < Math.min(nums1.length,k);i++){
           pq.add(new Pair10(i, 0, nums1[i] + nums2[0]));
        }
        System.out.println(pq);
        
        while(!pq.isEmpty() && answer.size() < k){
            int i = pq.peek().x;
            int j = pq.poll().y;
            answer.add(Arrays.asList(nums1[i], nums2[j]));
            
            if(j+1 < nums2.length){
                pq.add(new Pair10(i, j + 1, nums1[i] + nums2[j + 1]));
            }
        }
        return answer;
        
        
    }
    
    
    
    //Question: https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/
    public static int kthSmallest(int[][] mat, int k) {
     int[] row = mat[0];

     for(int i = 1; i < mat.length;i++){
        row = helper(row,mat[i],k);
     }
     return row[k-1];   
}
    public static int[] helper(int[] nums1, int[] nums2, int k){
        List<Integer> answer = new ArrayList<>();
        PriorityQueue<Pair10> pq = new PriorityQueue<>();

        for(int i = 0; i < Math.min(k, nums1.length);i++){
            pq.add(new Pair10(i,0,nums1[i]+nums2[0]));
        }

        while(!pq.isEmpty() && answer.size() < k){
            int i = pq.peek().x;   //First we are using pq.peek()
            int j = pq.poll().y;  //Because if we use pq.poll in the above line it would give us a null point exception 
            answer.add(nums1[i]+ nums2[j]);
            if(j+1 < nums2.length){
                 pq.add(new Pair10(i,j+1,nums1[i]+nums2[j+1]));
            }
        }
        int[] result = new int[answer.size()];
        for(int i = 0; i < result.length;i++){
            result[i] = answer.get(i);
        }
        return result;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pair10{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", sum=").append(sum);
        sb.append('}');
        return sb.toString();
    }
    
}

