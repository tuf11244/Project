/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblems;

import java.util.Arrays;

/**
 *Date: 04/28/2024
 * https://leetcode.com/problems/coloring-a-border/
 * @author parth
 */
public class ColoringaBorder {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[][] grid = {
            {2,3,4,3,1},
            {4,2,2,2,1},
            {1,2,2,2,1},
            {3,2,2,2,1},
            {6,7,0,1,1}
        };
        
        colorBorder(grid,1,1,3); //gets the connected component 
        
       
        
    }
     public static int[][] directions = {
        {0,1},
        {1,0},
        {0,-1},
        {-1,0}
    };
    
    public static void colorBorder(int[][] grid, int row, int col, int color){
         //get the current color 
        int currentColor = grid [row][col];
        dfs(grid,row,col,currentColor);
        
         for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length;j++){
                if(grid[i][j] < 0){
                    grid[i][j] = color; //new color
                }
            }
        }
        
        for(int[] temp : grid){
            System.out.println(Arrays.toString(temp));
        }
    }
    public static boolean isValid(int[][] grid, int row, int col){
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
   
    public static void dfs(int[][] grid, int row, int col,int currentColor){
       grid[row][col] = -currentColor; //mark this as -ve of the current color; this denotes its visited 
       int count = 0;
       for(int i = 0; i < 4;i++){
           int rowdash = row + directions[i][0];
           int coldash = col + directions[i][1];
           
           if(!isValid(grid,rowdash,coldash) || Math.abs(grid[rowdash][coldash]) != currentColor){
               continue;
           }
           
           count++;
           
           if(grid[rowdash][coldash] == currentColor){
               dfs(grid,rowdash,coldash,currentColor);
           }
       }
       
       if(count == 4){  //backtrack 
           grid[row][col] = currentColor;
       }
        
    }
}
