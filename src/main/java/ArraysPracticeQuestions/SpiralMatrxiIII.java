/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ArraysPracticeQuestions;

/**
 *Date: 01/26/2024
 * https://leetcode.com/problems/spiral-matrix-iii/
 * Source: BinaryMagic 
 * @author parth
 */
public class SpiralMatrxiIII {

    /**
     * @param args the command line arguments
     */
    /*
    Logic:

Initialization:

The result matrix ans is initialized to store the coordinates of the spiral.
The starting position (r, c) is added to ans, and other variables like len, x, y, and index are initialized.
Spiral Traversal:

The traversal is done in four directions: right, down, left, and up.
For each direction, a loop is used to traverse a certain length (len).
The isValid function is used to check whether the next position is within the matrix bounds.
If the position is valid, it is added to the ans array.
Updating Coordinates:

After each traversal in a particular direction, the coordinates (x and y) are updated based on the direction.
The length (len) is also updated, increasing it after moving down or left to ensure the correct spiral pattern.
Repeat Until Full Spiral is Generated:

The process is repeated until the entire matrix is traversed (index < size).
At each step, the coordinates are updated, and the length of movement is adjusted.
The loop ensures that the spiral continues to expand until the entire matrix is covered.
Result:

The final result matrix ans contains the coordinates of the spiral matrix.
    */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public static int[][] spiralMatrixIII(int rows, int cols, int r, int c) {
    int[][] ans = new int[rows * cols][2];
    ans[0] = new int[]{r, c}; // Starting position

    int size = rows * cols;
    int len = 1; // Initial length of movement
    int x = r, y = c; // Current position
    int index = 1; // Index to track the position in the result array

    while (index < size) {
        // Move to the right
        for (int j = 1; j <= len; j++) {
            if (isValid(x, y + j, rows, cols))
                ans[index] = new int[]{x, y + j};
                index++;
        }
        y = y + len; // Update y-coordinate after moving right

        // Move down
        for (int j = 1; j <= len; j++) {
            if (isValid(x + j, y, rows, cols))
                ans[index] = new int[]{x + j, y};
                index++;
        }
        x = x +  len; // Update x-coordinate after moving down
        len++;    // Increase length after moving down is over

        // Move to the left
        for (int j = 1; j <= len; j++) {
            if (isValid(x, y - j, rows, cols))
                ans[index] = new int[]{x, y - j};
                index++;
        }
        y = y - len; // Update y-coordinate after moving left

        // Move up
        for (int j = 1; j <= len; j++) {
            if (isValid(x - j, y, rows, cols))
                ans[index] = new int[]{x - j, y};
                index++;
        }
        x = x - len; // Update x-coordinate after moving up
        len++;
    }

    return ans;  
}

// Check if the given position is within the bounds of the matrix
public static boolean isValid(int i, int j, int rows, int columns) {
    return i >= 0 && i < rows && j >= 0 && j < columns;
}

}
