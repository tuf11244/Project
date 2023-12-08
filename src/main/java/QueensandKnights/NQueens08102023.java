/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package QueensandKnights;

/**
 *
 * @author parth
 */
public class NQueens08102023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        int n = 5;
        boolean[][] board = new boolean[n][n];
        System.out.println(queens(board,0));
        //queens(board,0);
        // TODO code application logic here
    }
    public static int queens(boolean[][] board, int row){
        if(row == board.length){
            display(board);
            System.out.println("");
            return 1;
        }
        int count = 0;
        //placing the Queen and checking for every row and column
        for(int column = 0; column < board.length;column++){
            //Place the queen if its safe
            if(isSafe(board,row,column)){
                board[row][column] = true;
                count = count + queens(board,row+1);
                board[row][column] = false;
            }
        }
        return count;
        
    }
    public static void display(boolean[][] board){
       for(boolean[] row : board){
           for(boolean element : row){
               if(element){
                   System.out.print("Q ");
               }
               else{
                   System.out.print("X ");
               }              
           }
           System.out.println("");
       } 
    }
    public static boolean isSafe(boolean[][] board, int row, int column){
        //check vertical row
        for(int i = 0; i < row; i++){
            if(board[i][column]){
                return false;
            }
        }
        
        //diagonal left
        int maxLeft = Math.min(row, column);
        for(int i = 1; i <= maxLeft;i++){
            if(board[row-i][column-i]){
                return false;
            }
        }
        
        //diagonal right
        int maxRight = Math.min(row,board.length-column-1);
         for(int i = 1; i <= maxRight;i++){
            if(board[row-i][column+i]){
                return false;
            }
        }
        return true;
    }
}
