/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package GraphProblems;

/**
 *https://leetcode.com/problems/number-of-islands/
 * @author parth
 */
public class NumberofIslands {

    /**
     * @param args the command line arguments
     */
    static boolean visited[][];
    public static void main(String args[]) {
        char[][] board = {
          {'1','1','0','0','0'},
          {'1','1','0','0','0'},
          {'0','0','1','0','0'},
          {'0','0','0','1','1'}
      };
       System.out.println(numberofIslands(board));
        // TODO code application logic here
    }
    public static int numberofIslands(char[][] board){
        int row = board.length;
        int column = board[0].length;
        int count = 0;
        visited = new boolean[row][column];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                if(board[i][j] == '1' && !visited[i][j]){
                    count++;
                    search(board,i,j);
                }
            }
        }
        return count;
    }
    public static boolean isValid(char[][] board, int row, int column) {
       return row >= 0 && row < board.length && column >= 0 && column < board[0].length;
    }
    
    public static void search(char[][] board, int row, int column){
      if(!isValid(board,row,column) || visited[row][column] || board[row][column]!= '1'){
          return;
      }
      visited[row][column] = true;
       search(board,row + 1, column);
       search(board,row, column + 1);
       search(board,row - 1, column);
       search(board,row, column - 1);
       
       //visited[row][column] = false;
    }
}
