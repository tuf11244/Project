/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DPPartII;

/**
 *Date: 09/14/2024
 * https://leetcode.com/problems/knight-probability-in-chessboard/
 * @author parth
 */
public class KnightsProbabilityinChessboard {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
    public int[][] direction = {
        {1, 2}, {1, -2}, {-1, 2}, {-1, -2},
        {2, 1}, {2, -1}, {-2, 1}, {-2, -1}
    };
    
    public double knightProbability(int n, int k, int row, int column) {
        return helper(n, k, row, column, new Double[n][n][k + 1]);
    }

    public double helper(int n, int k, int row, int column, Double dp[][][]) {
        // If knight is out of the board, probability is 0
        if (row < 0 || row >= n || column < 0 || column >= n) {
            return 0.0;
        }
        
        // If no more moves left, probability is 1 (knight stays on the board)
        if (k == 0) {
            return 1.0;
        }

        // If we have already calculated this state, return it
        if (dp[row][column][k] != null) {
            return dp[row][column][k];
        }

        // Accumulate the probability from all valid moves
        double probability = 0.0;
        for (int[] dir : direction) {
            int newRow = row + dir[0];
            int newCol = column + dir[1];
            probability += helper(n, k - 1, newRow, newCol, dp);
        }

        // Divide by 8 to account for the 8 possible moves
        dp[row][column][k] = probability / 8.0;
        return dp[row][column][k];
    }
}
