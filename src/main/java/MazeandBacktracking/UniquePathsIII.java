/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package MazeandBacktracking;

/**
 *Date: 10/03/2024
 * https://leetcode.com/problems/unique-paths-iii/
 * @author parth
 */
public class UniquePathsIII {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public static int uniquePathsIII(int[][] grid){
       int startX = -1, startY = -1, validCells = 1; // Count the starting point as valid
        
        // Find the start and count valid cells
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) { 
                    startX = i;
                    startY = j;
                } else if(grid[i][j] == 0) {
                    validCells++; // Count all empty cells as valid
                }
            }
        }
        return backtrack(grid, startX, startY, validCells);
    }

    private static int backtrack(int[][] grid, int x, int y, int validCells) {
        if(!isValid(grid, x, y) || grid[x][y] == -1) return 0; // Invalid or visited cell
        
        // If we've reached the end and visited all valid cells
        if(grid[x][y] == 2) {
            return validCells == 0 ? 1 : 0;
        }
        
        // Mark the cell as visited
        grid[x][y] = -1;
        int paths = backtrack(grid, x + 1, y, validCells - 1) + 
                    backtrack(grid, x - 1, y, validCells - 1) +
                    backtrack(grid, x, y + 1, validCells - 1) +
                    backtrack(grid, x, y - 1, validCells - 1);
        
        // Unmark the cell (backtrack)
        grid[x][y] = 0;
        
        return paths;
    }
    
    public static boolean isValid(int[][] grid, int row, int col){
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
            
}
