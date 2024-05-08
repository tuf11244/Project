/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */


import java.util.PriorityQueue;

/**
 *Date: 05/07/2024
 * https://leetcode.com/problems/swim-in-rising-water/
 * @author parth
 */
public class SwiminRisingWater {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static boolean isValid(int[][] grid, int row, int col){
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
    public static int[][] directions = {
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };
    public static int swimInWater(int[][] grid){
        PriorityQueue<fpair> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        pq.add(new fpair(0,0,grid[0][0]));
        
        while(!pq.isEmpty()){
            fpair rem = pq.poll();
            //Base case
            if(rem.row == grid.length-1 && rem.col == grid[0].length-1){
                return rem.maxSoFar;
            }
            
            if(visited[rem.row][rem.col] == true){
                continue;
            }
            
            visited[rem.row][rem.col] = true;
            
            for(int i = 0; i < 4;i++){
                int rowdash = rem.row + directions[i][0];
                int coldash = rem.col + directions[i][1];
                
                if(isValid(grid,rowdash,coldash) && visited[rowdash][coldash] == false){
                    pq.add(new fpair(rowdash,coldash,Math.max(rem.maxSoFar, grid[rowdash][coldash])));
                }
            }
        }
        return 0;
       
    }
}

class fpair implements Comparable<fpair>{
    int row;
    int col;
    int maxSoFar;
    
    public fpair(int row, int col, int maxSoFar){
        this.row = row;
        this.col = col;
        this.maxSoFar = maxSoFar;
    }

    @Override
    public int compareTo(fpair o) {
        return this.maxSoFar - o.maxSoFar;
    }
    
}
