/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

/**
 *Question 
Given a 4 x 4 matrix, the intial Enery is 100. The task is to reach the last row of the matrix with maximum possible enery left. 

The matrix can be traversd in the following way"
- Start with any cell in the first row;
- In each move, traverse the cell (i,j) of the ith row and jth column to any any existing cell out of(i+1,j-1),(i+1,j) or (i+1,j+1)
- Finish the traversal in the last row 
After stepping on a cell (i,j),energy decrease by matrix[i][j] units. Find the maximum possible energy left at the end of the traversal. 

Note: The final energy can be negative
 * @author parth
 */
public class MatrixTraversal {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int[][] matrix = {
		    {10,20,30,40},
		    {60,50,20,80},
		    {10,10,10,10},
		    {60,50,60,50}
		};
	int intialEnergy = 100;
	int result = maxEnergy(matrix, 0, 0, intialEnergy);
        System.out.println("Maximum possible energy left: " + result);
    }
    public static boolean isValid(int[][] matrix, int row,int column){
	    return row >= 0 && row < matrix.length && column >= 0 && column < matrix[0].length;
   }
    public static int maxEnergy(int[][] matrix, int row, int col, int energy) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Base case: reached the last row
        if (row == rows - 1) {
            return energy - matrix[row][col];
        }
        if(!isValid(matrix,row,col)){
            return 0;
        }

        // Explore all possible moves to the next row
        int moveLeft = maxEnergy(matrix, row + 1, col - 1, energy - matrix[row][col]);
        int moveDown = maxEnergy(matrix, row + 1, col, energy - matrix[row][col]);
        int moveRight = maxEnergy(matrix, row + 1, col + 1, energy - matrix[row][col]);

        // Return the maximum energy obtained from the current cell
        return Math.max(Math.max(moveLeft, moveDown), moveRight);
    }
}
