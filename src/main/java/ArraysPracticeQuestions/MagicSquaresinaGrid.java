/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

/**
 *Date: 08/09/2024
 *https://leetcode.com/problems/magic-squares-in-grid/
 * @author parth
 */
public class MagicSquaresinaGrid {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;

        // Loop through the grid, stopping before the last 3x3 section
        for (int i = 0; i <= grid.length - 3; i++) {
            for (int j = 0; j <= grid[0].length - 3; j++) {
                if (isMagicSquare(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    // Check if the 3x3 grid starting at (row, col) is a magic square
    private boolean isMagicSquare(int[][] grid, int row, int col) {
        // Check if the numbers are between 1 and 9 and are distinct
        int[] freq = new int[10]; // Frequency array for digits 1 to 9
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                int val = grid[i][j];
                if (val < 1 || val > 9 || freq[val]++ > 0) {
                    return false;
                }
            }
        }

        // Calculate the magic sum
        int sum = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];

        // Check rows
        for (int i = row; i < row + 3; i++) {
            int rowSum = 0;
            for (int j = col; j < col + 3; j++) {
                rowSum += grid[i][j];
            }
            if (rowSum != sum) {
                return false;
            }
        }

        // Check columns
        for (int j = col; j < col + 3; j++) {
            int colSum = 0;
            for (int i = row; i < row + 3; i++) {
                colSum += grid[i][j];
            }
            if (colSum != sum) {
                return false;
            }
        }

        // Check diagonals
        int diagonal1 = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        int diagonal2 = grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col];
        if (diagonal1 != sum || diagonal2 != sum) {
            return false;
        }

        return true;
    }
}
