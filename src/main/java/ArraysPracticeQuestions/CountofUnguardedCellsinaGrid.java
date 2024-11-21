/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

/**
 *Date: 11/20/2024
 * https://leetcode.com/problems/count-unguarded-cells-in-the-grid/
 * @author parth
 */
public class CountofUnguardedCellsinaGrid {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] grid = new char[m][n];

        // Mark guards and walls
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 'G';
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 'W';
        }

        // Directions: up, right, down, left
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        // Mark guarded cells
        for (int[] guard : guards) {
            for (int[] dir : directions) {
                int x = guard[0], y = guard[1];
                while (true) {
                    x += dir[0];
                    y += dir[1];

                    // Stop if out of bounds or hitting a guard/wall
                    if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 'G' || grid[x][y] == 'W') {
                        break;
                    }

                    // Mark cell as guarded if it's not already guarded
                    if (grid[x][y] == 0) {
                        grid[x][y] = 'D';
                    }
                }
            }
        }

        // Count unguarded cells
        int unguardedCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    unguardedCount++;
                }
            }
        }

        return unguardedCount;
    }
}
