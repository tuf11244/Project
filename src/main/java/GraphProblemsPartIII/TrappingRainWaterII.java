/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartIII;
import java.util.*;

/**
 * Date: 01/18/2025
 * https://leetcode.com/problems/trapping-rain-water-ii/
 * Implements the solution to trap rainwater in a 2D grid using a priority queue (min-heap).
 * Approach: Boundary-first BFS
 * Time Complexity: O(n * log(n)), where n is the number of cells in the grid.
 * @author parth
 */
public class TrappingRainWaterII {

    /**
     * Main method - Entry point for testing.
     * @param args Command-line arguments
     */
    public static void main(String args[]) {
        // You can add test cases here, e.g.:
        // int[][] heights = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
        // System.out.println(trapRainWater(heights));
    }
    
    /**
     * Solves the trapping rainwater problem in a 2D grid.
     * @param heights 2D array representing heights of terrain.
     * @return The total amount of water trapped.
     */
    public static int trapRainWater(int[][] heights) {
        // Initialize a visited array to track which cells have been processed.
        boolean visited[][] = new boolean[heights.length][heights[0].length];
        
        // Min-Heap to store the boundary cells sorted by their height.
        PriorityQueue<cell> pq = new PriorityQueue<>();
        
        // Step 1: Add all boundary cells to the priority queue.
        for (int i = 0; i < heights.length; i++) { // For each row
            // Add the first column (left boundary) and mark as visited.
            pq.add(new cell(i, 0, heights[i][0]));
            visited[i][0] = true;
            
            // Add the last column (right boundary) and mark as visited.
            pq.add(new cell(i, heights[0].length - 1, heights[i][heights[0].length - 1]));
            visited[i][heights[0].length - 1] = true;
        }
        
        for (int j = 0; j < heights[0].length; j++) { // For each column
            // Add the first row (top boundary) and mark as visited.
            pq.add(new cell(0, j, heights[0][j]));
            visited[0][j] = true;
            
            // Add the last row (bottom boundary) and mark as visited.
            pq.add(new cell(heights.length - 1, j, heights[heights.length - 1][j]));
            visited[heights.length - 1][j] = true;
        }
        
        // Step 2: Process cells in the priority queue.
        int waterTrapped = 0; // This keeps track of the total trapped water.
        
        while (!pq.isEmpty()) {
            // Pop the cell with the smallest height.
            cell rem = pq.poll();
            
            // Traverse in all 4 directions from the current cell.
            for (int i = 0; i < 4; i++) {
                int newRow = rem.row + directions[i][0]; // New row
                int newCol = rem.col + directions[i][1]; // New column
                
                // Check if the new cell is within bounds and unvisited.
                if (isValid(newRow, newCol, heights) && !visited[newRow][newCol]) {
                    
                    // Calculate the trapped water at this neighboring cell.
                    // Water is trapped only when the boundary height is greater than the cell height.
                    waterTrapped += Math.max(0, rem.height - heights[newRow][newCol]);
                    
                    // Push the neighboring cell into the priority queue with its effective height.
                    // The new height becomes the maximum of the current boundary height and the neighbor's height.
                    pq.add(new cell(newRow, newCol, Math.max(rem.height, heights[newRow][newCol])));
                    
                    // Mark the neighbor as visited.
                    visited[newRow][newCol] = true;
                }
            }
        }
        
        return waterTrapped; // Return the total water trapped.
    }
    
    /**
     * Checks if a given cell is within the bounds of the grid.
     * @param row Row index of the cell.
     * @param col Column index of the cell.
     * @param heights 2D array representing heights of the grid.
     * @return True if the cell is valid, false otherwise.
     */
    public static boolean isValid(int row, int col, int[][] heights) {
        return row >= 0 && row < heights.length && col >= 0 && col < heights[0].length;
    }
    
    // Directions array to simplify moving up, down, left, and right.
    public static int[][] directions = {
        {0, 1},  // Right
        {-1, 0}, // Up
        {1, 0},  // Down
        {0, -1}  // Left
    };
}

/**
 * Cell class represents a grid cell with its row, column, and height.
 * Implements Comparable to allow sorting by height in a priority queue.
 */
class cell implements Comparable<cell> {
    int row;   // Row index of the cell
    int col;   // Column index of the cell
    int height; // Height of the terrain at the cell
    
    /**
     * Constructor to initialize a cell.
     * @param row Row index
     * @param col Column index
     * @param height Height of the terrain
     */
    public cell(int row, int col, int height) {
        this.row = row;
        this.col = col;
        this.height = height;
    }
    
    /**
     * Compares two cells based on their height. Used for priority queue ordering.
     * @param o Other cell to compare to.
     * @return Difference in height between this cell and the other cell.
     */
    public int compareTo(cell o) {
        return this.height - o.height; // Min-Heap based on height
    }
}
