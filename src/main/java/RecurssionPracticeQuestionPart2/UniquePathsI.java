/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestionPart2;

/**
 * Date: 12/14/2023
 *https://leetcode.com/problems/unique-paths/
 * https://leetcode.com/problems/unique-paths-ii/
 * @author parth
 */
public class UniquePathsI {

    public static boolean visited[][];
    public static void main(String args[]) {
        int m = 3;
        int n = 7;
        
        System.out.println(uniquePaths(m,n));
        int[][] board = {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };
       // System.out.println(uniquePathsII(board,0,0));
        
    }
    public static int uniquePaths(int m, int n){
        return helper(0,0,m,n);
    }
   
    public static int helper(int row, int column, int m, int n){
        if(row == m -1 && column == n -1){
            return 1;
        }
        int right =0;
        int down = 0;
       
       if(row < m-1){
           down = helper(row+1,column,m,n);
       } 
        if(column < n-1){
           right = helper(row,column+1,m,n);
       }       
        return right + down;
    }
    public static int uniquePathsII(int[][] board,int row, int column){
        if(row == board.length-1 && column == board[0].length-1){
            return 1;
        }
        if(board[row][column] == 1){
            return 0;
        }
        int right = 0;
        int down = 0;
        if(row < board.length-1){
            down = uniquePathsII(board,row+1,column);
        }
        if(column < board[0].length-1){
            right = uniquePathsII(board,row,column+1);
        }
        return right+down;
    }
    
}
