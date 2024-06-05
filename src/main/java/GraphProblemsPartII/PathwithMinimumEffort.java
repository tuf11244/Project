/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;
import java.util.*;
/**
 *Date: 06/03/2024
 *https://leetcode.com/problems/path-with-minimum-effort/
 * @author parth
 */
public class PathwithMinimumEffort {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    // Method to check if a given cell is within the grid boundaries
    public static boolean isValid(int[][] heights, int row, int col) {
        return row >= 0 && row < heights.length && col >= 0 && col < heights[0].length;
    }

    // Directions for moving in the grid (right, down, left, up)
    public static int[][] directions = {
        {0, 1},
        {1, 0},
        {0, -1},
        {-1, 0}
    };

    // Main method to find the minimum effort path
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Pair2> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        
        // Add the starting point (0, 0) with an effort of 0
        pq.add(new Pair2(0, 0, 0));
        
        while (!pq.isEmpty()) {
            Pair2 rem = pq.poll();
            
            // Base case: If we've reached the bottom-right corner, return the effort
            if (rem.row == heights.length - 1 && rem.col == heights[0].length - 1) {
                return rem.effort;
            }
            
            // If the cell has already been visited, skip it
            if (visited[rem.row][rem.col]) {
                continue;
            }
            
            // Mark the cell as visited
            visited[rem.row][rem.col] = true;
            
            // Explore all four possible directions
            for (int i = 0; i < 4; i++) {
                int newRow = rem.row + directions[i][0];
                int newCol = rem.col + directions[i][1];
                
                // Check if the new cell is valid and not yet visited
                if (isValid(heights, newRow, newCol) && !visited[newRow][newCol]) {
                    // Calculate the new effort as the maximum of the current effort and the difference in heights
                    int newEffort = Math.max(rem.effort, Math.abs(heights[newRow][newCol] - heights[rem.row][rem.col]));
                    pq.add(new Pair2(newRow, newCol, newEffort));
                }
            }
        }
        
        // If the bottom-right corner is not reachable, return 0 (theoretically should not happen)
        return 0;
    }
}

// Helper class to represent a cell in the grid
class Pair2 implements Comparable<Pair2> {
    int row;
    int col;
    int effort;
    
    public Pair2(int row, int col, int effort) {
        this.row = row;
        this.col = col;
        this.effort = effort;
    }

    // Compare pairs based on the effort required to reach them
    @Override
    public int compareTo(Pair2 other) {
        return this.effort - other.effort;
    }
}


