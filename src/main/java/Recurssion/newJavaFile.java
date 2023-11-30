/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Recurssion;
import java.util.Scanner;


public class newJavaFile {

    public static int findLongestPath(int[][] matrix, int xs, int ys, int xd, int yd) {
        int[][] visited = new int[matrix.length][matrix[0].length];
        return dfs(matrix, xs, ys, xd, yd, visited);
    }

    private static int dfs(int[][] matrix, int currentRow, int currentCol, int destRow, int destCol, int[][] visited) {
        if (!isValid(matrix, currentRow, currentCol) || matrix[currentRow][currentCol] == 0 || visited[currentRow][currentCol] == 1) {
            return -1;
        }

        // Mark the current cell as visited
        visited[currentRow][currentCol] = 1;

        // Check if the destination is reached
        if (currentRow == destRow && currentCol == destCol) {
            return 0;
        }

        // Explore adjacent cells
        int up =  1 + dfs(matrix, currentRow - 1, currentCol, destRow, destCol, visited);
        int down = 1+  dfs(matrix, currentRow + 1, currentCol, destRow, destCol, visited);
        int left = 1 + dfs(matrix, currentRow, currentCol - 1, destRow, destCol, visited);
        int right = 1+ dfs(matrix, currentRow, currentCol + 1, destRow, destCol, visited);

        // Reset the visited status (backtrack)
        visited[currentRow][currentCol] = 0;

        // If any of the paths is impossible, return -1
        if (up == -1 && down == -1 && left == -1 && right == -1) {
            return -1;
        }

        // Return the length of the current path
        return  Math.max(Math.max(up, down), Math.max(left, right));
    }

    private static boolean isValid(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 0, 1, 1, 0, 1, 1, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        int sourceRow = 0, sourceCol = 0;
        int destRow = 1, destCol = 8;

        int result = findLongestPath(matrix, sourceRow, sourceCol, destRow, destCol);

        System.out.println("The length of the longest path is: " + result);
    }
}
