/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 *Date: 05/01/2024
 * https://leetcode.com/problems/sliding-puzzle/
 * @author parth
 */
public class SlidingPuzzle {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int slidingPuzzle(int[][] grid){
        
        String target = "123450";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length;j++){
                sb.append(grid[i][j]);
            }
        }
        
        String initial = sb.toString();
        
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        //swapped Index is nothing but the position that we can swap our zero with 
        //for example  1 2 3 
        //             0 4 5
        //so int the above example 0 is at index 3 ..so we can swap it with index 0 and 4
        // swappedIdx[3] = {0,4}
        int[][] swappedIdx = 
        {
            {1,3},
            {0,2,4},
            {1,5},
            {0,4},
            {1,3,5},
            {2,4}        
        };
        
        //Add the intial String to our queue and visited
        queue.add(initial);
        visited.add(initial);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                String rem = queue.poll();
                
                if(rem.equals(target)){
                    return level;
                }
                
                //find the index of zero in rem string 
                int idx = 0;
                for(int i = 0; i < rem.length();i++){
                    if(rem.charAt(i) == '0'){
                        idx = i;
                        break;
                    }
                }
                //get the valid options with which we can swap our 0
                int[] swap = swappedIdx[idx];
                
                for(int i = 0; i < swap.length;i++){
                    //String found when we swapped the 0 with valid index
                    String tobeAdded = helper(rem,idx,swap[i]);
                    if(visited.contains(tobeAdded) == true){
                        continue;
                    }
                    
                    queue.add(tobeAdded);
                    visited.add(tobeAdded);
                }
                size--;
            }
            level++;
        }
        return -1;
    }
    
    public static String helper(String s, int i, int j){
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(i, s.charAt(j));
        sb.setCharAt(j, s.charAt(i));
        
        return sb.toString();
    }
}
