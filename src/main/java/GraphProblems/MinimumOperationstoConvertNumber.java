/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblems;
import java.util.*;
/**
 * Given an array of integers ( A ), and two integers ( S ) (start value) and ( D ) (destination value), 
 * you are allowed to perform any of the following operations on a value ( x ):
 * Add an element from ( A ) to ( x ): ( x + A[i] )
 * Subtract an element from ( A ) from ( x ): ( x - A[i] )
 * Perform a bitwise XOR of an element from ( A ) with ( x ): ( x XOR A[i] )
 * Each operation counts as one move. 
 * Determine the minimum number of moves required to transform the integer ( S ) into the integer ( D ) using the operations above. 
 * If it's not possible to achieve this transformation, return (-1).
 * Input( A ): An array of integers.( S ): The starting integer.( D ): The target integer.
 * OutputThe minimum number of moves required to convert ( S ) to ( D ), or (-1) if it's impossible.Example Test CaseInput:
 *
 * https://leetcode.com/problems/minimum-operations-to-convert-number/
 * @author parth
 */
public class MinimumOperationstoConvertNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[] nums= {3,5,7};
        System.out.println(minimumOperations(nums,0,-4));
    }
    
    public static int minimumOperations(int[] nums, int start, int goal) {
        HashSet<Integer> visited = new HashSet<>();
        
        Queue<ops> queue = new LinkedList<>();
        
        queue.add(new ops(start,0));
        
        while(!queue.isEmpty()){
            ops rem = queue.poll();
            
            if(rem.x == goal){
                return rem.steps;
            }
            if (rem.x < 0 || rem.x > 1000){
                continue;
            } 
            if(visited.contains(rem.x)){
                continue;
            }
            visited.add(rem.x);
            
            for(int i = 0; i < nums.length;i++){
                
                if(!visited.contains(rem.x + nums[i])){
                    queue.add(new ops(rem.x + nums[i],rem.steps + 1));
                }
                
                if(!visited.contains(rem.x - nums[i])){
                    queue.add(new ops(rem.x - nums[i],rem.steps + 1));
                }
                
                if(!visited.contains(rem.x ^ nums[i])){
                    queue.add(new ops(rem.x ^ nums[i],rem.steps + 1));
                }
            }
            
        }
        return -1;
          
    }
    
}

class ops {
    int x;
    int steps;
    
    public ops(int x, int steps){
        this.x =x;
        this.steps = steps;
    }
}
