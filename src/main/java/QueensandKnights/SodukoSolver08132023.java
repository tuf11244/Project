/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package QueensandKnights;

/**
 *
 * @author parth
 */
public class SodukoSolver08132023 {

    /**
     * https://leetcode.com/problems/sudoku-solver/
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         int[][] board = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
         
         System.out.println(sudokoSolver(board));
        // TODO code application logic here
    }
    public static boolean sudokoSolver(int[][] board){
        int n = board.length;
        int row = -1; 
        int column = -1; 
   
        boolean emptyleft = true;
        
        //this how we are replacing row and column from arguments
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n;j++){
                if(board[i][j] == 0){
                    row = i;
                    column = j;
                    emptyleft = false;
                    break;
                }
            }     
        //if you empty elements in the row, then just break;
        if(emptyleft == false){
            break;
        }       
        }
        if(emptyleft == true){
            return true;
            //meaning the soduko is solved;
        }
        //backtracking
        for (int number = 1; number <= 9;number++){
          if(isSafe(board,row,column,number)){
                board[row][column] = number;
                if(sudokoSolver(board)){
                    // found the answer 
                    display(board);
                    System.out.println(" ");
                    return true;
                }else{
                    //backtracking
                    board[row][column] = 0;
                }
            }            
        }
        return false;
    }
    
    public static void display(int[][] board){
        for(int[] row : board ){
            for(int num : row){
                System.out.print(num + " ");
            }
                System.out.println();
        }
    }
    
    public static boolean isSafe(int[][] board, int row, int column, int number){
        //Check the row 
        for(int i = 0; i < board.length;i++){
            //check if the number is in the row or not 
            if(board[row][column] == number){
                return false;
            }
        }       
        //Check the column
        for(int[] nums : board){
            if(nums[column] == number){
                return false;
            }                
        }
        //Check the starting point of the matrix 3 * 3
        int sqrt = (int)(Math.sqrt(board.length));
        int rowstart = row - row%sqrt;
        int columnstart = column - column%sqrt;
        
        for(int r = rowstart; r < rowstart + sqrt; r++){
            for(int c = columnstart; c < columnstart + sqrt; c++){
                if(board[r][c] == number){
                    return false;
                }
            }
        }
        return true;
        
    }
}
