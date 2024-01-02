/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package MazeandBacktracking;

/**
 *Date: 12/31/2023
 * https://leetcode.com/problems/surrounded-regions/
 * @author parth
 */
public class SurroundedRegions {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println("Hello World");
		char[][] board = {
		  {'X','X','X','X'},
		  {'X','O','O','X'},
		  {'X','O','O','X'},
		  {'X','X','X','X'}
		};
		print(board);
		solve(board);
		System.out.println();
		print(board);
    }
    public static void solve(char[][] board){
	    
	    //Logic 
	    // We are traversing the boundary of the board and marking the cells that have 'O' as safe meaning they cannot be changed to 'X'
	    //And using the backtracking method we are also marking the 'O' that are connected to the boundary zeroes recursively
	    
	    //For Rows 
	    for(int i = 0; i < board.length;i++){
	        //Any row and column first 
	        if(board[i][0] == 'O'){
	            backtrack(board,i,0);
	        }
	        //Any row and column last
	        if(board[i][board[0].length-1] == 'O'){
	            backtrack(board,i,board[0].length-1);
	        }
	    }
	    
	    //For Columns 
	    for(int j = 0; j < board[0].length;j++){
	        //Any column and row first
	        if(board[0][j] == 'O'){
	            backtrack(board,0,j);
	        }
	        //Any column and row last 
	        if(board[board.length-1][j] == 'O'){
	            backtrack(board,board.length-1,j);
	        }
	        
	    }
	    
	    // Flip remaining 'O' cells to 'X', and revert marked safe cells back to 'O'
	    for(int i = 0; i < board.length;i++){
	        for(int j = 0; j < board[0].length;j++){
	            if(board[i][j] == 'O'){
	                board[i][j] = 'X';
	            }
	            else if(board[i][j] == 'E'){
	                board[i][j] = 'O';
	            }
	        }
	    }
	    
	    
	}
	
	public static boolean isValid(char[][] board, int row, int column){
	    return row  >= 0 && row < board.length && column >= 0 && column < board[0].length;
	}
	public static void backtrack(char[][] board, int row, int column){
	   if(!isValid(board,row,column) || board[row][column] != 'O'){
	       return;
	    }
	    
	    
	    //Mark the the cells visited as safe 
	    board[row][column] = 'E';
	    
	    backtrack(board, row + 1, column);
        backtrack(board, row, column + 1);
        backtrack(board, row - 1, column);
        backtrack(board, row, column - 1);
        
        
	}
	
	public static void print(char[][] board){
	    for(int i = 0; i < board.length;i++){
	        for(int j = 0; j < board[0].length;j++){
	            System.out.print(board[i][j] + " ");
	        }
	        System.out.println();
	    }
	}
}
