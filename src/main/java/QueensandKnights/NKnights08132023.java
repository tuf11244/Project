/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package QueensandKnights;

/**
 *
 * @author parth
 */
public class NKnights08132023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        int n = 4; 
        boolean[][] board = new boolean[n][n];
        knights(board,0,0,4);
        // TODO code application logic here
    }
    
    public static void knights(boolean[][] board, int row, int column, int knights){
        if(knights == 0){
            display(board);
            System.out.println("");
            return;
        }
        if(row == board.length-1 && column == board.length){
            return;
        }
        if(column == board.length){
            knights(board,row+1,0,knights);
            return;
        }
        if(isSafe(board,row,column)){
            board[row][column] = true;
            knights(board,row,column+1,knights-1);
            board[row][column] = false;
        }
        // The below line tells us if its not safe to put it just move ahead
         knights(board,row,column+1,knights);
    }
    
    public static boolean isSafe(boolean[][] board, int row, int column){
        if(isValid(board,row-2, column-1)){
            if(board[row-2][column-1]){
                return false;
            }
        }
        if(isValid(board,row-2,column+1)){
            if(board[row-2][column+1]){
                return false;
            }
        }
        if(isValid(board,row-1,column-2)){
            if(board[row-1][column-2]){
                return false;
            }
        }
        if(isValid(board,row-1,column+2)){
            if(board[row-1][column+2]){
                return false;
            }
        }
        
        return true;
        
    }
    
    public static boolean isValid(boolean[][] board, int row, int column){
        if(row >= 0  && row < board.length && column >= 0 && column < board.length){
            return true;
        }
        return false;
    }
    
     public static void display(boolean[][] board){
       for(boolean[] row : board){
           for(boolean element : row){
               if(element){
                   System.out.print("K ");
               }
               else{
                   System.out.print("X ");
               }              
           }
           System.out.println("");
       } 
    }
}
