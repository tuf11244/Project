/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;

/**
 *Date: 09/18/2024
 * https://leetcode.com/problems/cherry-pickup/
 * This gives TLE 18/60 test cases
 * @author parth
 */
public class CherryPickupBackTracking {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int maxCherries = 0;
    
    public static int cherryPickup(int[][] grid){
        
        
        cherryPickupHelper(0,0,grid,0);
        
        return maxCherries;
    }
    
    public static void cherryPickupHelper(int row, int col, int[][] grid, int cherry){
        if(!isValid(row,col,grid) || grid[row][col] == -1){
            return;
        }
        
        if(row == grid.length - 1 && col == grid[0].length - 1){
            //We have travelled from top left to bottom right
            //now we need to travel from bottom right to top left 
            helper(row,col,grid,cherry);
        }
        
        int c = grid[row][col];
        grid[row][col] = 0;
        //Function calls to the right 
        cherryPickupHelper(row,col+1,grid,cherry+c);
        
        //Function calls to the down
        cherryPickupHelper(row+1,col,grid,cherry+c);
        
        grid[row][col] = c; //BackTrack
        
        
    }
    public static void helper(int row, int col, int[][] grid, int cherry){
        if(!isValid(row,col,grid) || grid[row][col] == -1){
            return;
        }
         if(row == 0 && col == 0){
            maxCherries = Math.max(maxCherries,cherry);
            return;
        }
        
        int c = grid[row][col];
        grid[row][col] = 0;
        //Function calls to the left 
        cherryPickupHelper(row,col-1,grid,cherry+c);
        
        //Function calls to the up
        cherryPickupHelper(row-1,col,grid,cherry+c);
        
        grid[row][col] = c; //BackTrack
        
    }
    public static boolean isValid(int row, int col, int[][] grid){
        return row >= 0 && row < grid.length && col>= 0 && col < grid.length;
    }
}
