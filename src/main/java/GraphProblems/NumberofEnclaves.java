/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblems;

/**
 * Date : 04/28/2024
 *https://leetcode.com/problems/number-of-enclaves/
 * 
 * @author parth
 */
public class NumberofEnclaves {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int numEnclaves(int[][] grid) {
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length;j++){
                //Meaning only call the function when its on the boundary and the grid[i][j] == 1;
                if(i == 0 || i == grid.length -1 || j == 0 || j == grid[0].length -1){
                    if(grid[i][j] == 1){
                        dfs(grid,i,j); //so the connected components of the boundary 1's will be marked as zero
                    }
                }
            }
        }
        int count = 0;
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length;j++){
                if(grid[i][j] == 1){ //means there was no way out for them 
                    count++;
                }
            }
        }
        return count;
    }
    
    public static boolean isValid(int[][] grid, int row, int col){
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
    public static void dfs(int[][]grid, int row, int col){
        if(!isValid(grid,row,col) || grid[row][col] == 0){
            return;
        }
        
        grid[row][col] = 0; // Mark all the connected components of the boundary 1's as 0
        dfs(grid,row+1,col);
        dfs(grid,row-1,col);
        dfs(grid,row,col+1);
        dfs(grid,row,col-1);
    }
}
