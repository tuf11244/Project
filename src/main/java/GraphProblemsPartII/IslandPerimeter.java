/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblemsPartII;

/**
 *Date: 06/10/2024
 * https://leetcode.com/problems/island-perimeter/
 * @author parth
 */
public class IslandPerimeter {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
     public static int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // Check each of the four directions
                    if (i == 0 || grid[i - 1][j] == 0) perimeter++; // top
                    if (i == grid.length - 1 || grid[i + 1][j] == 0) perimeter++; // bottom
                    if (j == 0 || grid[i][j - 1] == 0) perimeter++; // left
                    if (j == grid[0].length - 1 || grid[i][j + 1] == 0) perimeter++; // right
                }
            }
        }

        return perimeter;
    }
}
