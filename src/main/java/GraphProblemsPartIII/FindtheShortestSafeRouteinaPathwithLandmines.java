/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartIII;

import java.util.Arrays;
import java.util.*;
/**
 *https://www.geeksforgeeks.org/find-shortest-safe-route-in-a-path-with-landmines/
 * @author parth
 */
public class FindtheShortestSafeRouteinaPathwithLandmines {

    /**
     * Given a path in the form of a rectangular matrix having few landmines arbitrarily placed (marked as 0), 
     * calculate length of the shortest safe route possible from any cell in the first column to any cell in the last column of the matrix. 
     * We have to avoid landmines and their four adjacent cells (left, right, above and below) as they are also unsafe. 
     * We are allowed to move to only adjacent cells which are not landmines. 
     * i.e. the route cannot contains any diagonal moves.
     * 
     * 
     * 
     * Landmines are marked with 0;
     * 
     * -1: Represents moving up one row.
     *  0: Represents staying in the same row.
     *  0: Represents staying in the same row again.
     *  1: Represents moving down one row.
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        
        //int[][] board = new int[12][10];
        int[][] board = { 
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
        { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }, 
        { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 }, 
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 }, 
        { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 }, 
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
        { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 }, 
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 } };
        
        
        
    }
    
//{ Driver Code Starts



// } Driver Code Ends

    public int[][] directions = {
        {0, 1}, {0, -1}, {-1, 0}, {1, 0}        
    };

    public int findShortestPath(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        Queue<Landmines> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        // Step 1: Mark unsafe cells (-1) after identifying them
        List<int[]> unsafeCells = new ArrayList<>();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    // Collect adjacent cells for marking later
                    for (int[] dir : directions) {
                        int newRow = i + dir[0];
                        int newCol = j + dir[1];
                        if (isValid(newRow, newCol, mat) && mat[newRow][newCol] == 1) {
                            unsafeCells.add(new int[]{newRow, newCol});
                        }
                    }
                } else if (j == 0 && mat[i][j] == 1) {
                    // Enqueue safe first column cells
                    queue.add(new Landmines(i, 0, 1));
                }
            }
        }

        // Mark unsafe cells after iterating
        for (int[] cell : unsafeCells) {
            mat[cell[0]][cell[1]] = -1;
        }

        // Step 2: Perform BFS
        return bfs(queue, mat, visited);
    }

    public int bfs(Queue<Landmines> queue, int[][] mat, boolean[][] visited) {
        int rows = mat.length;
        int cols = mat[0].length;

        // Mark landmines and unsafe cells as visited
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0 || mat[i][j] == -1) {
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Landmines rem = queue.poll();

            // If we reached the last column, return the path length
            if (rem.col == cols - 1) {
                return rem.length;
            }

            // Mark cell as visited
            if (visited[rem.row][rem.col]) continue;
            visited[rem.row][rem.col] = true;

            for (int[] dir : directions) {
                int newRow = rem.row + dir[0];
                int newCol = rem.col + dir[1];

                if (isValid(newRow, newCol, mat) && !visited[newRow][newCol] && mat[newRow][newCol] == 1) {
                    queue.add(new Landmines(newRow, newCol, rem.length + 1));
                }
            }
        }

        return -1;  // No safe path found
    }

    public boolean isValid(int row, int col, int[][] mat) {
        return row >= 0 && row < mat.length && col >= 0 && col < mat[0].length;
    }
}

class Landmines {
    int row, col, length;

    public Landmines(int row, int col, int length) {
        this.row = row;
        this.col = col;
        this.length = length;
    }
}