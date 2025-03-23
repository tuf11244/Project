/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GraphProblemsPartIII;
import java.util.*;
/**
 *Date: 03/22/2025
 * https://leetcode.com/problems/detect-cycles-in-2d-grid/
 * @author parth
 */
public class DetectCyclein2DGrid {
    // Directions for moving in 4 possible directions (right, left, up, down)
    public int[][] direction = {
        {0,1},  // Right
        {0,-1}, // Left
        {-1,0}, // Up
        {1,0}   // Down
    };
    
    public boolean containsCycle(char[][] grid) {
        // Visited array to track if a cell has been checked
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        // Traverse the entire grid
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                 // If the cell is not visited, start a BFS from this cell
                 if(!visited[i][j]){
                    if(bfs(i, j, grid, visited)){
                        return true; // Cycle detected
                    }
                 }
            }
        }
        return false; // No cycle found in the entire grid
    }

    public boolean bfs(int row, int col, char[][] grid, boolean[][] visited){
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(row, col));

        while(!queue.isEmpty()){
            Coordinate rem = queue.poll(); // Remove element from queue
            
            // If this node was already visited, a cycle exists
            if(visited[rem.row][rem.col]){
                return true;
            }
            visited[rem.row][rem.col] = true; // Mark current node as visited
            
            // Explore all 4 possible directions
            for(int k = 0; k < 4; k++){
                int newRow = rem.row + direction[k][0];
                int newCol = rem.col + direction[k][1];

                // Check if the new position is within bounds, has the same character, and is not yet visited
                if(isValid(newRow, newCol, grid) && grid[rem.row][rem.col] == grid[newRow][newCol] && !visited[newRow][newCol]){
                    queue.add(new Coordinate(newRow, newCol));
                }
            }
        }
        return false; // No cycle detected in this BFS traversal
    }

    public boolean isValid(int row, int col, char[][] grid){
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}

// Renamed class from Pair to Coordinate for better readability
class Coordinate {
    int row;
    int col;
    
    public Coordinate(int row, int col){
        this.row = row;
        this.col = col;
    }
}

