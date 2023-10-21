/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package PracticeQuestions;

import java.util.Arrays;

/**
 * Date: 10/21/2023
 *https://leetcode.com/problems/flood-fill/description/
 * @author parth
 */
public class FloodFill {

    /**
     * @param args the command line arguments
     */
    static boolean visited[][];
    public static void main(String args[]) {
       int[][] board = {
           {1,1,1},
           {1,1,0},
           {1,0,1}
       };
       for(int[] arr : floodfill(board,1,1,2)){
           System.out.println(Arrays.toString(arr));
       }
    }
 public static int[][] floodfill(int[][] board, int sr, int sc, int color){
    int originalColor = board[sr][sc];
    if (originalColor == color) {
        return board;
    }
    fill(board, sr, sc, originalColor, color);
    return board;
}

public static void fill(int[][] board, int row, int col, int originalColor, int newColor) {
    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != originalColor) {
        return;
    }
    board[row][col] = newColor;
    fill(board, row + 1, col, originalColor, newColor);
    fill(board, row - 1, col, originalColor, newColor);
    fill(board, row, col + 1, originalColor, newColor);
    fill(board, row, col - 1, originalColor, newColor);
}
  
       
}
