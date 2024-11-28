/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartIII;
import java.util.*;
/**
 *Date: 11/27/2024
 * https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner/
 * Simple Djkstra ...don't waste too much time on it please
 * @author parth
 */
public class MinimumObstacleRemovalFromEachCorner {

    /**
     * @param args the command line arguments
     */
    public int[][] directions = {
        {0,1},
        {0,-1},
        {1,0},
        {-1,0}
    };
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int minimumObstacles(int[][] grid) {
        //Djikstra
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        PriorityQueue<Pair> queue = new PriorityQueue<>();

        queue.add(new Pair(0,0,0));

        int n = grid[0].length;
        while(!queue.isEmpty()){
            Pair rem = queue.poll();

            if(rem.row == grid.length - 1 && rem.col == grid[0].length - 1){
                return rem.obstacle;
            }
            
            if(visited[rem.row][rem.col] == true){
                continue;
            }
            visited[rem.row][rem.col]  = true;

            for(int i = 0; i < 4;i++){
                int newRow = rem.row + directions[i][0];
                int newCol = rem.col + directions[i][1];
                if(isValid(grid,newRow, newCol) && !visited[newRow][newCol]){

                        if(grid[newRow][newCol] == 0){
                            queue.add(new Pair(newRow,newCol,rem.obstacle));
                        }else{
                             queue.add(new Pair(newRow,newCol,rem.obstacle+1));
                        }
                }
            }

        }
        return -1;
    }

    public boolean isValid(int[][] grid, int row, int col){
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}
class Pair implements Comparable<Pair>{
    int row;
    int col;
    int obstacle;

    public Pair(int row, int col, int obstacle){
        this.row = row;
        this.col = col;
        this.obstacle = obstacle;
    }
    public int compareTo(Pair o){
        return this.obstacle - o.obstacle;
    }
}
