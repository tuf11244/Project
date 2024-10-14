/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package HeapsQuestions;
import java.util.*;
/**
 *Date: 10/13/2024
 * https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/
 * @author parth
 */
public class SmallestRangeCoveringElementsfroKLists {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int[] smallestRange(List<List<Integer>> nums){
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]) ;
        
        int max = Integer.MIN_VALUE;
        
        int[] range = {0,Integer.MAX_VALUE};
        
        for(int i = 0; i < nums.size();i++){
            int val = nums.get(i).get(0);
            pq.add(new int[]{val,i,0});
            
            max = Math.max(val,max);
        }
        
        while(!pq.isEmpty()){
            int[] rem = pq.poll();
            
            int value = rem[0];
            int listIdx = rem[1];
            int index = rem[2];
            
            //Calculate the range 
            if(max- value < range[1] - range[0]){
                range[0] = value;
                range[1] = max;
            }
            
            if(index + 1 < nums.get(listIdx).size()){
                int nextMinimumElement = nums.get(listIdx).get(index +1);
                pq.add(new int[]{nextMinimumElement,listIdx,index+1});
                
                max = Math.max(max,nextMinimumElement);
            }else{
                break; //one of the list has been exhausted;
            }
            
            
        }
        
        return range;
    }
}
