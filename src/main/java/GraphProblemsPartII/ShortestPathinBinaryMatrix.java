/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date: 05/28/2024
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 * @author parth
 */
public class ShortestPathinBinaryMatrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[][] grid = {
            {0,1,1},
            {0,0,0},
            {0,0,0}
        };
        
        System.out.println(shortestPathinBinaryMatrix(grid));
    }
    
    public static int[][] directions = {
        {0,1},
        {0,-1},
        {1,0},
        {-1,0},
        {1,1},
        {-1,1},
        {-1,-1},
        {1,-1}
    };
    
    public static int shortestPathinBinaryMatrix(int[][] grid){
        Queue<P> queue = new LinkedList<>();
        if(grid[0][0] != 0 || grid[grid.length-1][grid.length-1] != 0){
            return -1;
        }
        
        queue.add(new P(0,0));
        grid[0][0] = -1;
        
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
               P pair = queue.poll();
               if(pair.row == grid.length-1 && pair.col == grid.length -1){
                   return level +1;
               }
               
              
               
               for(int i =0; i < 8;i++){
                   int rowdash = pair.row + directions[i][0];
                   int coldash = pair.col + directions[i][1];
                   
                   if(isValid(grid,rowdash,coldash) && grid[rowdash][coldash] == 0){
                       queue.add(new P(rowdash,coldash));
                       grid[rowdash][coldash] = -1; //Mark it visited 
                   }
               }
               size--; 
            }
            
          level++;
        }
        return -1;
    }
    
    public static boolean isValid(int[][] grid, int row, int col){
        return row >= 0 && row < grid.length && col >= 0 && col < grid.length;
    }
}


class P{
    int row; 
    int col;
    
    public P(int row,int col){
        this.row = row;
        this.col = col;
                
    }
}
