/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartIII;

/**
 *Date: 01/27/2025
 * https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/
 * @author parth
 */
public class MaximumNumberofFishinaGrid {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    
    public int findMaxFish(int[][] grid) {
        int maxFishes = 0;
        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length;j++){
                  if(grid[i][j] > 0){
                       int[] fishes = new int[1];
                       dfs(i,j,grid,fishes);
                       maxFishes = Math.max(fishes[0],maxFishes);
                  }
            }
        }
        
       return maxFishes;
    }

    public void dfs(int row, int col, int[][] grid, int [] fishes){
        if(!isValid(row,col,grid) || grid[row][col] == 0){
            return;
        }
        fishes[0] = fishes[0] + grid[row][col];
        grid[row][col] = 0;

        dfs(row+1,col,grid,fishes);
        dfs(row-1,col,grid,fishes);
        dfs(row,col+1,grid,fishes);
        dfs(row,col-1,grid,fishes);
    }

    public boolean isValid(int row, int col, int[][] grid){
        return row >= 0 && row < grid.length && col >=0 && col < grid[0].length;
    }
}
