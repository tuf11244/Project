/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package RecurssionPracticeQuestionPart2;

import java.util.Arrays;

/**
 *
 * @author parth
 */
public class FindtheShortestSafeRouteinaPathwithLandmines {

    /**
     * Given a path in the form of a rectangular matrix having few landmines arbitrarily placed (marked as 0), 
     * calculate length of the shortest safe route possible from any cell in the first column to any cell in the last column of the matrix. 
     * We have to avoid landmines and their four adjacent cells (left, right, above and below) as they are also unsafe. 
     * We are allowed to move to only adjacent cells which are not landmines. 
     * i.e. the route cannot contains any diagonal moves.
     * 
     * Landmines are marked with 0;
     * @param args the command line arguments
     */
    public static boolean visited[][];
    public static int min_distance;
    public static int[] rowNumbers = {-1,0,0,1};
    public static int[] columnNumbers = {0,-1,1,0};
    public static void main(String args[]) {
        
        //int[][] board = new int[12][10];
        int[][] board = { 
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
        { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }, 
        { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 }, 
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 }, 
        { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 }, 
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
        { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 }, 
        { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 } };
        
        visited = new boolean[board.length][board[0].length];
        findtheShortestPath(board);
        
    }
    public static void findtheShortestPath(int[][] board){
         min_distance = Integer.MAX_VALUE;
        
        //Mark adjacent cells of landmine as unsafe
        markUnsafeCells(board);
        
        for(int i = 0; i < board.length;i++){
            //if Path is safe from current cell 
            if (board[i][0] == 1){
                //Intialize visited to false
                for(int k = 0; k < board.length;k++){
                   Arrays.fill(visited[k],false); 
                }
                //Find the shorted Route from board[i][0] to
                //board[board.length][board[0].length-1] which
                //is any cell of the last column;
                
                 findtheShortestPathHelper(board,visited,i,0,0);
                 
                 //if min distance is already found 
                 if(min_distance == board[0].length -1){
                     break;
                 }
            }
        }
        
        if(min_distance!= Integer.MAX_VALUE){
            System.out.println("The length of the safe Path is  " + min_distance);
        }else{
            System.out.println("Destination not reachable from the given source");
        }
    }
    public static boolean isValid(int[][] board, int row, int column){
        return row >= 0 && column >= 0 && row < board.length && column < board[0].length;
    }
    public static boolean isSafe(int[][] board, boolean[][] visited,int row, int column){
        return board[row][column] != 0 && !visited[row][column];
    }
    public static void findtheShortestPathHelper(int[][] board, boolean[][] visited, int row, int column, int distance){
        //Reached the last column
        if(column == board[0].length -1){
            
            //update the shortest Path found so far 
            min_distance = Math.min(min_distance, distance);
            return;
        }
        
        //if current distance crosses the minimum distance so far 
        if(distance > min_distance){
            return;
        }
        
        visited[row][column] = true;
        
        //Recurse all four adjace neighbours 
        for(int k = 0; k < 4 ; k++){
            if(isValid(board,row + rowNumbers[k],column + columnNumbers[k]) && isSafe(board,visited,row+rowNumbers[k],column + columnNumbers[k])){
               findtheShortestPathHelper(board,visited,row+rowNumbers[k],column+columnNumbers[k],distance+1);
            }
            
        }
        
        visited[row][column] = false; //backtrack        
        
    }
    
    public static void markUnsafeCells(int[][] board){
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j < board[0].length;j++){
                
                //if landmine is found;
                if(board[i][j] == 0){
                    for(int k = 0; k < 4;k++){
                        //Mark all adjacent cells 
                        if(isValid(board,i+rowNumbers[k],j+columnNumbers[k])){
                            board[i+rowNumbers[k]][j+columnNumbers[k]] = -1;
                        }
                    }
                }
            }
        }
        
        
        //Marks all adjacent cells as unsafe 
        for(int i = 0; i < board.length;i++){
            for(int j = 0; j < board[0].length;j++){
                if(board[i][j] == -1){
                    board[i][j] = 0;
                }
            }
        }
    }



}