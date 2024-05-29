/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date: 05/28/2024
 * https://leetcode.com/problems/number-of-closed-islands/
 * @author parth
 */
public class NumberofClosedIslands {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }


    public int closedIsland(int[][] grid) {
        int count = 0;

        for(int i = 0; i < grid.length;i++){
            for(int j =0; j < grid[i].length;j++){
                if(i == 0 || i == grid.length - 1 || j == 0 || j == grid[i].length - 1){
                    dfs(i,j,grid);
                }
               
            }
        }
         // Count and mark closed islands
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (grid[i][j] == 0) {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }

        return count;
    }
    public boolean isValid(int row,int column,int[][] grid){
        return row >= 0 && row < grid.length && column >= 0 && column < grid[0].length;
    }

    public void dfs(int row, int column, int[][] grid){
        if(!isValid(row,column,grid) || grid[row][column] == 1){
            return;
        }
        grid[row][column] = 1;
        dfs(row+1,column,grid);
        dfs(row-1,column,grid);
        dfs(row,column+1,grid);
        dfs(row,column-1,grid);
    }
}
