/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestion;

import java.util.Scanner;

/**
 *https://www.hackerrank.com/challenges/crossword-puzzle/problem
 * Date: 11/23/2023
 * @author parth
 */
public class CrossWordPuzzle {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[10][10];
        
        System.out.println("Enter the crossword board row by row (use '-' for empty cells):");
        for(int i = 0; i < board.length;i++){
            String str = scanner.next();
            board[i] = str.toCharArray();
        }
        
        System.out.println("Enter the number of words to place on the crossword board:");
        int n = scanner.nextInt();
        String[] words = new String[n];
        
        for(int i = 0; i < words.length;i++){
            words[i] = scanner.next();
        }
        
        //Solve the puzzle 
        solve(board,words,0);
        
    }
    public static void print(char[][] board){
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j < board[0].length;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }
    public static void solve(char[][] board, String[] words, int pointer){
        String word = words[pointer];
        if(pointer == words.length){
            print(board);
            return;
        }
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j < board[0].length;j++){
                if(board[i][j] == '-' || board[i][j] == word.charAt(0)){
                    if(canPlaceHorizontally(board,word,i,j)){
                     boolean[] wePlaced = placeHorizontally(board,word,i,j);
                        solve(board,words,pointer+1);
                        unplaceHorizontally(board,wePlaced,i,j);
                    }
                }
                    if(canPlaceVertically(board,word,i,j)){
                     boolean[] wePlaced  = placeVertically(board,word,i,j);
                        solve(board,words,pointer+1);
                        unplaceVertically(board,wePlaced,i,j);
                }
            }
        }
    }
   
    //canPlaceHorizontally Function 
    public static boolean canPlaceHorizontally(char[][] board, String word, int i, int j){
        //check left side
        if(j-1 >= 0 && board[i][j-1] != '+'){
            return false;
        }
        //check right side
        else if(j + word.length() < board[0].length && board[i][j+word.length()] != '+'){
            return false;
        }
        
        for(int jj = 0; jj < word.length();jj++){
            if(board[i][j+jj] == '-' || board[i][j+jj] == word.charAt(jj)){
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    
    public static boolean canPlaceVertically(char[][] board, String word, int i, int j){
        //check above side
        if(i-1 >= 0 && board[i-1][j] != '+'){
            return false;
        }
        //check down side
        else if(i + word.length() < board.length && board[i+word.length()][j] != '+'){
            return false;
        }
        
        for(int ii = 0; ii < word.length();ii++){
            if(board[i+ii][j] == '-' || board[i+ii][j] == word.charAt(ii)){
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    
    public static boolean[] placeHorizontally(char[][] board, String word, int i, int j){
        boolean[] wePlaced = new boolean[word.length()];
        
        for(int jj = 0; jj < word.length();jj++){
            if(board[i][j+jj] == '-'){
                board[i][j+jj] = word.charAt(jj);
                wePlaced[jj] = true;
            }
        }
               return wePlaced;
            
    }
    public static boolean[] placeVertically(char[][] board, String word, int i, int j){
        boolean[] wePlaced = new boolean[word.length()];
        
        for(int ii = 0; ii < word.length();ii++){
            if(board[i+ii][j] == '-'){
                board[i+ii][j] = word.charAt(ii);
                wePlaced[ii] = true;
            }
        }
               return wePlaced;
            
    }
    
    public static void unplaceHorizontally(char[][] board, boolean[] wePlaced, int i, int j){
        for(int jj = 0; jj < wePlaced.length;jj++){
            if(wePlaced[jj] == true){
                board[i][j+jj] = '-';
            }
        }
    }
    public static void unplaceVertically(char[][] board, boolean[] wePlaced, int i, int j){
        for(int ii = 0; ii < wePlaced.length;ii++){
            if(wePlaced[ii] == true){
                board[i+ii][j] = '-';
            }
        }
    }
}
