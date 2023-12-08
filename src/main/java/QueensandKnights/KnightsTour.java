/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package QueensandKnights;

/**
 *https://www.geeksforgeeks.org/the-knights-tour-problem/
 * Date: 12/07/2023
 * @author parth
 */
public class KnightsTour {
   
    public static void main(String args[]) {
        int n = 8;
        int [][] board = new int[n][n];
        
        boolean answer = KnightsTour(board);
        System.out.println(answer);
        
        
    }
    public static boolean isValid(int[][] board, int row, int column){
        return row >= 0 && column >= 0 && column < board[0].length && row < board.length;
    }
    
    public static boolean KnightsTour(int[][] board){
        
        //Intialize the board
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = -1;
            }
        }
        
        /* xMove[] and yMove[] define next move of Knight. 
           xMove[] is for next value of x coordinate 
           yMove[] is for next value of y coordinate */
        
        int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};
        
        //Since the knight is at the first block 
        board[0][0] = 0;
        
        //Start from 0, 0 and explore all the knights Tour 
        if(!knightsTourHelper(0,0,1,board,xMove,yMove)){
            System.out.println("Solution Doesnt Exist");
            return false;
        } else{
            display(board);
        }
        return true;
    }
    
    public static boolean knightsTourHelper(int row, int column, int knights,int[][] board, int[] xMove, int[] yMove){
        
        //All the knights have been placed
        if(knights == board.length * board[0].length){
            return true;
        }
        for(int k = 0; k < 8;k++){
            int next_row = row + xMove[k];
            int next_column = column + yMove[k];
            
            if(isValid(board,next_row,next_column) && board[next_row][next_column] == -1){
                board[next_row][next_column] = knights; 
                        if(knightsTourHelper(next_row,next_column,knights+1,board,xMove,yMove)){
                            return true;
                        } else{
                            board[next_row][next_column] = -1; //backtracking;
            }
        }
    }
        return false;
    }
    public static void display(int[][] board){
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j < board[0].length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
