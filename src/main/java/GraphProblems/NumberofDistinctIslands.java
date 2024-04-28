/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblems;

import java.util.HashSet;

/**
 *Date: 04/28/2024
 * https://leetcode.com/problems/number-of-distinct-islands/
 * @author parth
 */
public class NumberofDistinctIslands {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        int[][] grid = {
            {1,1,0,1,1},
            {1,0,0,0,0},
            {0,0,0,0,1},
            {1,1,0,1,1}
        };
        System.out.println(numberofDistinctIslands(grid));
    }
    public static StringBuilder psf = new StringBuilder();
    public static int numberofDistinctIslands(int[][] grid){
 
       HashSet<String> set = new HashSet<>();
       
       for(int i = 0; i < grid.length;i++){
           for(int j = 0; j < grid[0].length;j++){
               // If a land cell is found, perform DFS to explore the island
               if(grid[i][j] == 1){
                   // Clear the path so far StringBuilder for each island
                   psf = new StringBuilder();
                   // Start DFS from the current cell
                   psf.append("x"); //// Mark the start of island exploration
                   dfs(grid,i,j); //Explore the island starting from this cell
                   
                   //Add the string to our hashset 
                   set.add(psf.toString());
               }
           }
       }
        System.out.println(set);
        return set.size();
    }
   
    public static void dfs(int[][] grid,int row, int col){
        grid[row][col] = 0; //this acts a visited array
        //  // Mark the current cell as visited
        
        // // Explore all four directions: Up, Right, Down, Left
        if(row-1 >= 0 && grid[row-1][col] == 1){
            psf.append("U"); //for up
            dfs(grid,row-1,col);
        }
        if(col+1 < grid[0].length && grid[row][col+1] == 1){
            psf.append("R"); //for right
            dfs(grid,row,col+1);
        }
        if(row+1 < grid.length && grid[row+1][col] == 1){
            psf.append("D");
            dfs(grid,row+1,col);
        }
        if(col-1 >= 0 && grid[row][col-1] == 1){
            psf.append("L");
            dfs(grid,row,col-1);
        }
        
        psf.append("z"); //for backtracking 
        // Mark the end of current cell exploration
    }
}
