/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 04/30/2024
 *https://leetcode.com/problems/as-far-from-land-as-possible/
 * @author parth
 */
public class AsfarfromLandasPossible {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[][] grid = {
            {1,0,0},
            {0,0,0},
            {0,0,0}    
        };
        int answer = maxDistance(grid);
        
       System.out.println(answer);
    }
    
    public static int[][] directions = {
        {0,1},
        {0,-1},
        {-1,0},
        {1,0}
    };
    
    public static boolean isValid(int[][] grid, int row, int col){
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
    
    public static int maxDistance(int[][] grid){
        int landCount = 0;
        int waterCount = 0;
        Queue<dpair> queue = new LinkedList<>();
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length;j++){
                if(grid[i][j] == 1){
                    landCount++;
                    queue.add(new dpair(i,j));
                }else{
                    waterCount++;
                }
            }
        }
        
        /*
         We are peforming BFS from all the land cells 
         so the queue is going to have all the land cells 
         after that we are getting the maximum level
         so for the first level we are going to proesses all the zeroes that are 1 distance away from the land
        cell and mark all the visited zeroes as 1 so as to we don't visit them again    
        */
        
        if(landCount == 0 || waterCount == 0){
            return -1;
        }
        int level = -1; //this is our final answer
        while(!queue.isEmpty()){
            
            int size = queue.size();
           
            while(size > 0){
           dpair rem = queue.poll(); // queue would only contain 0;s location
           
           for(int i = 0; i< 4;i++){
               int rowdash = rem.x + directions[i][0];
               int coldash = rem.y + directions[i][1];
               
               if(isValid(grid,rowdash,coldash) && grid[rowdash][coldash] == 0){
                   queue.add(new dpair(rowdash,coldash));
                   grid[rowdash][coldash] = 1; //mark it as visited
                   
               }
           }
           size--;
        }
            level++;
    }
        return level;
}
}
class dpair{
    int x;
    int y;
    public dpair(int x, int y){
        this.x = x;
        this.y = y;
    
    }
    
}
