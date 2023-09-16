/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package TicTacToe;

import java.util.Scanner;

/**
 *
 * @author parth
 */
public class TicTacToe {

    /**
     * Date: 09/15/2023
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        char[][] board = new char[3][3];
         for(int row = 0; row < board.length;row++){
                for(int column = 0; column < board[row].length;column++){
                    board[row][column] = ' ';
                }
            }
        char player = 'X';
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);
        
        while(!gameOver){
            printBoard(board);
            System.out.println("Player " + player + " enter : " );
            int row = scanner.nextInt();
            int column = scanner.nextInt();
            System.out.println(" ");
            
            if(board[row][column] == ' '){
                board[row][column] = player; ///place the element
                gameOver = haveWon(board,player);
                if(gameOver){
                    System.out.println("Player " + player + " has won");
                }else{
                    if(player == 'X'){
                        player = 'O';
                    }else{
                        player = 'X';
                    }
                }       
        }else{
                System.out.println("Invalid Move---try again");
            }       
        
    }
        printBoard(board);
    }
 private static void printBoard(char[][] board) {
        for(int row = 0; row < board.length;row++){
            for(int column = 0; column < board[0].length;column++){
                System.out.print(board[row][column] + " | ");
            }
            System.out.println("");
        }
    }
 private static boolean haveWon(char[][] board, char player){
     
     //check for the row
     for(int row = 0; row < board.length;row++){
         if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
             return true;
         }            
     }
     //check for the column
      for(int column = 0; column < board[0].length;column++){
         if(board[0][column] == player && board[1][column] == player && board[2][column] == player){
             return true;
         }            
     }
      //check for the diagonal
      if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
          return true;
      }
      if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
          return true;
      }
        return false;
 }
}
