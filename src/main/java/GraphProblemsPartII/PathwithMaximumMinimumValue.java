/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *We use Djisktra Algorithm
 * Same logic for Swim in Rising Water Problem 
 * Same logic for Path with Minimum Effort Problem
 * @author parth
 */
public class PathwithMaximumMinimumValue {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[][] grid = {
            {3,4,6,3,4},
            {0,2,1,1,7},
            {8,8,3,2,7},
            {3,2,4,9,8},
            {4,1,2,0,0},
            {4,6,5,4,3}
        };
        
        System.out.println(maximumMinimumValue(grid));
    }
    public static int directions[][] = {
        {0,1},
        {1,0},
        {-1,0},
        {0,-1}
    };
    
    public static boolean isValid(int[][] grid, int row, int col){
        return row >=0 && row < grid.length && col >= 0 && col < grid[row].length;
    }
    public static int maximumMinimumValue(int[][] grid){
        PriorityQueue<Pair6> pq = new PriorityQueue<>(Collections.reverseOrder()); //max Heap 
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        pq.add(new Pair6(0,0,grid[0][0],Integer.MAX_VALUE));
        
        while(!pq.isEmpty()){
            Pair6 rem = pq.poll();
            
            if(rem.i == grid.length - 1 && rem.j == grid[0].length - 1){
                return rem.minValue;
            }
            if(visited[rem.i][rem.j] == true){
                continue;
            }
            visited[rem.i][rem.j] = true;
            
            for(int k = 0; k < 4;k++){
                int rowdash = rem.i + directions[k][0];
                int coldash = rem.j + directions[k][1];
                
                if(isValid(grid,rowdash,coldash) && visited[rowdash][coldash] == false){
                    int minValue = Math.min(rem.minValue,grid[rowdash][coldash]);
                    pq.add(new Pair6(rowdash,coldash,grid[rowdash][coldash],minValue));
                }
            }
        }
       
      return 0;  
    }
}
class Pair6 implements Comparable<Pair6>{
    int i;
    int j;
    int wt;
    int minValue;
    
    public Pair6(int i, int j, int wt, int minValue){
        this.i = i;
        this.j = j;
        this.wt = wt;
        this.minValue = minValue;
    }

    @Override
    public int compareTo(Pair6 o) {
        return this.wt - o.wt;
    }
    
}
