/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapsQuestions;
import java.util.*;
/**
 *Date: 09/09/2024
 * https://leetcode.com/problems/diagonal-traverse-ii/
 * Can be done using BFS also
 * @author parth
 */
public class DiagonalTraversalI {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        
        PriorityQueue<tuple> pq = new PriorityQueue<>();

        for(int i = 0; i < nums.size();i++){
            for(int j = 0; j < nums.get(i).size();j++){
                pq.add(new tuple(i+j,i,nums.get(i).get(j)));

            }
        }

        int[] answer = new int[pq.size()];
        int idx = 0;
       while(!pq.isEmpty()){
         tuple rem = pq.poll();
         answer[idx] = rem.val;
         idx++;
       }
        return answer;
    }
}

class tuple implements Comparable<tuple>{
    int sum;
    int row;
    int val;
   
   public tuple(int sum,int row, int val){
        this.sum = sum;
        this.row = row;
        this.val = val;
   }

   public int compareTo(tuple o){
       if(this.sum == o.sum){
        return o.row - this.row;
       }
       return this.sum - o.sum;
   }

}


