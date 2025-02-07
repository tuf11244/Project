/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestionPart2;


/**
 *
 * @author parth
 */
public class WordSearch {
    static boolean visited[][];

    /**
     * https://leetcode.com/problems/word-search/
     * Date: 08/27/2023
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      //  char[][] board = {[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]}
      char[][] board = {
          {'A','B','C','E'},
          {'S','F','C','S'},
          {'A','D','E','E'}
      };
        System.out.println(exist(board,"BFDEE"));
        // TODO code application logic here
    }
    
    public static boolean exist(char[][] board, String word){
        int row = board.length;
        int column = board[0].length;
        visited = new boolean[row][column];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                if(board[i][j] == word.charAt(0) && search(board,word, i, j, 0)){
                    return true;
                }
            }
        }
        
        return false;
        
    }
    private static boolean isValid(char[][] board, int row, int column) {
       return row >= 0 && row < board.length && column >= 0 && column < board[0].length;
    }
    
    private static boolean search(char[][] board, String word, int row, int column, int index){
        
        if(index == word.length()){
            return true;
        }
         if (!isValid(board, row, column) || board[row][column] != word.charAt(index) || visited[row][column]) {
            return false;
        }
        visited[row][column] = true;
        if (search(board, word, row + 1, column, index + 1) ||
            search(board, word, row, column+1, index + 1) ||
            search(board, word, row-1, column, index + 1) ||
            search(board, word, row, column - 1, index + 1)) {
            return true;
        }
        
        
        visited[row][column] = false;    
        
        return false;
        
    }
    
}
